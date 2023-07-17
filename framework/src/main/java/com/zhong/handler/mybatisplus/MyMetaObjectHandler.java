package com.zhong.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhong
 * @date 2023/7/14
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", new Date(), metaObject);
//        setFieldValByName("createBy", 1, metaObject);
        setFieldValByName("updateTime", new Date(), metaObject);
//        setFieldValByName("updateBy", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
//        setFieldValByName("updateBy", 1, metaObject);
    }
}
