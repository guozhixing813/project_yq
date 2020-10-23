package com.sqsf.mapper;

import com.sqsf.entity.SqStudentInfo;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SqStudentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqStudentInfo record);

    int insertSelective(SqStudentInfo record);

    SqStudentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqStudentInfo record);

    int updateByPrimaryKey(SqStudentInfo record);

    @Select("select * from yq_student_info")
    @Results({

    })
    List<Map<String,Object>> getStudentInfo();
}