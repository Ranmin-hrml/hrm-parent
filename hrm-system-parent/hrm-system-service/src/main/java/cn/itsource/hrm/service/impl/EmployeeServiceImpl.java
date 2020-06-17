package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.doamin.Employee;
import cn.itsource.hrm.mapper.EmployeeMapper;
import cn.itsource.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {
}
