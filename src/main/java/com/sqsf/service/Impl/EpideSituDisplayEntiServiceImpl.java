package com.sqsf.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sqsf.entity.RootEntity;
import com.sqsf.mapper.EpideSituDisplayEntiMapper;
import com.sqsf.mapper.RootEntityMapper;
import com.sqsf.service.EpideSituDisplayEntiService;
import com.sqsf.service.EpideSituDisplayService;
import com.sqsf.service.SchoolPara;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Override
    public JSONObject getSyYqjkinfo(String school) {
        JSONObject resultJsonObject = new JSONObject();
        List<SchoolPara> schoolInfo = EpideSituDisplayEntiMapper.getSchoolInfo(school);
        String province = schoolInfo.get(0).getProvince();
        String city = schoolInfo.get(0).getCity();

        RestTemplate restTemplate = new RestTemplate();//是Spring用于同步client端的核心类，简化了与http服务的通信，并满足RestFul原则，程序代码可以给它提供URL，并提取结果。默认情况下，RestTemplate默认依赖jdk的HTTP连接工具。
        HttpHeaders headers = new HttpHeaders();//http消息头
        headers.add("authoration", "apicode");//添加响应头信息
        headers.add("apicode", "65f2157f4fff4426b83519770ec5bd9b");//添加响应头信息

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();//设置超时处理
        HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();//获得HTTP客户端
        factory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(factory);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity(null, headers);
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("http://api.yonyoucloud.com/apis/dst/ncov/country");
        String resEntity = restTemplate.exchange(builder.build().toString(), HttpMethod.GET, request, String.class)
                .getBody();

        UriComponentsBuilder builder2 = UriComponentsBuilder
                .fromHttpUrl("https://api.yonyoucloud.com/apis/dst/ncov/spreadQuery");
        String resEntity2 = restTemplate.exchange(builder2.build().toString(), HttpMethod.GET, request, String.class)
                .getBody();

        JSONObject jsonResult = JSONObject.parseObject(resEntity);
        JSONObject jsonResult2 = JSONObject.parseObject(resEntity2);
        if (!"200".equals(jsonResult.getString("code")) && !"200".equals(jsonResult2.getString("code"))) {
            resultJsonObject.put("errorCode", "4000");
            return resultJsonObject;
        }
        JSONObject dataResult = JSONObject.parseObject(jsonResult.get("data").toString());

        // ----------------------------------接口2信息处理------------------------------------------------
        Integer[] qx = { 0, 0, 0, 0, 0, 0 };
        Integer[] qshi = { 0, 0, 0, 0, 0, 0 };
        Integer[] qshen = { 0, 0, 0, 0, 0, 0 };
        Integer[] qg = { 0, 0, 0, 0, 0, 0 };
        JSONArray mapResultList = JSONArray.parseArray(jsonResult2.get("newslist").toString());
        for (int i = 0; i < mapResultList.size(); i++) {
            String provinceName = JSONObject.parseObject(mapResultList.get(i).toString()).get("provinceName")
                    .toString();
            if (provinceName.contains(province)) {
                JSONObject sfInfo = JSONObject.parseObject(mapResultList.get(i).toString());
                qshen[0] = sfInfo.getInteger("confirmedCount");
                qshen[2] = sfInfo.getInteger("currentConfirmedCount");
                qshen[3] = sfInfo.getInteger("suspectedCount");
                qshen[4] = sfInfo.getInteger("curedCount");
                qshen[5] = sfInfo.getInteger("deadCount");
                JSONArray cityResultList = JSONArray.parseArray(sfInfo.get("cities").toString());
                for (int j = 0; j < cityResultList.size(); j++) {
                    JSONObject cityInfo = cityResultList.getJSONObject(j);
                    if (city.equals(cityInfo.getString("cityName"))) {
                        qshi[0] = cityInfo.getInteger("confirmedCount");

                        qshi[2] = cityInfo.getInteger("currentConfirmedCount");
                        qshi[3] = cityInfo.getInteger("suspectedCount");
                        qshi[4] = cityInfo.getInteger("curedCount");
                        qshi[5] = cityInfo.getInteger("deadCount");
                    }
                }
            }
        }
        qg[0] = dataResult.getInteger("confirmedCount");
        qg[2] = dataResult.getInteger("currentConfirmedCount");
        qg[3] = dataResult.getInteger("suspectedCount");
        qg[4] = dataResult.getInteger("curedCount");
        qg[5] = dataResult.getInteger("deadCount");

        resultJsonObject.put("errorCode", "");// 错误码4000参数为空 4001参数不正确， 4002认证失败
        JSONObject result = new JSONObject();
        result.put("qg", qg);
        result.put("qx", qx);
        result.put("qshen", qshen);
        result.put("qshi", qshi);
        resultJsonObject.put("result", result);// 错误码4000参数为空 4001参数不正确， 4002认证失败
        return resultJsonObject;
    }

}
