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

    /**
     * 课程类型
     */
    private Long courseType;
    /**
     * 最大价格
     */
    private Float maxPrice;
    /**
     * 最小价格
     */
    private Float minPrice;

    private Long tenantId;


    /**
     * 排序的列名
     *     xp 新品
     *     jg 价格
     */
    private String columnName;
    /**
     * 排序方式
     *      asc  升序
     *      desc  降序
     */
    private String orderType;
}