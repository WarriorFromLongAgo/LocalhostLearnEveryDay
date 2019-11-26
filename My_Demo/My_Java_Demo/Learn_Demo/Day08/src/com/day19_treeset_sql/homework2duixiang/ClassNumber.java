package com.day19_treeset_sql.homework2duixiang;

public class ClassNumber {
    private String classNumberId;
    private Student[] studentArr;

    public ClassNumber(String classNumberId) {
        this.classNumberId = classNumberId;
    }

    public String getClassNumberId() {
        return classNumberId;
    }

    public void setClassNumberId(String classNumberId) {
        this.classNumberId = classNumberId;
    }

    public Student[] getStudentArr() {
        return studentArr;
    }

    public void setStudentArr(Student[] studentArr) {
        this.studentArr = studentArr;
    }

}
