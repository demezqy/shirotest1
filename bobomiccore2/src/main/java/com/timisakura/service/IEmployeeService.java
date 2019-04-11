package com.timisakura.service;

import com.timisakura.VO.EmployeeVO;
import com.timisakura.common.ServerResponse1;
import com.timisakura.pojo.Employee;

public interface IEmployeeService {

    ServerResponse1 register(EmployeeVO employeeVO, String type);
    Employee findUserName(String username);
}
