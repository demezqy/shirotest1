package com.timisakura.service.impl;


import com.timisakura.VO.EmployeeVO;
import com.timisakura.common.Const;

import com.timisakura.common.ServerResponse1;
import com.timisakura.dao.EmployeeMapper;
import com.timisakura.pojo.Employee;
import com.timisakura.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public ServerResponse1 register(EmployeeVO employeeVO, String type) {
        // 校验
        ServerResponse1 validResponse = null;
        if(Const.EMAIL.equals(type)){
            validResponse = this.checkValid(employeeVO.getEmail(), Const.EMAIL);
            if(!validResponse.isSuccess()){
                return validResponse;
            }
        }else if(Const.TEL.equals(type)){
            return ServerResponse1.createByErrorMessage("暂时不支持手机注册方式");
        }else if(Const.USERNAME.equals(type)){
            validResponse = this.checkValid(employeeVO.getRealname(), Const.USERNAME);
            if(!validResponse.isSuccess()){
                return validResponse;
            }
        }else{
            return ServerResponse1.createByErrorMessage("请选择正确的方式注册");
        }

        // 准备userLogin数据
        Employee employee=new Employee();
        employee = employeeVO;
        // 执行持久化操作
        System.out.println(employee);
        int resultCount =employeeMapper.insert(employee);
        if(resultCount == 0){   // 返回数据库的操作数
            return ServerResponse1.createByErrorMessage("注册失败");
        }
/*
        userLogin.setUserStats((byte) 0);   // 未激活
        userLogin.setPassword(MD5Util.MD5EncodeUtf8(userLoginVO.getPassword()));
        userLogin.setSalt(PropertiesUtil.getProperty("password.salt"));
*/


       /* // 如果是邮箱注册
        if(Const.EMAIL.equals(type)){
            // 发送激活邮件
            EmailUtils.sendAccountActivateEmail(userLoginVO);
        }*/
        return ServerResponse1.createBySuccessMessage("注册成功");
    }

    @Override
    public Employee findUserName(String username) {

        return employeeMapper.findUserName(username);

    }

    //    / 为什么在前端做了验证，后端还要在做？那么到底是在前端做验证还是在后端做呢？
    // 虽然前端会对表单进行校验，但是如果攻击者分析接口，直接调用接口，就可以绕过前端的校验
private ServerResponse1<String> checkValid(String subject, String type) {
    //type = null;
    if(org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
        if(Const.USERNAME.equals(type)) {
            // 检查同名username
            int resultCount = employeeMapper.checkEmployeename(subject);    // solr
            if (resultCount > 0) {
                return ServerResponse1.createByErrorMessage("用户名已经存在");
            }
    }
        if (Const.EMAIL.equals(type)) {
            int resultCount = employeeMapper.checkEmail(subject);   // alt + enter
            if (resultCount > 0) {
                return ServerResponse1.createByErrorMessage("邮箱已被注册");
            }
        }
    }else{
        return ServerResponse1.createByErrorMessage("参数错误");
    }
    return ServerResponse1.createBySuccessMessage("校验成功");
}
}
