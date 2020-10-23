package com.sqsf.service.Impl;

import com.sqsf.entity.RootEntity;
import com.sqsf.mapper.RootEntityMapper;
import com.sqsf.service.RootService;
import com.alibaba.fastjson.JSONObject;
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
    public JSONObject login(String school, String user, String password) {

        RootEntity rootEntity = new RootEntity();
        rootEntity.setSchool(school);
        rootEntity.setUser(user);
        rootEntity.setPassword(password);

//        System.out.println("!!!!!!");
//        System.out.println(rootEntity);
//        System.out.println(rootEntityMapper);

        //RootEntity a = rootEntityMapper.selectByPrimaryKey(1);
        //System.out.println(a);
        List<RootEntity> schoolInfo = rootEntityMapper.login(rootEntity);
        System.out.println(schoolInfo);

        JSONObject res = new JSONObject();
        res.put("errorCode", 0);//错误码4000参数为空 4001参数不正确， 4002认证失败
        res.put("MGSS", "登录成功");//

        if(schoolInfo.size()==0) {
            res.put("errorCode", "4002");//错误码4000参数为空 4001参数不正确， 4002认证失败
            res.put("MGSS", "登录失败");//
            return res;
        }
        res.put("school",schoolInfo.get(0).getSchool());
        res.put("url",schoolInfo.get(0).getBigscreenUrl());
        return res;
    }






}
