package com.sqsf.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.EpideSituDisplayPersonEntity;
import com.sqsf.service.EpideSituDisplayPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gzx
 * @create 2020-11-01 17:55
 */
//解决跨域问题
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",maxAge = 3600)
//注解的方式进行配置
@RestController
@SpringBootApplication
@RequestMapping("/root/getEpideSituDisplayPerson")
public class EpideSituDisplayPersonController {

    /**
     * 数据库接口
     */
    @Autowired
    private EpideSituDisplayPersonService epideSituDisplayPersonService;

    /**
     * 郭枝杏：3.1 整体概况接口
     * @param school
     * @return
     */
    @RequestMapping(value="/entiCount",method= RequestMethod.GET)
    public Object getEntiCount(
            @RequestParam(value = "school", required = false) String school) {

        return epideSituDisplayPersonService.getEntiCounts(school);

        }

    /**
     * 郭枝杏：3.2 隔离人数饼状图
     * @param isStudent
     * @param personNo
     * @return
     */
    @RequestMapping(value = "/glCount",method = RequestMethod.GET)
    public Object getGlCount(
            @RequestParam(value = "isStudent", required = false) String isStudent,
            @RequestParam(value = "personNo", required = false) String personNo
    ){

        return epideSituDisplayPersonService.getEntiCount(isStudent, personNo);
    }

    /**
     * 郭枝杏：3.3 校门出入折线图
     * @param school
     * @return
     */
    @RequestMapping(value="/xmcrCount",method= RequestMethod.GET)
    public Object getXmcrCount(
            @RequestParam(value = "school", required = false) String school
    ) {

        return epideSituDisplayPersonService.getXmcrCount(school);
    }


    /**
     * 钱慧玲：4 预警接口
     * @param school
     * @return
     */
    @RequestMapping(value="/yjxn",method= RequestMethod.GET)
    public JSONObject getYjxno(
            @RequestParam(value = "school", required = false)String school){
        return  epideSituDisplayPersonService.getYjxno(school);
    }


    /**
     * 李婉婷  7.人员详情信息
     * @param isStudent
     * @param personNo
     * @return
     */

    @RequestMapping(value="/personInfo",method= RequestMethod.GET)
    public Object getPersonInfoDetail(
            @RequestParam(value = "isStudent", required = false) String isStudent,
            @RequestParam(value = "personNo", required = false) String personNo,
            @RequestParam(value = "school", required = false) String school
    ) {
        return epideSituDisplayPersonService.getpersonInfoDetails(school,personNo,isStudent);
    }




}



