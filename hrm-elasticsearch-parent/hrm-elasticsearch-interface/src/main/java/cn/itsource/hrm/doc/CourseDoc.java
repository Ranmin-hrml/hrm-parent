package cn.itsource.hrm.doc;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author ranmin
 * @version v1.0.0
 * @date 2020-06-24
 */
@Document(indexName = "hrm")
@Data
public class CourseDoc {

    //关键字查询的时候 (name type tenantName)   IO流 Java 源码时代 ===  IO 流  Java  源码 时代  源码时代
    private String all;

    private Long id;

    private String name;
    private String users;

    private Long courseTypeId;

    private String gradeName;
    private Long grade;

    private String tenantName;
    private Long tenantId;

    private Long startTime;
    private String pic;

    private Float price;





}
