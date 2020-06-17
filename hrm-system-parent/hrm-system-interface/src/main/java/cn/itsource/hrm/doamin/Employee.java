package cn.itsource.hrm.doamin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    @TableField("realName")
    private String realName;
    private String tel;
    private String email;
    @TableField("inputTime")
    private Date inputTime;
    private Integer state;
    private Long dept_id;
    private Long tenant_id;
    private Integer type;

}
