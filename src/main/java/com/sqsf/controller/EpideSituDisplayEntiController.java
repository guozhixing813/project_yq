package com.sqsf.controller;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.mapper.EpideSituDisplayEntiMapper;
import com.sqsf.service.EpideSituDisplayEntiService;
import com.sqsf.service.EpideSituDisplayService;
import com.sqsf.service.SchoolPara;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//解决跨域问题
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", maxAge = 3600)
@RestController//返回json字符串的数据，直接可以编写RESTFIUL的接口
@RequestMapping("/root/getEpideSituDisplayEnti")//配置系统拦截url


public class EpideSituDisplayEntiController {
    @Autowired
    private EpideSituDisplayEntiService epideSituDisplayEntiService;


    /**
     * 接口 赵晓凤1：大屏最顶端信息：返校人数 外省返校人数 境外返校人数 重点观察人数
     */
    @RequestMapping(value = "/sy_baseinfo", method = RequestMethod.GET)
    public Object getSyBaseinfo(String school) {
        return epideSituDisplayEntiService.getSyBaseinfo(school);
    }

    /**
     * 接口3、赵晓凤：、重点观察人员：姓名、学院、来源地、来源地确诊人数
     */
    @RequestMapping(value = "sy_zdgcryinfo", method = RequestMethod.GET)
    public Object getSyZdgcryinfo(String school){
        return epideSituDisplayEntiService.getSyZdgcryinfo(school);

    }



}







