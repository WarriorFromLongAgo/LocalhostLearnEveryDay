package com.day24_Thread24;

import java.math.BigDecimal;

public class runeable {
    public static void main(String[] args) {
//        runabl1e runabl1e = new runabl1e();
//        Thread thread1 = new Thread(runabl1e);
//        thread1.setName("thread1");
//        Thread thread2 = new Thread(runabl1e);
//        thread2.setName("thread2");
//
//        thread1.start();
////        thread2.start();
//        demo4 student1 = new demo4("1", 11);
//        demo4 student2 = new demo4("2", 22);
//        demo4 student3 = new demo4("3", 33);
//
//        Set<demo4> studentList = new HashSet<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
//        System.out.println(studentList.size());
//
//        student1.setAge(33333);
//        System.out.println(studentList.size());
//
//        studentList.remove(student1);
//        System.out.println(studentList.size());
//
//        studentList.add(student1);
//        System.out.println(studentList.size());


        BigDecimal a = new BigDecimal(222);
        BigDecimal b = new BigDecimal(222.00);
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));
    }
}

class runabl1e implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class student {
    private String name;
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
