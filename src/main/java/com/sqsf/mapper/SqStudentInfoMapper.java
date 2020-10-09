package com.sqsf.mapper;

import com.sqsf.entity.SqStudentInfo;

public interface SqStudentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqStudentInfo record);

    int insertSelective(SqStudentInfo record);

    SqStudentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqStudentInfo record);

    int updateByPrimaryKey(SqStudentInfo record);
}