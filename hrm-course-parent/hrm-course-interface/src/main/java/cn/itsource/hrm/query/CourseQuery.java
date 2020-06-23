package cn.itsource.hrm.query;

import lombok.Data;

/**
 * <p>
 *  查询参数对象
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
@Data
public class CourseQuery extends BaseQuery {

    private Integer status;
}