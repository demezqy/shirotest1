package com.timisakura.dao;

import com.timisakura.pojo.UseridPermissionid;

public interface UseridPermissionidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UseridPermissionid record);

    int insertSelective(UseridPermissionid record);

    UseridPermissionid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UseridPermissionid record);

    int updateByPrimaryKey(UseridPermissionid record);
}