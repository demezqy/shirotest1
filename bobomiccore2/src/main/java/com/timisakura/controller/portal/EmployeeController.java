package com.timisakura.controller.portal;

import com.timisakura.VO.EmployeeVO;
import com.timisakura.common.ServerResponse1;
import com.timisakura.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//写了这个就不用@RequestBady
public class EmployeeController {
    @Autowired
   private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("register.do")

    public ServerResponse1 register(EmployeeVO employeeVO, @RequestParam(value = "type") String type){

        return employeeService.register(employeeVO,type);

    }


}
