package com.day19_treeset_sql.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class day19String {
    public static void main(String[] args) {
        String tempStr = "ad";
        Map<Character, Integer> mapCharInt = new HashMap<>();
//        mapCharInt = mapContainDeal(tempStr, mapCharInt);
        char middleChar = ' ';
        if ((tempStr.length() & 1) == 1) {
            middleChar = tempStr.charAt(tempStr.length() / 2);
        }
//        System.out.println(middleChar);
        for (int i = 0; i < tempStr.length() / 2; i++) {
            char left = tempStr.charAt(i);

        }
        //方法    1
        //mapCharInt = mapContainDeal(tempStr, mapCharInt);
        //mapTraversing(tempStr, mapCharInt);
    }

    //  map的打印
    private static void mapTraversing(String tempStr, Map<Character, Integer> mapCharInt) {
        System.out.println("String = " + tempStr);
        System.out.println("======================================================================");
        System.out.println();
        System.out.println("entrySet 的遍历方式 ");
        for (Map.Entry<Character, Integer> EntryCharInt : mapCharInt.entrySet()) {
            System.out.print("key = " + EntryCharInt.getKey());
            System.out.println(",,,value = " + EntryCharInt.getValue());
        }
        System.out.println("======================================================================");
        System.out.println();
        System.out.println("keySet 的遍历方式");
        Set<Character> setKeyChar = mapCharInt.keySet();
        for (Character keyChar : setKeyChar) {
            Integer valueInt = mapCharInt.get(keyChar);
            System.out.print("key = " + keyChar);
            System.out.println(",,,value = " + valueInt);
        }
    }

    /**
     * @Author: feijm
     * @Project: 对 tempStr 进行处理，判断每个char出现了几次
     * @Time: 2019年8月1日11:48:37
     * @version: 1.0.0
     * @修改原因:
     */
    private static Map<Character, Integer> mapContainDeal(String tempStr, Map<Character, Integer> mapCharInt) {
        //  从头到尾遍历一遍
        //  也可以判断value是否存在，如果存在，则value++，然后替换
        for (int i = 0; i < tempStr.length(); i++) {
            //  System.out.println(tempStr.charAt(i));
            //  如果在map的key值中发现存在 对应的 char
            if (mapCharInt.containsKey(tempStr.charAt(i))) {
                //  返回对应key键的value，并把value++后，对该key值的value进行替换
                Integer keyValue = mapCharInt.get(tempStr.charAt(i));
                mapCharInt.replace(tempStr.charAt(i), keyValue, ++keyValue);
            } else {
                //  如果在map的key值中 没有发现存在对应的 char
                //  则将该char 插入map中，并对value赋值为 1
                mapCharInt.put(tempStr.charAt(i), 1);
            }
        }
        return mapCharInt;
    }
}
