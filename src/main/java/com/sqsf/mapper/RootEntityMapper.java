package com.sqsf.mapper;

import com.sqsf.entity.RootEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RootEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RootEntity record);

    int insertSelective(RootEntity record);

    RootEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RootEntity record);

    int updateByPrimaryKey(RootEntity record);

    List<RootEntity> login(RootEntity rootEntity);

    List<RootEntity> getSchoolList();

}