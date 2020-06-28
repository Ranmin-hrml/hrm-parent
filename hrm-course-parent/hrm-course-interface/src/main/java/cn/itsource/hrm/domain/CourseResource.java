package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_course_resource")
public class CourseResource implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 图片id
     */
    private String resources;


}
