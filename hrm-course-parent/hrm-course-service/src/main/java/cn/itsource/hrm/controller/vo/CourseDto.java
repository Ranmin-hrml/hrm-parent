package cn.itsource.hrm.controller.vo;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.domain.CourseDetail;
import cn.itsource.hrm.domain.CourseMarket;

//课程添加数据封装
public class CourseDto {

    private Course course;
    private CourseDetail courseDetail;
    private CourseMarket courseMarket;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public CourseMarket getCourseMarket() {
        return courseMarket;
    }

    public void setCourseMarket(CourseMarket courseMarket) {
        this.courseMarket = courseMarket;
    }
}
