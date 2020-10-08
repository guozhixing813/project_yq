package com.sqsf.mapper;

import com.sqsf.entity.RootEntity;

public interface RootEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RootEntity record);

    int insertSelective(RootEntity record);

    RootEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RootEntity record);

    int updateByPrimaryKey(RootEntity record);
}