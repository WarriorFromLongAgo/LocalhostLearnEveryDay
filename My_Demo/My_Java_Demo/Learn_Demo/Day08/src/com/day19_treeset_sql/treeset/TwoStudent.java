//package com.day19_treeset_sql.treeset;
//
//import java.util.Comparator;
//
//public class TwoStudent implements  Comparator {
//    private int id;
//    private String name;
//    private int age;
//
//    public TwoStudent() {
//    }
//
//    public TwoStudent(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public TwoStudent(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    //  hashCode    equals  写的是hashSet的判断重复
////    @Override
////    public int hashCode() {
////        return this.id;
////    }
////
////    @Override
////    public boolean equals(Object obj) {
////        Constructor Constructor = (Constructor) obj;
////        return this.id == Constructor.id;
////    }
//
//    @Override
//    public String toString() {
//        return "Constructor{" +
//                "id='" + id + '\'' +
//                ", age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//
//    @Override
//    public int compare(Object objOne, Object objTwo) {
//        TwoStudent twoStudentOne = (TwoStudent) objOne;
//        TwoStudent twoStudentTwo = (TwoStudent) objTwo;
//        if (twoStudentOne.age > twoStudentTwo.age) {
//            return 1;
//        }
//        if (twoStudentOne.age < twoStudentTwo.age) {
//            return -1;
//        }
//        if (twoStudentOne.age == twoStudentTwo.age) {
//            if (twoStudentOne.id > twoStudentTwo.id) {
//                return 1;
//            }
//            if (twoStudentOne.id < twoStudentTwo.id) {
//                return -1;
//            }
//            if (twoStudentOne.id == twoStudentTwo.id) {
//                if (twoStudentOne.name.compareToIgnoreCase(twoStudentTwo.name) > 0) {
//                    return 1;
//                }
//                if (twoStudentOne.name.compareToIgnoreCase(twoStudentTwo.name) < 0) {
//                    return -1;
//                }
//                if (twoStudentOne.name.compareToIgnoreCase(twoStudentTwo.name) == 0) {
//                    return 0;
//                }
//            }
//        }
//        return 0;
//    }
//}
