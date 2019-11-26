package com.day19_treeset_sql.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherList {
    public static void main(String[] args) {
        Teacher teacherOne = new Teacher("1000", "aa", 10, "湖北");
        Teacher teacherTwo = new Teacher("1002", "bb", 20, "湖南");
        Teacher teacherThree = new Teacher("1003", "cc", 30, "河南");
        Teacher teacherFour = new Teacher("1004", "dd", 25, "河东");
        List listTeacher = new ArrayList();
        listTeacher.add(teacherOne);
        listTeacher.add(teacherTwo);
        listTeacher.add(teacherThree);
        listTeacher.add(teacherFour);

        Collections.sort(listTeacher, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Object o : listTeacher) {
            System.out.println(o);
        }
    }
}
