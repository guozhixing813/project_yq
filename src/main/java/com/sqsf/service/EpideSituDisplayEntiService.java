package com.sqsf.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface EpideSituDisplayEntiService {

    JSONObject getSyBaseinfo(String school);
    JSONObject getSyZdgcryinfo(String school);
}
