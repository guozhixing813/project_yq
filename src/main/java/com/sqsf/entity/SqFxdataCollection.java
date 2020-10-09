package com.sqsf.entity;

import java.util.Date;

public class SqFxdataCollection {
    private Integer id;

    private String school;

    private String userName;

    private String userNo;

    private Date fxTime;

    private String fxAddrCountry;

    private String fxAddrProvince;

    private String fxAddrCity;

    private String fxAddrTown;

    private String fxVehicl;

    private Integer isThseriousarea;

    private Date createTime;

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
}