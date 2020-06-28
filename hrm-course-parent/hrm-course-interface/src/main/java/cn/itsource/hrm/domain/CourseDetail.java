package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ranmin
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_course_detail")
public class CourseDetail implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 详情
     */
    private String description;

    /**
     * 简介
     */
    private String intro;

    private Long courseId;


}
