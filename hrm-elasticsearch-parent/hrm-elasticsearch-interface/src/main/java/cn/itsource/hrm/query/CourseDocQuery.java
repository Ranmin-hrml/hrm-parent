package cn.itsource.hrm.query;

import lombok.Data;

@Data
public class CourseDocQuery extends BaseQuery {
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
