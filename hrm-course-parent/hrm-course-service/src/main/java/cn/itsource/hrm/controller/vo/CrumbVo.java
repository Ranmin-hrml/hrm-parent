package cn.itsource.hrm.controller.vo;

import cn.itsource.hrm.domain.CourseType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CrumbVo {

    private CourseType currentType;

    private List<CourseType> otherTypes = new ArrayList <> (  );

}
