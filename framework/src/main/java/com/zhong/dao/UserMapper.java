package com.zhong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhong.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
