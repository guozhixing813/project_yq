package com.sqsf.entity;

import lombok.Data;

@Data
public class RootEntity {

    private Integer id;  // 主键

    private String school; // 学校

    private String user; // 用户名

    private String password; // 密码

    private String bigscreenUrl; // 大屏URL

    private String wxUrl; // 返回后台接口URL

    private String token; // token校验

    private String schoolJc; // 学校简称

}