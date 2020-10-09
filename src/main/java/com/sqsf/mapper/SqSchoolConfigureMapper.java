package com.sqsf.mapper;

import com.sqsf.entity.SqSchoolConfigure;

public interface SqSchoolConfigureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqSchoolConfigure record);

    int insertSelective(SqSchoolConfigure record);

    SqSchoolConfigure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqSchoolConfigure record);

    int updateByPrimaryKey(SqSchoolConfigure record);
}