package com.zhong.domain.entity;

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
@TableName("t_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 7697934796578518564L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    /* 分类名称 */
    private String name;
    /* 父分类ID，-1表示没有 */
    private long pid;
    /* 分类描述 */
    private String description;
    /* 分类状态：0——正常，1——停用 */
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
}
