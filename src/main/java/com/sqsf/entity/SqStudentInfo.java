package com.sqsf.entity;

import java.util.Date;

public class SqStudentInfo {
    private Integer id; // 主键

    private String school; // 学校

    private String college; // 学院

    private String userName; // 学生姓名

    private Integer userNo; // 学号

    private String sex; // 性别

    private Integer age; // 年龄

    private String classes; // 班级

    private String phone; // 电话号

    private String personType; // 个人类型

    private Date createTime; // 创建时间

    private String md5Password; // 加密后的密码

    private String department; // 部门

    private String parentsPhone; // 父母电话号

    public SqStudentInfo() {
    }

    public SqStudentInfo(Integer id, String school, String college, String userName, Integer userNo, String sex, Integer age, String classes, String phone, String personType, Date createTime, String md5Password, String department, String parentsPhone) {
        this.id = id;
        this.school = school;
        this.college = college;
        this.userName = userName;
        this.userNo = userNo;
        this.sex = sex;
        this.age = age;
        this.classes = classes;
        this.phone = phone;
        this.personType = personType;
        this.createTime = createTime;
        this.md5Password = md5Password;
        this.department = department;
        this.parentsPhone = parentsPhone;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType == null ? null : personType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMd5Password() {
        return md5Password;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password == null ? null : md5Password.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getParentsPhone() {
        return parentsPhone;
    }

    public void setParentsPhone(String parentsPhone) {
        this.parentsPhone = parentsPhone == null ? null : parentsPhone.trim();
    }

    @Override
    public String toString() {
        return "SqStudentInfo{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", college='" + college + '\'' +
                ", userName='" + userName + '\'' +
                ", userNo=" + userNo +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", personType='" + personType + '\'' +
                ", createTime=" + createTime +
                ", md5Password='" + md5Password + '\'' +
                ", department='" + department + '\'' +
                ", parentsPhone='" + parentsPhone + '\'' +
                '}';
    }
}