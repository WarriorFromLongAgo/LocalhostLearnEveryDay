package com.day24_Thread24.java8;

public class djh {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            char[] chars = new char[1024*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            System.out.println("guanbi ");
        }
    }
}
