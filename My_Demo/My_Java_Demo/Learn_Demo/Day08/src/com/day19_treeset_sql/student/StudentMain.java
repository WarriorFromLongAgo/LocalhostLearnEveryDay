package com.day19_treeset_sql.student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class StudentMain {
    public static void main(String[] args) {
        HashSet<Integer> random = new HashSet<>();
        ArrayList<Integer> randomArrList = new ArrayList<>();

        Student studentOne = new Student("stu11", 5);
        Student studentTwo = new Student("stu22", 1);
        Student studentThree = new Student("stu33", 2);
        Student studentFour = new Student("stu44", 1);
        Student studentFive = new Student("stu55", 6);

        studentOne.setId(ranNextInt(randomArrList));
        randomArrList.add(studentOne.getId());

        studentTwo.setId(ranNextInt(randomArrList));
        randomArrList.add(studentTwo.getId());

        studentThree.setId(ranNextInt(randomArrList));
        randomArrList.add(studentThree.getId());

        studentFour.setId(ranNextInt(randomArrList));
        randomArrList.add(studentFour.getId());

        studentFive.setId(ranNextInt(randomArrList));
        randomArrList.add(studentFive.getId());

        StudentDeal studentDeal = new StudentDeal();
        studentDeal.addStudent(studentOne);
        studentDeal.addStudent(studentTwo);
        studentDeal.addStudent(studentThree);
        studentDeal.addStudent(studentFour);
        studentDeal.addStudent(studentFive);
        ArrayList<Student> studentArr = studentDeal.disPlayAllData();
        for (Student student : studentArr) {
            System.out.println("学生：" + student.getId() + " " + student.getName() + " " + student.getAge());
        }
    }

    public static int ranNextInt(ArrayList<Integer> randomArrList) {
        Random random = new Random();
        int tempInt = 0;
//        for (int i = 0; i < 100; i++) {
        while (true) {
            //  生成0-100的随机数，未测试未测试
            //  未测试
            tempInt = random.nextInt(101);
//            tempInt = tempInt + 1;
//            System.out.print((int) tempInt + ",");

            if (randomArrList.contains(tempInt)) {
                continue;

            } else {
                break;
            }
        }
        return tempInt;


//            if (tempInt > 100 || tempInt < 0) {
//                System.out.println(" 程序错误 ");
//                break;
//            }
//        }


    }
}
