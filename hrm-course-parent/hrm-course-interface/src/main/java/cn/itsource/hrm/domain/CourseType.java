package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程目录
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_course_type")
public class CourseType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("createTime")
    private Long createTime;

    @TableField("updateTime")
    private Long updateTime;

    /**
     * 类型名
     */
    private String name;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 图标
     */
    private String logo;

    /**
     * 描述
     */
    private String description;

    @TableField("sortIndex")
    private Integer sortIndex;

    /**
     * 路径
     */
    private String path;

    /**
     * 课程数量
     */
    @TableField("totalCount")
    private Integer totalCount;

    @TableField(exist = false)
    private List<CourseType> children = new ArrayList<> ();

}
