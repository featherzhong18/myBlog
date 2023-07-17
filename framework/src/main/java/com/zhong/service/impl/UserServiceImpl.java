package com.zhong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhong.domain.dto.UserDto;
import com.zhong.dao.UserMapper;
import com.zhong.domain.ResponseResult;
import com.zhong.domain.entity.User;
import com.zhong.enums.AppHttpCodeEnum;
import com.zhong.service.UserService;
import com.zhong.utils.Assert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zhong
 * @date 2023/7/17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }
    @Override
    public ResponseResult register(UserDto userDto) {
        // 判断用户是否存在
        LambdaQueryWrapper<User> sameNameWrapper = new LambdaQueryWrapper<>();
        sameNameWrapper.eq(User::getUsername, userDto.getUsername());
        User sameNameUser = getOne(sameNameWrapper);
        Assert.isNull(sameNameUser, AppHttpCodeEnum.USERNAME_EXIST);
        // 判断邮箱是否存在
        LambdaQueryWrapper<User> sameEmailWrapper = new LambdaQueryWrapper<>();
        sameEmailWrapper.eq(User::getEmail, userDto.getEmail());
        User sameEmailUser = getOne(sameEmailWrapper);
        Assert.isNull(sameEmailUser, AppHttpCodeEnum.EMAIL_EXIST);
        // 加密
        String password = passwordEncoder.encode(userDto.getPassword());
        User user = userDto.toUser();
        user.setPassword(password);
        // 添加到数据库中并返回id
        save(user);
        Long registerUserId = user.getId();
        return ResponseResult.okResult(registerUserId);
    }
}
