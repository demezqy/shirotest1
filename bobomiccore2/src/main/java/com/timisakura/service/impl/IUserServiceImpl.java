package com.timisakura.service.impl;

import com.timisakura.dao.UserMapper;
import com.timisakura.pojo.User;
import com.timisakura.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNAME IUserServiceImpl
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/12 18:44
 * @Version
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectuserpermission(Integer id) {
        return userMapper.selectuserpermission(id);
    }

    @Override
    public User selectuserpermissionname(String name) {
        return userMapper.selectuserpermissionname(name);
    }
}
