package cn.itsource.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.itsource.hrm.mapper")
public class CourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run ( CourseServiceApplication.class,args );
    }
}
