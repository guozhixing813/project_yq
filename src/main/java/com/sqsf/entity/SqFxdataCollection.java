package com.sqsf.entity;

import java.util.Date;

/**
 * 返校信息
 */
public class SqFxdataCollection {
    private Integer id; // 主键

    private String school; // 学校名

    private String userName; // 学生姓名

    private String userNo; // 学号

    private Date fxTime; // 返校时间

    private String fxAddrCountry; // 返校国家

    private String fxAddrProvince; // 返校省份

    private String fxAddrCity; // 返校城市

    private String fxAddrTown; // 返校区

    private String fxVehicl; // 返校交通

    private Integer isThseriousarea; // 是否经过疫区

    private Date createTime; // 创建时间

    public SqFxdataCollection() {
    }

    public SqFxdataCollection(Integer id, String school, String userName, String userNo, Date fxTime, String fxAddrCountry, String fxAddrProvince, String fxAddrCity, String fxAddrTown, String fxVehicl, Integer isThseriousarea, Date createTime) {
        this.id = id;
        this.school = school;
        this.userName = userName;
        this.userNo = userNo;
        this.fxTime = fxTime;
        this.fxAddrCountry = fxAddrCountry;
        this.fxAddrProvince = fxAddrProvince;
        this.fxAddrCity = fxAddrCity;
        this.fxAddrTown = fxAddrTown;
        this.fxVehicl = fxVehicl;
        this.isThseriousarea = isThseriousarea;
        this.createTime = createTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Date getFxTime() {
        return fxTime;
    }

    public void setFxTime(Date fxTime) {
        this.fxTime = fxTime;
    }

    public String getFxAddrCountry() {
        return fxAddrCountry;
    }

    public void setFxAddrCountry(String fxAddrCountry) {
        this.fxAddrCountry = fxAddrCountry == null ? null : fxAddrCountry.trim();
    }

    public String getFxAddrProvince() {
        return fxAddrProvince;
    }

    public void setFxAddrProvince(String fxAddrProvince) {
        this.fxAddrProvince = fxAddrProvince == null ? null : fxAddrProvince.trim();
    }

    public String getFxAddrCity() {
        return fxAddrCity;
    }

    public void setFxAddrCity(String fxAddrCity) {
        this.fxAddrCity = fxAddrCity == null ? null : fxAddrCity.trim();
    }

    public String getFxAddrTown() {
        return fxAddrTown;
    }

    public void setFxAddrTown(String fxAddrTown) {
        this.fxAddrTown = fxAddrTown == null ? null : fxAddrTown.trim();
    }

    public String getFxVehicl() {
        return fxVehicl;
    }

    public void setFxVehicl(String fxVehicl) {
        this.fxVehicl = fxVehicl == null ? null : fxVehicl.trim();
    }

    public Integer getIsThseriousarea() {
        return isThseriousarea;
    }

    public void setIsThseriousarea(Integer isThseriousarea) {
        this.isThseriousarea = isThseriousarea;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SqFxdataCollection{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", userName='" + userName + '\'' +
                ", userNo='" + userNo + '\'' +
                ", fxTime=" + fxTime +
                ", fxAddrCountry='" + fxAddrCountry + '\'' +
                ", fxAddrProvince='" + fxAddrProvince + '\'' +
                ", fxAddrCity='" + fxAddrCity + '\'' +
                ", fxAddrTown='" + fxAddrTown + '\'' +
                ", fxVehicl='" + fxVehicl + '\'' +
                ", isThseriousarea=" + isThseriousarea +
                ", createTime=" + createTime +
                '}';
    }
}