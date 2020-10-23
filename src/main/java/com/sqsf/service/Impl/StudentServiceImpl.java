package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.sqsf.mapper.SqStudentInfoMapper;
import com.sqsf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private SqStudentInfoMapper sqStudentInfoMapper;

    @Override
    public JSONObject getStudentInfo() {
        JSONObject res = new JSONObject();
        List<Map<String,Object>> mapResult  = sqStudentInfoMapper.getStudentInfo();
        res.put("mapResult",mapResult);
        return res;
    }
}
