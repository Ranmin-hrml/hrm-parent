package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.client.SystemdictionaryItemClient;
import cn.itsource.hrm.controller.vo.CourseAddVo;
import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.domain.CourseDetail;
import cn.itsource.hrm.domain.SystemdictionaryItem;
import cn.itsource.hrm.mapper.CourseDetailMapper;
import cn.itsource.hrm.mapper.CourseMapper;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.service.ICourseService;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private SystemdictionaryItemClient systemdictionaryItemClient;
    @Autowired
    private CourseDetailMapper courseDetailMapper;

    /**
     * 高级分页查询
     * @param query
     * @return
     */
    @Override
    public PageList<Course> page(CourseQuery query) {
        IPage<Course> iPage = baseMapper.selectPageByQuery(new Page<Course>(query.getPageNum(), query.getPageSize()), query);
        PageList<Course> pageList = new PageList <> (  );
        pageList.setTotal (iPage.getTotal ());
        pageList.setRows (iPage.getRecords ());
        return pageList;
    }

    @Override
    public void add(CourseAddVo courseAddVo) {
        /**
         * 获取用户的登录信息
         */
        Course course = new Course ();
        BeanUtils.copyProperties ( courseAddVo,course );
        SystemdictionaryItem systemdictionaryItem = systemdictionaryItemClient.get ( courseAddVo.getGrade () );
        if(systemdictionaryItem!=null){
            course.setGradeName ( systemdictionaryItem.getName () );
        }
        course.setTenantId(26L);
        course.setTenantName("源码时代");
        course.setUserId(42L);
        course.setUserName("admin");
        course.setStatus(0);
        baseMapper.insert(course);

        /**
         * 获取详情信息
         */
        CourseDetail courseDetail = new CourseDetail ();
        BeanUtils.copyProperties ( courseAddVo,courseDetail );
        courseDetail.setCourseId ( course.getId () );
        courseDetailMapper.insert ( courseDetail );
    }
}
