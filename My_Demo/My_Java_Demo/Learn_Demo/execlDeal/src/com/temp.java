//package com;
//
//import java.util.LinkedList;
//import java.util.List;
//
///*
// * 其中一个数只出现一次，另一个可以出现任意次数
// * 寻找，集合中中只出现一次的数字
// * list，或者 arrarylist
// *
// * */
//public class temp {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 10;
//        method(a, b);
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
////        List<Integer> intList = new LinkedList<>();
////        intList.add(1);
////        intList.add(1);
////        intList.add(1);
////        intList.add(1);
////        intList.add(2);
////
////        Integer outInt = null;
////
////        //  数组为空
////        if (intList.isEmpty()) {
////            System.out.println("数组为空，不可以查询");
////        } else if (intList.size() == 1) {
////            outInt = intList.get(0);
////            System.out.println(outInt);
////        } else if (intList.size() == 2 && !(intList.get(0).equals(intList.get(1)))) {
////            System.out.println("数组长度为2，无法比较");
////        } else {
////            Integer tempInt = intList.remove(0);
////            List<Integer> oneList = new LinkedList<>();
////            List<Integer> twoList = new LinkedList<>();
////
////            oneList.add(tempInt);
////
////            for (int i = 0; i < intList.size(); i++) {
////                if (intList.get(i).equals(tempInt)) {
////                    oneList.add(intList.get(i));
////                } else {
////                    twoList.add(intList.get(i));
////                }
////            }
////
////            if (twoList.isEmpty()) {
////                System.out.println("数组里面只存在相同的数字");
////            } else {
////                outInt = (oneList.size() == 1 ? oneList.get(0) : twoList.get(0));
////                System.out.println(outInt);
////            }
////        }
//
//
//
//
//
//
//
//
//
//
//    }
//
//    public static void method(int a, int b) {
//        ++a;
//        ++b;
//    }
//}
