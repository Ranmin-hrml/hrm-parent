package cn.itsource.hrm.mapper;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.query.CourseQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 高级分页查询
     * @param page
     * @param query
     * @return
     */
    IPage<Course> selectPageByQuery(Page<?> page, @Param("query") CourseQuery query);

    /**
     * 上线
     * @param ids
     * @param time
     */
    void online(@Param("ids") List<Long> ids, @Param("time") long time);

    /**
     * 下线
     * @param ids
     * @param time
     */
    void offline(@Param("ids") List<Long> ids, @Param("time") long time);
}
