package com.sqsf.entity;

/**
 * 学校部门信息
 */
public class SqSchoolDepartment {
    private Integer id; // 主键

    private String school; // 学校

    private String department; // 部门

    public SqSchoolDepartment() {
    }

    public SqSchoolDepartment(Integer id, String school, String department) {
        this.id = id;
        this.school = school;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    @Override
    public String toString() {
        return "SqSchoolDepartment{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}