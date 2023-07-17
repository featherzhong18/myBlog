package com.zhong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhong.domain.dto.UserDto;
import com.zhong.domain.ResponseResult;
import com.zhong.domain.entity.User;

public interface UserService extends IService<User> {
    ResponseResult register(UserDto userDto);
}
