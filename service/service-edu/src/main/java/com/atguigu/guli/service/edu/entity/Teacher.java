package com.atguigu.guli.service.edu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.atguigu.guli.service.base.model.BaseEntity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author Helen
 * @since 2020-08-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("edu_teacher")
@ApiModel(value = "Teacher对象",description = "讲师")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 讲师姓名
     */
    @ApiModelProperty(value = "教师姓名",example = "Helen")
    private String name;

    /**
     * 讲师简介
     */
    private String intro;

    /**
     * 讲师资历,一句话说明讲师
     */
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Integer level;

    /**
     * 讲师头像
     */
    private String avatar;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 入驻时间
     */
    @ApiModelProperty(value = "入驻时间",example = "2020-01-01")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date joinDate;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
