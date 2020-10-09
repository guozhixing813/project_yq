package com.sqsf.entity;

import java.util.Date;

/**
 * 返校健康信息
 */
public class SqFxhealthCollection {
    private Integer id; // 主键

    private String school; // 学校

    private String userName; // 学生姓名

    private String userNo; // 学号

    private Date timestamp; // 提交时间

    private String heathinfo1; // info1

    private Integer heathinfo2; // info2

    private Integer heathinfo3; // info3

    private Integer isQuarantine; // 是否隔离

    private String notes; // 备注

    private String temperature; // 温度

    private Date createTime; // 创建时间

    public SqFxhealthCollection() {
    }

    public SqFxhealthCollection(Integer id, String school, String userName, String userNo, Date timestamp, String heathinfo1, Integer heathinfo2, Integer heathinfo3, Integer isQuarantine, String notes, String temperature, Date createTime) {
        this.id = id;
        this.school = school;
        this.userName = userName;
        this.userNo = userNo;
        this.timestamp = timestamp;
        this.heathinfo1 = heathinfo1;
        this.heathinfo2 = heathinfo2;
        this.heathinfo3 = heathinfo3;
        this.isQuarantine = isQuarantine;
        this.notes = notes;
        this.temperature = temperature;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHeathinfo1() {
        return heathinfo1;
    }

    public void setHeathinfo1(String heathinfo1) {
        this.heathinfo1 = heathinfo1 == null ? null : heathinfo1.trim();
    }

    public Integer getHeathinfo2() {
        return heathinfo2;
    }

    public void setHeathinfo2(Integer heathinfo2) {
        this.heathinfo2 = heathinfo2;
    }

    public Integer getHeathinfo3() {
        return heathinfo3;
    }

    public void setHeathinfo3(Integer heathinfo3) {
        this.heathinfo3 = heathinfo3;
    }

    public Integer getIsQuarantine() {
        return isQuarantine;
    }

    public void setIsQuarantine(Integer isQuarantine) {
        this.isQuarantine = isQuarantine;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SqFxhealthCollection{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", userName='" + userName + '\'' +
                ", userNo='" + userNo + '\'' +
                ", timestamp=" + timestamp +
                ", heathinfo1='" + heathinfo1 + '\'' +
                ", heathinfo2=" + heathinfo2 +
                ", heathinfo3=" + heathinfo3 +
                ", isQuarantine=" + isQuarantine +
                ", notes='" + notes + '\'' +
                ", temperature='" + temperature + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}