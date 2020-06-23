package cn.itsource.hrm.controller.vo;

import lombok.Data;

@Data
public class CourseAddVo {
    /**
     * 课程名称
     */
    private String name;
    /**
     * 适用人群
     */
    private String users;
    /**
     * 课程分类
     */
    private Long courseTypeId;
    /**
     * 课程等级
     */
    private Long grade;
    /**
     * 课程列表页展示课程的图片
     */
    private String pic;
    /**
     * 简介
     */
    private String intro;
    /**
     * 详情
     */
    private String description;
}
