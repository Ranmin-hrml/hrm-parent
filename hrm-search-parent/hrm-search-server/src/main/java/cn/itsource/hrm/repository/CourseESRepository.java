package cn.itsource.hrm.repository;

import cn.itsource.hrm.CourseDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//课程的ES操作对象

public interface CourseESRepository extends ElasticsearchRepository<CourseDoc,Long> {
}
