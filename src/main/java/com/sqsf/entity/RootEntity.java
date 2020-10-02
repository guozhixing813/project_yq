package com.sqsf.entity;

public class RootEntity {
    private Integer id;  // 主键

    private String school; // 学校

    private String user; // 用户名

    private String password; // 密码

    private String bigscreenUrl; // 大屏URL

    private String wxUrl; // 返回后台接口URL

    private String token; // token校验

    private String schoolJc; // 学校简称

    public RootEntity() {
    }

    public RootEntity(Integer id, String school, String user, String password, String bigscreenUrl, String wxUrl, String token, String schoolJc) {
        this.id = id;
        this.school = school;
        this.user = user;
        this.password = password;
        this.bigscreenUrl = bigscreenUrl;
        this.wxUrl = wxUrl;
        this.token = token;
        this.schoolJc = schoolJc;
    }

    @Override
    public String toString() {
        return "RootEntity{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", bigscreenUrl='" + bigscreenUrl + '\'' +
                ", wxUrl='" + wxUrl + '\'' +
                ", token='" + token + '\'' +
                ", schoolJc='" + schoolJc + '\'' +
                '}';
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBigscreenUrl() {
        return bigscreenUrl;
    }

    public void setBigscreenUrl(String bigscreenUrl) {
        this.bigscreenUrl = bigscreenUrl == null ? null : bigscreenUrl.trim();
    }

    public String getWxUrl() {
        return wxUrl;
    }

    public void setWxUrl(String wxUrl) {
        this.wxUrl = wxUrl == null ? null : wxUrl.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getSchoolJc() {
        return schoolJc;
    }

    public void setSchoolJc(String schoolJc) {
        this.schoolJc = schoolJc == null ? null : schoolJc.trim();
    }
}