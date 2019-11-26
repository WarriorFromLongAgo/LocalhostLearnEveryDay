package com.day19_treeset_sql.homework;

public class Student {
    private String studentID;
    private String studentName;

    public Student() {
    }

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
