package com.day19_treeset_sql.homework2map;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因:
 */
public class Student {
    private String stuName;
    private String classNumber;
    private double scoer;

    public Student() {
    }

    public Student(String stuName, String classNumber, double scoer) {
        this.stuName = stuName;
        this.classNumber = classNumber;
        this.scoer = scoer;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public double getScoer() {
        return scoer;
    }

    public void setScoer(double scoer) {
        this.scoer = scoer;
    }

    @Override
    public String toString() {
        return "Constructor {" +
                "stuName='" + stuName + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", scoer=" + scoer +
                '}';
    }
}