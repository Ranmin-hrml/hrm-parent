package cn.itsource.hrm.service;

import cn.itsource.hrm.controller.vo.CrumbVo;
import cn.itsource.hrm.domain.CourseType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author ranmin
 * @since 2020-06-17
 */
public interface ICourseTypeService extends IService<CourseType> {
    /**
     * 加载课程类型树的数据
     * @return
     */
    List<CourseType> loadTypeTree();

    /**
     * 加载类型面包屑
     * @param courseTypeId
     * @return
     */
    List<CrumbVo> loadCrumbs(Long courseTypeId);
}
