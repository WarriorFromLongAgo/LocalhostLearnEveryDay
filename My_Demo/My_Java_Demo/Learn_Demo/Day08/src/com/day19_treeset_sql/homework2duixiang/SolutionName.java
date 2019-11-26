package com.day19_treeset_sql.homework2duixiang;

public class SolutionName {
    public static void main(String[] args) {
        //  新建学生对象，以及 班级对象
        Student oneStudent = new Student("aaa", 90);
        Student twoStudent = new Student("bbb", 50);
        Student threeStudent = new Student("ccc", 20);
        Student fourStudent = new Student("ddd", 70);
        Student fiveStudent = new Student("eee", 60);
        ClassNumber oneClassNumber = new ClassNumber("java101");

        //  设置学生和班级之间的关系
        oneStudent.setClassNumber(oneClassNumber);
        twoStudent.setClassNumber(oneClassNumber);
        threeStudent.setClassNumber(oneClassNumber);
        fourStudent.setClassNumber(oneClassNumber);
        fiveStudent.setClassNumber(oneClassNumber);
        oneClassNumber.setStudentArr(new Student[]{oneStudent, twoStudent, threeStudent, fourStudent, fiveStudent});

        //  统计每个班级的总分和平均分
        double classTotalScore = 0;
        for (int i = 0; i < oneClassNumber.getStudentArr().length; i++) {
            classTotalScore += oneClassNumber.getStudentArr()[i].getScoer();
        }
        System.out.println(oneClassNumber.getClassNumberId() + "班级，班级总分 = " + classTotalScore);

        double classAverageScore = 0;
        classAverageScore = classTotalScore / oneClassNumber.getStudentArr().length;
        System.out.println(oneClassNumber.getClassNumberId() + "班级，班级平均分 = " + classAverageScore);
    }
}
