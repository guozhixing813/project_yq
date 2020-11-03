package com.sqsf.service;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.RootEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gzx
 * @create 2020-09-27 18:15
 */

public interface RootService {

    // 登录
    JSONObject login(String school, String user, String password);

    // 获取学校列表
    Object getSchoolList();
}
