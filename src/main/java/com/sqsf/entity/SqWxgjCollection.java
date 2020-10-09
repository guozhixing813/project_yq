package com.sqsf.entity;

import java.util.Date;

public class SqWxgjCollection {
    private Integer id; // 主键

    private String school; // 学校

    private String addr; // 地址

    private String userName; // 学生姓名

    private Integer userNo; // 学号

    private String longitude; // 经度

    private String dimension; // 纬度

    private Date time; // 时间

    private String creatTime; // 创建时间

    public SqWxgjCollection() {
    }

    public SqWxgjCollection(Integer id, String school, String addr, String userName, Integer userNo, String longitude, String dimension, Date time, String creatTime) {
        this.id = id;
        this.school = school;
        this.addr = addr;
        this.userName = userName;
        this.userNo = userNo;
        this.longitude = longitude;
        this.dimension = dimension;
        this.time = time;
        this.creatTime = creatTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension == null ? null : dimension.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime == null ? null : creatTime.trim();
    }

    @Override
    public String toString() {
        return "SqWxgjCollection{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", addr='" + addr + '\'' +
                ", userName='" + userName + '\'' +
                ", userNo=" + userNo +
                ", longitude='" + longitude + '\'' +
                ", dimension='" + dimension + '\'' +
                ", time=" + time +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}