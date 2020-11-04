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

    /**
     * 李婉婷  7.人员详情信息
     * @param school
     * @param personNo
     * @return
     */
    Object getpersonInfoDetail(String school,String personNo, String isStudent);
    Object getpersonInfoSDetail(String school,String personNo, String isStudent);
    JSONObject getPersonInfoDetails(String school,String personNo, String isStudent);






    /**
     * 李婉婷  8.个人轨迹图
     * @param school
     * @param personNo
     * @param isStudent
     * @return
     */
    JSONObject getSyGrgjt(String school, String personNo, String isStudent);

    /**
     * 李婉婷   9。个人相应事件
     * @param school
     * @param personNo
     * @param isStudent
     * @return
     */
    JSONObject getSyGrxysj(String school, String personNo, String isStudent);
}
