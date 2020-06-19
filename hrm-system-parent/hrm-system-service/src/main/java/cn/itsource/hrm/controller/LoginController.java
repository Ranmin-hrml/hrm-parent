package cn.itsource.hrm.controller;

import cn.itsource.hrm.doamin.Employee;
import cn.itsource.hrm.service.IEmployeeService;
import cn.itsource.hrm.util.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@CrossOrigin({"http://localhost:6001","http//127.0.0.1:6001"})
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/login")
    public AjaxResult result(@RequestBody Employee employee){

        //参数判断
        if(StringUtils.isEmpty(employee.getUsername())){
            return AjaxResult.me().setSuccess(false).setMessage("用户名不能为空!");
        }
        if(StringUtils.isEmpty(employee.getPassword ())){
            return AjaxResult.me().setSuccess(false).setMessage("密碼不能为空!");
        }
        Employee employeeLogin = employeeService.getOne ( new QueryWrapper <Employee> ()
                .eq ( "username", employee.getUsername () ) );

        if(employeeLogin==null){
            return AjaxResult.me ().setSuccess ( false ).setMessage ( "用戶名或密碼錯誤！" );
        }
        employeeLogin.setPassword (null);
        return AjaxResult.me ().setSuccess ( true ).setMessage ( "登錄成功！" ).setResultObj (employeeLogin);

    }
}
