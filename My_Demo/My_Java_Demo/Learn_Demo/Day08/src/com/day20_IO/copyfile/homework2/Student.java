package com.day20_IO.copyfile.homework2;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentScore;
    private String studentGroup;
    private String studentClass;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer studentScore, String studentGroup, String studentClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentScore = studentScore;
        this.studentGroup = studentGroup;
        this.studentClass = studentClass;
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

    public Integer getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(Integer studentScore) {
        this.studentScore = studentScore;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
