package com.timisakura.dao;

import com.timisakura.pojo.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
   int checkEmployeename(String username);
    int checkEmail(String email);

    Employee findUserName(String username);
}