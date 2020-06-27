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

    List<CourseType> loadTypeTree();

    List<CrumbVo> loadCrumbs(Long courseTypeId);
}
