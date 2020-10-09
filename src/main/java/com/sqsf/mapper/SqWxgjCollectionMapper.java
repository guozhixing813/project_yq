package com.sqsf.mapper;

import com.sqsf.entity.SqWxgjCollection;

public interface SqWxgjCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SqWxgjCollection record);

    int insertSelective(SqWxgjCollection record);

    SqWxgjCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SqWxgjCollection record);

    int updateByPrimaryKey(SqWxgjCollection record);
}