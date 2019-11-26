package com.feijm.producthomework;

import java.util.HashMap;
import java.util.Map;

public class ProductMain {
    public static void main(String[] args) {
        JdbcDruidDeal jdbcDruidDeal = new JdbcDruidDeal();
//
//        String double1 = "2344036.09";
//        double v = Double.parseDouble(double1);
//        System.out.println(v);
//
//
//        String temp = "13-八月-2018";
//
//        String[] split = temp.split("-");
//        for (String string : split) {
//            System.out.print(string + ",");
//        }
//
//        System.out.println();
//
//        String outputStr = null;
//        Map<String, String> strStrMap = new HashMap<>();
//        strStrMap.put("一月", "01");
//        strStrMap.put("二月", "02");
//        strStrMap.put("三月", "03");
//        strStrMap.put("四月", "04");
//        strStrMap.put("五月", "05");
//        strStrMap.put("六月", "06");
//        strStrMap.put("七月", "07");
//        strStrMap.put("八月", "08");
//        strStrMap.put("九月", "09");
//        strStrMap.put("十月", "10");
//        strStrMap.put("十一月", "11");
//        strStrMap.put("十二月", "12");
//
//        if (strStrMap.containsKey(split[1])) {
//            split[1] = strStrMap.get(split[1]);
//        }
//        for (String string : split) {
//            System.out.print(string + ",");
//        }
//        System.out.println();
//        String input = split[2] + "-" + split[1];
//        System.out.println(input);

//        测试正常情况，cid存在，正常的加减
        jdbcDruidDeal.changePrice("1",-500);
//        测试cid不存在的时候，的情况
//        jdbcDruidDeal.changePrice("c009",-500);

//        jdbcDruidDeal.findIntervalPrice(500,5000);

//        jdbcDruidDeal.findToKeyword("娃娃");

//        jdbcDruidDeal.findToCid("c001");
//        jdbcDruidDeal.findToCid("c002");

//        jdbcDruidDeal.findToLength(3);

//        int flagReturnInt = jdbcDruidDeal.findFlagReturnInt(0);
//        System.out.println(flagReturnInt);


//        jdbcDruidDeal.insertProduct(new Product("键盘",300,1,"c003"));

//        jdbcDruidDeal.tempTen();

//        jdbcDruidDeal.productDesc();


    }
}
