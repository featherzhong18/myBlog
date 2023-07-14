package com.zhong.framework.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhong
 * @date 2023/7/14
 */
@TableName("t_role")
@Data
@NoArgsConstructor
@ToString
public class Role implements Serializable {
    private static final long serialVersionUID = 3613497756670879136L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /* 角色名称 */
    private String name;
    /* 角色权限字符串 */
    private String roleKey;
    /* 角色状态：0——正常，1——停用 */
    private Character status;
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
    /* 备注 */
    private String remark;
    /* 权限集合 */
    private List<Long> accessIds;
}
