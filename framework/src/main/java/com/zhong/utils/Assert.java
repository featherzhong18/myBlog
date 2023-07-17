package com.zhong.utils;

import com.zhong.enums.AppHttpCodeEnum;
import com.zhong.exception.SystemException;
import org.springframework.lang.Nullable;

/**
 * @author zhong
 * @date 2023/7/17
 */
public class Assert {
    private Assert() {
    }

    /**
     * 断言对象不为空，为空则抛出异常
     * @param object 对象
     * @param codeEnum 状态码枚举类
     * @throws SystemException 系统异常
     */
    public static void notNull(@Nullable Object object, AppHttpCodeEnum codeEnum) {
        if (object == null) {
            throw new SystemException(codeEnum);
        }
    }

    /**
     * 断言对象为空，否则抛出异常
     * @param object 对象
     * @param codeEnum 状态码枚举类
     * @throws SystemException 系统异常
     */
    public static void isNull(Object object, AppHttpCodeEnum codeEnum) {
        if (object != null) {
            throw new SystemException(codeEnum);
        }
    }

    /**
     * 断言标志为真
     * @param flag 标志
     * @param codeEnum 状态码枚举类
     * @throws SystemException 系统异常
     */
    public static void isTrue(boolean flag, AppHttpCodeEnum codeEnum) {
        if (!flag) {
            throw new SystemException(codeEnum);
        }
    }
}
