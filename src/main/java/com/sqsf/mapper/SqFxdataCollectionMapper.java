package com.sqsf.mapper;

import com.sqsf.entity.SqFxdataCollection;

public interface SqFxdataCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqFxdataCollection record);

    int insertSelective(SqFxdataCollection record);

    SqFxdataCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqFxdataCollection record);

    int updateByPrimaryKey(SqFxdataCollection record);
}