package com.day19_treeset_sql.treeset;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Student studentOne = new Student("zhang", 20);
        Student studentTwo = new Student("guan", 10);
        Student studentThree = new Student("li", 14);
        Student studentFour = new Student("dai", 49);
        Student studentFive = new Student("jin", 38);
        Student studentSix = new Student("xin", 14);
        Student studentSeven = new Student("xiang", 37);
        Student studentEigth = new Student("yang", 29);
        Student studentNine = new Student("guang", 19);
        Student studentTen = new Student("sheng", 16);

        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < 10) {
            int nextInt = random.nextInt(101);
            hashSet.add(nextInt);
//            System.out.println("产生随机数 = " + nextInt);
        }
//            System.out.println(hashSet);

        TreeSet<Student> studentTreeSet = new TreeSet<>();

        for (Student student : studentTreeSet) {
            System.out.println(student);
        }
    }
}

//class studentComparable implements Comparable {
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
//class stu implements Comparator {
//    @Override
//    public int compare(Object object1, Object object) {
//
//    }
//}
