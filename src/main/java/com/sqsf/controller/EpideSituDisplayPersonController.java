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
@RequestMapping("/root")
public class EpideSituDisplayPersonController {

    /**
     * 数据库接口
     */
    @Autowired
    private EpideSituDisplayPersonService epideSituDisplayPersonService;

    /**
     * 郭枝杏：3.1整体概况接口
     * @param school
     * @return
     */
    @RequestMapping(value="/entiCount",method= RequestMethod.GET)
    public Object getEntiCount(
            @RequestParam(value = "school", required = false) String school) {

        return epideSituDisplayPersonService.getEntiCounts(school);

        }

    @RequestMapping(value = "/glCount",method = RequestMethod.GET)
    public Object getGlCount(
            @RequestParam(value = "isStudent", required = true) String isStudent,
            @RequestParam(value = "personNo", required = true) String personNo
    ){

        return null;
    }






}



