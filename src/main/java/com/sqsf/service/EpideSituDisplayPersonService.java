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

    Object getEntiCount(String isStudent, String personNo);

    Object getXmcrCount(String school); // 校门出入数

    JSONObject getYjxno(String school); // 预警

    Object getSysj(String school);

    JSONObject getSySelationship(String school, String personNo);


}
