package com.day08_bie_kan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class grammerswitch {
    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put("20","222222");
//        map.put("30","333333");
//        map.put("40","444444");
//        map.put("50","555555");
//        map.put("60","666666");
//        Object o = map.get("20");
//        System.out.println(o);

//        Integer[] aaaa = {2, 20, 30};
//        if (aaaa instanceof Object[]) {
//            System.out.println("111111111");
//        } else {
//            System.out.println("22222222");
//        }

        Hashtable table = new Hashtable();
//        table.put(null, null);
//        table.put("aaa", null);
//        table.put(null, "aaaa");


        HashMap<String, Integer> map = new HashMap();
        map.put(null, null);
        map.put("aaa", null);
        map.put(null, 11);

        Object aaa = map.get("aaa");
        System.out.println(aaa);

        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        ArrayList<Object> arrayList2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add("" + i);
        }

        arrayList.remove("8");

        arrayList.get(1);

        arrayList.set(2,"22");


        Vector<Object> objects = new Vector<>();

//        int tempInt = 1;

//        System.out.println("switch题目");
//        switch (tempInt) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("输入的错误");
//        }
    }
}
