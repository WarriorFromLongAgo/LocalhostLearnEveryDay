package com.day19_treeset_sql.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentMain {
    public static void main(String[] args) {
        Student studentOne = new Student("1000", "aaa");
        Student studentTwo = new Student("1001", "bbb");
        Student studentThree = new Student("1002", "ccc");
        Student studentFour = new Student("1003", "ddd");

        Map<Student, String> studentMap = new HashMap<>();
        studentMap.put(studentOne, studentOne.getStudentName());
        studentMap.put(studentTwo, studentTwo.getStudentName());
        studentMap.put(studentThree, studentThree.getStudentName());
        studentMap.put(studentFour, studentFour.getStudentName());

        for (Map.Entry<Student, String> studentEntrySet : studentMap.entrySet()) {
            System.out.print("key = " + studentEntrySet.getKey());
            System.out.println(",value = " + studentEntrySet.getValue());
        }
        System.out.println();
        Set<Student> studentKey = studentMap.keySet();
        for (Student key : studentKey) {
            String studentValue = studentMap.get(key);
            System.out.print("key = " + key);
            System.out.println(",,,value = " + studentValue);
        }
        System.out.println();
//        Set<Constructor> studentKey = studentMap.keySet();
        for (Student key : studentMap.keySet()) {
            //String studentValue = studentMap.get(key);
            System.out.print("key = " + key);
            System.out.println(",,,value = " + studentMap.get(key));
        }
    }
}
