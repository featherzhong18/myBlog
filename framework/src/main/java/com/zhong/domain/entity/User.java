package com.zhong.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhong
 * @date 2023/7/14
 */
@TableName("t_user")
@Data
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 390745714345645196L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    /* 用户名 */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /* 昵称 */
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    /* 个性签名 */
    @Length(max = 64, message = "个性签名的长度不能超过 64 个字符")
    private String signature;
    /* 密码 */
    @NotBlank(message = "密码不能为空")
    private String password;
    /* 用户类型：0——普通用户，1——管理员，其它可扩展 */
    private Character type;
    /* 用户状态：0——正常，1——停用 */
    private Character status;
    /* 邮箱 */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    /* 手机号 */
    private String phoneNumber;
    /* 性别：0——男，1——女，2——未知 */
    private Character gender;
    /* 头像 */
    private String avatar;
    /* 创建者 */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    /* 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /* 更新者 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    /* 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /* 逻辑删除标志位：0——未删除，1——已删除 */
    private Integer delFlag;
}
