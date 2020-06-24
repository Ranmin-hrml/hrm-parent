package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_course")
public class Course implements Serializable {

    //课程状态0未上线 ， 1 已经上线
    public static final int STATUS_OFFLINE = 0;
    public static final int STATUS_ONLINE = 1;

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 适用人群
     */
    private String users;

    /**
     * 课程大分类
     */
    private Long courseTypeId;

    @TableField("gradeName")
    private String gradeName;

    /**
     * 课程等级
     */
    private Long grade;

    /**
     * 课程状态
     */
    private Integer status = STATUS_OFFLINE;

    /**
     * 教育机构
     */
    private Long tenantId;

    @TableField("tenantName")
    private String tenantName;

    /**
     * 创建用户
     */
    private Long userId;

    @TableField("userName")
    private String userName;
    @TableField("startTime")
    private Date startTime;
    @TableField("endTime")
    private Date endTime;

    private String pic;

    @TableField(exist = false)
    private CourseType courseType;

    //购买数量
    private Integer buyNumber = 0;
    //浏览数量
    private Integer browseNumber = 0;
    //评论数
    private Integer commentNumber = 0;
}
