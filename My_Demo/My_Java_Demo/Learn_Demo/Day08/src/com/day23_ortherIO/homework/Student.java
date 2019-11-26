package com.day23_ortherIO.homework;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private static String studentClassName = "java101";

    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        //this.studentClassName = studentClassName;
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
        return "Constructor{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentClassName='" + studentClassName + '\'' +
                '}';
    }
}
