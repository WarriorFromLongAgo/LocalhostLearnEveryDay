package com.day22_IO_SQL.day22homework;

public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String studentClassName;

    public Student() {
    }

//    public Constructor(String studentName, Integer studentAge, String studentClassName) {
//        this.studentName = studentName;
//        this.studentAge = studentAge;
//        this.studentClassName = studentClassName;
//    }

    public Student(Integer studentId, String studentName, Integer studentAge, String studentClassName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClassName = studentClassName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    @Override
    public String toString() {
        return "Constructor {" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentClassName='" + studentClassName + '\'' +
                '}';
    }
}
