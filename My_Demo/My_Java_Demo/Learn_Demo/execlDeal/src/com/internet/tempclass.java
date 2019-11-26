package com.internet;

public class tempclass {
    public static void main(String[] args) {
        String temp = "             ";
        System.out.println(temp);
        System.out.println(temp.length());

        String trim = temp.trim();
        System.out.println(trim);
        System.out.println(trim.length());
        System.out.println("".equals(trim));
    }
}
