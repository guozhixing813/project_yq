package com.sqsf.controller;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
//    测试学生类
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    public JSONObject StudentInfo(){
        return studentService.getStudentInfo();
    }

}
