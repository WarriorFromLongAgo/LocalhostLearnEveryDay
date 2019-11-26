package com.day19_treeset_sql.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TeacherMain {
    public static void main(String[] args) {
        Teacher teacherOne = new Teacher("1000", "aa", 10, "湖北");
        Teacher teacherTwo = new Teacher("1002", "bb", 20, "湖南");
        Teacher teacherThree = new Teacher("1003", "cc", 30, "河南");
        Teacher teacherFour = new Teacher("1004", "dd", 25, "河东");

        Map<Teacher, String> teacherStringMap = new HashMap<>();
        teacherStringMap.put(teacherOne, teacherOne.getTeacherId());
        teacherStringMap.put(teacherTwo, teacherTwo.getTeacherId());
        teacherStringMap.put(teacherThree, teacherThree.getTeacherId());
        teacherStringMap.put(teacherFour, teacherFour.getTeacherId());

        for (Map.Entry<Teacher, String> EntryteacherString : teacherStringMap.entrySet()) {
            System.out.print("key = " + EntryteacherString.getKey());
            System.out.println(",,,,value = " + EntryteacherString.getValue());
        }
        System.out.println();
        Set<Teacher> setTeacher = teacherStringMap.keySet();
        for (Teacher keyTeacher : setTeacher) {
            String valueTeacher = teacherStringMap.get(keyTeacher);
            System.out.print("key = " + keyTeacher);
            System.out.println(",,,,,value = " + valueTeacher);
        }
    }
}
