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
@TableName("t_tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 6343836638107777061L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    /* 标签名称 */
    private String name;
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
