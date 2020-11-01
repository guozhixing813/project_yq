package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.RootEntity;
import com.sqsf.mapper.EpideSituDisplayEntiMapper;
import com.sqsf.mapper.RootEntityMapper;
import com.sqsf.service.EpideSituDisplayEntiService;
import com.sqsf.service.EpideSituDisplayService;
import com.sqsf.service.SchoolPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EpideSituDisplayEntiServiceImpl implements EpideSituDisplayEntiService {
    @Autowired(required = false)
    private com.sqsf.mapper.EpideSituDisplayEntiMapper EpideSituDisplayEntiMapper;
    @Override
    public JSONObject getSyBaseinfo(String school) {
        JSONObject resultJsonObject = new JSONObject();
        List<SchoolPara> schoolInfo = EpideSituDisplayEntiMapper.getSchoolInfo(school);
        List<EpideSituDisplayService> baseInfo = EpideSituDisplayEntiMapper.getBaseInfo(school,
                schoolInfo.get(0).getProvince());
        List<EpideSituDisplayService> zdgcrsInfo = EpideSituDisplayEntiMapper.getZdgcrsInfo(school);
        JSONObject result = new JSONObject();
        result.put("fx_num", baseInfo.get(0).getFxNum());
        result.put("wsfx_num", baseInfo.get(0).getWsfxNum());
        result.put("jwfx_num", baseInfo.get(0).getJwfxNum());
        result.put("zdgc_num", zdgcrsInfo.get(0).getZdgcNum());
        resultJsonObject.put("result", result);
        return resultJsonObject;
    }

    @Override
    public JSONObject getSyZdgcryinfo(String school) {
        JSONObject resultJsonObject = new JSONObject();
        List<EpideSituDisplayService> syZdgcryInfo = EpideSituDisplayEntiMapper.getSyZdgcryinfo(school);
        JSONArray zdgcryyArrayObject = new JSONArray();
        for (EpideSituDisplayService syZdgcry : syZdgcryInfo) {
            JSONObject Object = new JSONObject();
            Object.put("name", syZdgcry.getUserName());
            Object.put("xh", syZdgcry.getUserNum());
            Object.put("xy", syZdgcry.getCollege());
            Object.put("from", syZdgcry.getOriginCity());
            Object.put("from_num", 0);
            zdgcryyArrayObject.add(Object);
        }
        resultJsonObject.put("result", zdgcryyArrayObject);
        return resultJsonObject;
    }

    @Override
    public JSONObject getSyXyryfbinfo(String school) {
        JSONObject resultJsonObject = new JSONObject();
        List<EpideSituDisplayService> epideSituInfoList = EpideSituDisplayEntiMapper.getSyXyryfbinfo(school);
        List<EpideSituDisplayService> epideSituInfoLDList = EpideSituDisplayEntiMapper.getSyXyryfbinfoLD(school);
        if (epideSituInfoList.size() == 0) {
            resultJsonObject.put("errorCode", "4001");// 错误码4000参数为空 4001参数不正确， 4002认证失败
            return resultJsonObject;
        }
        Double[] center = new Double[] { Double.parseDouble(epideSituInfoList.get(0).getCenterLongitude().toString()),
                Double.parseDouble(epideSituInfoList.get(0).getCenterDimension()) };
        epideSituInfoList.get(0).getCenterLongitude();
        epideSituInfoList.get(0).getCenterDimension();
        JSONObject result = new JSONObject();
        result.put("center", center);
        JSONArray poits = new JSONArray();
        for (EpideSituDisplayService epideSituInfoLD : epideSituInfoLDList) {

            JSONObject jsonObj = new JSONObject();
            JSONObject geometry = new JSONObject();
            Double[] gpsInfo = new Double[] { epideSituInfoLD.getLongitude(), epideSituInfoLD.getDimension() };
            geometry.put("type", "Point");
            geometry.put("coordinates", gpsInfo);
            jsonObj.put("geometry", geometry);
            poits.add(jsonObj);
        }

        resultJsonObject.put("result", result);
        resultJsonObject.put("poits", poits);
        return resultJsonObject;

    }


}
