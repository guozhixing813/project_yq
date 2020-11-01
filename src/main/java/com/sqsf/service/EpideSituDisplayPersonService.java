package com.sqsf.service;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.EpideSituDisplayPersonEntity;

import java.util.List;

/**
 * @author gzx
 * @create 2020-11-01 17:58
 */

public interface EpideSituDisplayPersonService{


    List<EpideSituDisplayPersonEntity> getEntiCount(String school);

    List<EpideSituDisplayPersonEntity> getZdsrCount(String school);


    JSONObject getEntiCounts(String school);
}
