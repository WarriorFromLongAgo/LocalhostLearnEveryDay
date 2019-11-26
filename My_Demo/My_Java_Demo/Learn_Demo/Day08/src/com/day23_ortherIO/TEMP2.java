package com.day23_ortherIO;

public class TEMP2 {
    public static void main(String[] args) {
        String str = "123567";
        char[] charArr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0) + "");
        sb.append(str.charAt(1) + "");
        sb.append(str.charAt(2) + "");
        sb.append(str.charAt(3) + "");
        sb.append(str.charAt(4) + "");
        sb.append(str.charAt(5) + "");

        char[] chars = sb.toString().toCharArray();

        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            if (value < Integer.parseInt(chars[i] + "")) {
                value = Integer.parseInt(chars[i] + "");
                System.out.println(value);
            }
        }
    }
}
