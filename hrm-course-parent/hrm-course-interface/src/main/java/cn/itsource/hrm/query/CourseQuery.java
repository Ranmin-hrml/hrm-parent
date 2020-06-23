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

    //最大价格
    private Float priceMax;
    //最小价格
    private Float priceMin;
    //课程类型
    private Long productType;
    //排序字段
    private String sortField;
    //排序方式 asc,desc
    private String sortType;

    private Integer status;
}