package com.myserver.studentbeans;

public class StudentBeans {
    private String studentUUID;
    private String studentUserName;
    private String studentName;
    private Integer studentAge;
    private String studentClassName;
    private String tempOne;
    private String tempTwo;
    private String tempThree;
    private String tempFour;
    private String tempFive;

    public StudentBeans() {
    }

    public StudentBeans(String studentUserName, String studentName, Integer studentAge, String studentClassName) {
        this.studentUserName = studentUserName;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClassName = studentClassName;
    }

    public StudentBeans(String studentUUID, String studentUserName, String studentName, Integer studentAge, String studentClassName) {
        this.studentUUID = studentUUID;
        this.studentUserName = studentUserName;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClassName = studentClassName;
    }

    public String getStudentUUID() {
        return studentUUID;
    }

    public void setStudentUUID(String studentUUID) {
        this.studentUUID = studentUUID;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

}
