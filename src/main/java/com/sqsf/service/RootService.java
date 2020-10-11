package com.sqsf.service;

import com.sqsf.entity.RootEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author gzx
 * @create 2020-09-27 18:15
 */
public interface RootService {

    // 登录
    JSONObject login() throws JSONException;


}
