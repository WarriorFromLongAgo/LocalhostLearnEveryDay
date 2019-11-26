package com.day19_treeset_sql.homework2map;

import java.util.List;

public class ClassNumber {
    private List<Student> classNumber;

    public ClassNumber() {
    }

    public ClassNumber(List<Student> classNumber) {
        this.classNumber = classNumber;
    }

    public List<Student> getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(List<Student> classNumber) {
        this.classNumber = classNumber;
    }
}
