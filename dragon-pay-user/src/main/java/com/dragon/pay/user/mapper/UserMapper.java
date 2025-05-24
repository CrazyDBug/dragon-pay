package com.dragon.pay.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.pay.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 赌狗
 * @since 2025-05-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
