package com.sqsf.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface EpideSituDisplayEntiService {

    /**
     * 赵晓凤
     * @param school
     * @return
     */
    JSONObject getSyBaseinfo(String school);

    JSONObject getSyZdgcryinfo(String school);

    JSONObject getSyXyryfbinfo(String school);

    JSONObject getSyYqjkinfo(String school);

    /**
     * 许歌辉
     * @param school
     * @return
     */
    JSONObject getSyYjinfo(String school);

    JSONObject getSyRmlyin(String school);

    JSONObject getSyFxjtinfo(String school);

    /**
     * 孙心茹
     * @param school
     * @return
     */
    JSONObject getSyFxrylyinfo(String school);

    JSONObject getSyYqdtinfo(String school);

    JSONObject getSyEjxyfxinfo(String school);
}
