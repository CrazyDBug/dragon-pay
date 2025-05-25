package com.dragon.pay.merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dragon.pay.enums.MerchantBusinessResponseEnum;
import com.dragon.pay.merchant.entity.MerchantAccount;
import com.dragon.pay.merchant.form.MerchantLoginForm;
import com.dragon.pay.merchant.form.MerchantRegisterForm;
import com.dragon.pay.merchant.form.SendCodeForm;
import com.dragon.pay.merchant.mapper.MerchantAccountMapper;
import com.dragon.pay.merchant.service.MerchantAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 商户登录账户表 服务实现类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-25
 */
@Slf4j
@Service
public class MerchantAccountServiceImpl extends ServiceImpl<MerchantAccountMapper, MerchantAccount> implements MerchantAccountService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String VERIFY_CODE_PREFIX = "merchant:verify:";
    private static final long VERIFY_CODE_EXPIRE = 5; // 验证码有效期5分钟

    /*
     * 商户注册
     */
    @Override
    public String register(MerchantRegisterForm form) {
        log.info("开始商户注册: phone={}, registerType={}", form.getPhone(), form.getRegisterType());

        // 1. 验证手机号是否已注册
        Long count = baseMapper.selectCount(new LambdaQueryWrapper<MerchantAccount>()
                .eq(MerchantAccount::getPhone, form.getPhone()));
        MerchantBusinessResponseEnum.PHONE_HAS_REGISTER.assertIsFalse(count > 0);

        // 2. 验证验证码
        String redisKey = String.format("merchant:verify:%s:%s", "register", form.getPhone());
        String savedCode =
                redisTemplate.opsForValue().get(redisKey);

        // 2.1 验证码不存在或已过期
        MerchantBusinessResponseEnum.CODE_NOT_EXIST.assertIsFalse(savedCode == null);

        // 2.2 验证码错误
        MerchantBusinessResponseEnum.CODE_IS_ERROR.assertIsFalse(!savedCode.equals(form.getCode()));

        // 3. 创建商户账户
        MerchantAccount account = MerchantAccount.builder()
                .phone(form.getPhone())
                .status(true)
                .build();

        // 4. 根据注册类型处理密码
        if ("password".equals(form.getRegisterType())) {
            // 4.2 加密密码
            String password = form.getPassword();
            MerchantBusinessResponseEnum.PASSWORD_NOT_NULL.assertIsFalse(password == null || password.trim().isEmpty());
            account.setPassword(passwordEncoder.encode(password));        }

        try {
            // 5. 保存账户信息
            baseMapper.insert(account);

            // 6. 删除验证码
            redisTemplate.delete(redisKey);

            log.info("商户注册成功: phone={}, registerType={}, accountId={}",
                    form.getPhone(), form.getRegisterType(), account.getId());

            return account.getId().toString();
        } catch (Exception e) {
            log.error("商户注册失败: phone={}, error={}", form.getPhone(), e.getMessage(), e);
            throw new RuntimeException("商户注册失败，请稍后重试");
        }
    }

    @Override
    public String sendCode(SendCodeForm form) {
        // 1. 生成6位数字验证码
        String code = String.format("%06d", (int) (Math.random() * 1000000));
        // 2. 存入Redis，key中加入用途标识
        String redisKey = String.format("merchant:verify:%s:%s", form.getPurpose(), form.getPhone());
        redisTemplate.opsForValue().set(redisKey, code, 5, TimeUnit.MINUTES);
        log.info("向手机号 {} 发送{}验证码: {}", form.getPhone(), form.getPurpose(), code);
        // 3. 返回验证码（生产环境应通过短信发送）
        return code;
    }

    @Override
    public String login(MerchantLoginForm form) {
        log.info("开始商户登录: phone={}, loginType={}", form.getPhone(), form.getLoginType());

        // 1. 查询商户账户
        MerchantAccount account = baseMapper.selectOne(new LambdaQueryWrapper<MerchantAccount>()
                .eq(MerchantAccount::getPhone, form.getPhone()));

        MerchantBusinessResponseEnum.PHONE_NOT_REGISTER.assertIsFalse(account == null);
        MerchantBusinessResponseEnum.ACCOUNT_IS_DISABLED.assertIsFalse(account.getStatus() == false);


        // 2. 根据登录类型验证
        if ("code".equals(form.getLoginType())) {
            // 2.1 验证码登录
            String redisKey = String.format("merchant:verify:%s:%s", "login", form.getPhone());
            String savedCode = redisTemplate.opsForValue().get(redisKey);

            // 2.1.1 验证码不存在或已过期
            MerchantBusinessResponseEnum.CODE_NOT_EXIST.assertIsFalse(savedCode == null);

            // 2.1.2 验证码错误
            MerchantBusinessResponseEnum.CODE_IS_ERROR.assertIsFalse(!savedCode.equals(form.getCode()));

            // 2.1.3 删除验证码
            redisTemplate.delete(redisKey);
        } else {
            // 2.2 密码登录
            MerchantBusinessResponseEnum.PASSWORD_NOT_NULL.assertIsFalse(form.getPassword() == null);
            MerchantBusinessResponseEnum.PASSWORD_ERROR.assertIsFalse(
                    !passwordEncoder.matches(form.getPassword(), account.getPassword()));
        }

        log.info("商户登录成功: phone={}, loginType={}, accountId={}",
                form.getPhone(), form.getLoginType(), account.getId());

        return account.getId().toString();
    }

}
