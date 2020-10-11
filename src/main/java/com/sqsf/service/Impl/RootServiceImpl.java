package com.sqsf.service.Impl;

import com.sqsf.entity.RootEntity;
import com.sqsf.mapper.RootEntityMapper;
import com.sqsf.service.RootService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gzx
 * @create 2020-09-27 18:16
 */

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootEntityMapper rootEntityMapper;

    /**
     * 1 大屏登录
     * @param school
     * @param user
     * @param password
     * @return
     */
    @Override
    public JSONObject login() throws JSONException {

        RootEntity rootEntity = new RootEntity();


        JSONObject res = new JSONObject();
        List<RootEntity> schoolInfo = rootEntityMapper.login(rootEntity);

        res.put("school", schoolInfo.get(0).getSchool()); //获取学校为JSON数据
        res.put("user", schoolInfo.get(0).getUser());
        res.put("password", schoolInfo.get(0).getPassword());

        return res;
    }



}
