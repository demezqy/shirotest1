package com.timisakura.service;

import com.timisakura.pojo.User;

/**
 * @ClassNAME IUserService
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/12 18:43
 * @Version
 */
public interface IUserService {
    User selectuserpermission(Integer id);
    User selectuserpermissionname(String name);
}
