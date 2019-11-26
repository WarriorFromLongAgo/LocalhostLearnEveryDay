package com.day18_String;

public class StringDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilderOne = new StringBuilder();
        StringBuilder stringBuilderTwo = new StringBuilder();
        System.out.println("stringBuilderOne = " + stringBuilderOne);
        System.out.println("stringBuilderTwo = " + stringBuilderTwo);

        stringBuilderOne.append("a");
        System.out.println("stringBuilderOne = " + stringBuilderOne);
        System.out.println("stringBuilderTwo = " + stringBuilderTwo);

    }
}
