package com.day19_treeset_sql.homework2map;

public class SolutionName2 {
    public static void main(String[] args) {
        //  新建学生对象，以及 班级对象
        Student oneStudent = new Student("aaa", "java101", 90);
        Student twoStudent = new Student("bbb", "java101", 50);
        Student threeStudent = new Student("ccc", "java101", 20);
        Student fourStudent = new Student("ddd", "java101", 70);
        Student fiveStudent = new Student("eee", "java101", 60);

        //  classList 添加对象
        ClassNumber oneClass = new ClassNumber();
        oneClass.getClassNumber().add(oneStudent);
        oneClass.getClassNumber().add(twoStudent);
        oneClass.getClassNumber().add(threeStudent);
        oneClass.getClassNumber().add(fourStudent);
        oneClass.getClassNumber().add(fiveStudent);


    }
}
