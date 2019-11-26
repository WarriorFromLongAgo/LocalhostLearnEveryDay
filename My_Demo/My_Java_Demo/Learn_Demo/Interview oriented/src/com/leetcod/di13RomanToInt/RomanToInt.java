package com.leetcod.di13RomanToInt;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        HashMap<String, Integer> romanMap = new HashMap<>(7);
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);


    }
}
