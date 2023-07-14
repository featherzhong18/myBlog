package com.zhong.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhong
 * @date 2023/7/14
 */
@Data
@NoArgsConstructor
@ToString
@TableName("t_access")
public class Access implements Serializable {
    private static final long serialVersionUID = 4467074047819638755L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    /* 权限名称 */
    private String accessName;
    /* 权限标识 */
    private String permission;
    /* 权限状态：0——正常，1——停用 */
    private Character status;
    /* 备注 */
    private String remark;
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
