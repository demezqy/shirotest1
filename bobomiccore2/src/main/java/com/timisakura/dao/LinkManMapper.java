package com.timisakura.dao;

import com.timisakura.pojo.LinkMan;

public interface LinkManMapper {
    int deleteByPrimaryKey(Long lkmId);

    int insert(LinkMan record);

    int insertSelective(LinkMan record);

    LinkMan selectByPrimaryKey(Long lkmId);

    int updateByPrimaryKeySelective(LinkMan record);

    int updateByPrimaryKey(LinkMan record);
}