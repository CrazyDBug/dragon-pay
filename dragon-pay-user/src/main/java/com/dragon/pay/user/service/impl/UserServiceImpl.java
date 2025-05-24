package com.dragon.pay.user.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragon.pay.enums.UserBusinessResponseEnum;
import com.dragon.pay.user.entity.User;
import com.dragon.pay.user.form.LoginForm;
import com.dragon.pay.user.form.RegisterUserForm;
import com.dragon.pay.user.mapper.UserMapper;
import com.dragon.pay.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 用户注册
     */
    @Override
    public String registerCustomer(RegisterUserForm form) {
        // 通过用户名判断是否已存在
        Long l = baseMapper.selectCount(new QueryWrapper<User>().eq("username", form.getUsername()));
        UserBusinessResponseEnum.USER_HAS_REGISTER.assertIsFalse(l > 0);
        User user = User.builder().username(form.getUsername()).password(form.getPassword()).build();
        baseMapper.insert(user);
        return user.getId().toString();
    }

    @Override
    public String login(LoginForm form) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        User user = User.builder().username(form.getUsername()).password(form.getPassword()).status(true).build();
        queryWrapper.setEntity(user);
        User selected = baseMapper.selectOne(queryWrapper);
        UserBusinessResponseEnum.USER_NOT_FOUND.assertNotNull(selected);
        return selected.getId().toString();
    }

}
