package com.dragon.pay.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragon.pay.enums.UserBusinessResponseEnum;
import com.dragon.pay.user.entity.User;
import com.dragon.pay.user.form.LoginForm;
import com.dragon.pay.user.form.RegisterUserForm;
import com.dragon.pay.user.mapper.UserMapper;
import com.dragon.pay.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.regex.Pattern;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 使用更高的强度，生产环境推荐 12-14
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    
    // 密码复杂度正则表达式
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    
    // 常见密码列表（实际应用中应该从配置文件或数据库加载）
    private static final String[] COMMON_PASSWORDS = {
        "password", "123456", "qwerty", "admin", "welcome"
    };

    /**
     * 验证密码复杂度
     */
    private void validatePassword(String username, String password) {
        // 检查密码长度
        if (password.length() < 8) {
            throw new IllegalArgumentException("密码长度必须至少为8位");
        }
        
        // 检查密码复杂度
        if (!Pattern.matches(PASSWORD_PATTERN, password)) {
            throw new IllegalArgumentException("密码必须包含大小写字母、数字和特殊字符");
        }
        
        // 检查是否包含用户名
        if (password.toLowerCase().contains(username.toLowerCase())) {
            throw new IllegalArgumentException("密码不能包含用户名");
        }
        
        // 检查是否是常见密码
        for (String commonPassword : COMMON_PASSWORDS) {
            if (password.toLowerCase().equals(commonPassword)) {
                throw new IllegalArgumentException("不能使用常见密码");
            }
        }
    }

    /**
     * 用户注册
     */
    @Override
    public String registerCustomer(RegisterUserForm form) {
        // 验证密码复杂度
        // validatePassword(form.getUsername(), form.getPassword());
        
        // 通过用户名判断是否已存在
        Long l = baseMapper.selectCount(new QueryWrapper<User>().eq("username", form.getUsername()));
        UserBusinessResponseEnum.USER_HAS_REGISTER.assertIsFalse(l > 0);
        
        // 使用 BCrypt 加密密码
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        log.info("注册用户: username={}, 原始密码={}, 加密后密码={}", form.getUsername(), form.getPassword(), encodedPassword);
        
        User user = User.builder()
                .username(form.getUsername())
                .password(encodedPassword)
                .status(true)
                .build();
        baseMapper.insert(user);
        return user.getId().toString();
    }

    @Override
    public String login(LoginForm form) {
        // 先查询用户是否存在
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, form.getUsername()));
        
        if (user == null) {
            log.info("登录失败: 用户不存在 username={}", form.getUsername());
            UserBusinessResponseEnum.USER_NOT_FOUND.assertNotNull(null);
        }
        
        // 验证密码
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            log.info("登录失败: 密码错误 username={}", form.getUsername());
            UserBusinessResponseEnum.USER_NOT_FOUND.assertNotNull(null);
        }
        
        log.info("登录成功: username={}", form.getUsername());
        return user.getId().toString();
    }
}
