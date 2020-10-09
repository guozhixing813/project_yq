package com.sqsf.entity;

import java.util.Date;

/**
 * 学校信息
 */
public class SqSchoolConfigure {
    private Integer id; // 主键

    private String school; // 学校

    private Double centerLongitude; // 经度

    private Double centerDimension; // 纬度

    private String college; // 学院

    private String province; // 省份

    private String city; // 城市

    private Date createTime; // 创建时间

    private Date updateTime; // 修改时间

    public SqSchoolConfigure() {
    }

    public SqSchoolConfigure(Integer id, String school, Double centerLongitude, Double centerDimension, String college, String province, String city, Date createTime, Date updateTime) {
        this.id = id;
        this.school = school;
        this.centerLongitude = centerLongitude;
        this.centerDimension = centerDimension;
        this.college = college;
        this.province = province;
        this.city = city;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Double getCenterLongitude() {
        return centerLongitude;
    }

    public void setCenterLongitude(Double centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    public Double getCenterDimension() {
        return centerDimension;
    }

    public void setCenterDimension(Double centerDimension) {
        this.centerDimension = centerDimension;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SqSchoolConfigure{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", centerLongitude=" + centerLongitude +
                ", centerDimension=" + centerDimension +
                ", college='" + college + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}