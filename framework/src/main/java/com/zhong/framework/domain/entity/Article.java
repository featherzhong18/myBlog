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
@TableName("t_article")
@Data
@NoArgsConstructor
@ToString
public class Article implements Serializable {
    private static final long serialVersionUID = -3250680438051303592L;
    /* ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    /* 标题 */
    private String title;
    /* 文章内容 */
    private String content;
    /* 文章摘要 */
    private String summary;
    /* 所属分类id */
    private Integer categoryId;
    /* 所属分类名 */
    @TableField(exist = false)
    private String categoryName;
    /* 缩略图 */
    private String thumbnail;
    /* 是否置顶：0——否，1——是 */
    private Character isTop;
    /* 状态：0——已发布，1——草稿 */
    private Character status;
    /* 浏览量 */
    private Long viewCount;
    /* 是否允许评论：0——否，1——是 */
    private Character isComment;
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
