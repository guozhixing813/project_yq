package com.sqsf.mapper;

import com.sqsf.entity.RootEntity;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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

//    // 全局接口获取参数
//    @Select("SELECT school,user,password FROM sq_url_tologin " +
//            "WHERE school = #{school} AND user = #{user} AND password = #{password};")
//    @Results({
//    })
//    List<RootEntity> login(RootEntity rootEntity);

    @Select("SELECT * FROM `sq_url_tologin`")
    @Results({
    })
    List<RootEntity> login();

}