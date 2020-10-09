package com.sqsf.mapper;

import com.sqsf.entity.SqSchoolDepartment;

public interface SqSchoolDepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqSchoolDepartment record);

    int insertSelective(SqSchoolDepartment record);

    SqSchoolDepartment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqSchoolDepartment record);

    int updateByPrimaryKey(SqSchoolDepartment record);
}