package com.zhong.controller;

import com.zhong.domain.ResponseResult;
import com.zhong.domain.dto.UserDto;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhong
 * @date 2023/7/14
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }
}
