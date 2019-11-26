package com.feijm.execldeal;

import java.util.HashMap;
import java.util.Map;

public class ExeclModel {
    //  对应文件中的预结账日期
    private String billingTime;
    //  对应文件中的金额
    private double payment;

    public ExeclModel() {
    }

    public ExeclModel(String billingTime, double payment) {
        billingTime = changeBillingTime(billingTime);
        this.billingTime = billingTime;
        this.payment = payment;
    }

    private String changeBillingTime(String billingTime) {
        String[] split = billingTime.split("-");

        Map<String, String> strStrMap = new HashMap<>();
        strStrMap.put("一月", "01");
        strStrMap.put("二月", "02");
        strStrMap.put("三月", "03");
        strStrMap.put("四月", "04");
        strStrMap.put("五月", "05");
        strStrMap.put("六月", "06");
        strStrMap.put("七月", "07");
        strStrMap.put("八月", "08");
        strStrMap.put("九月", "09");
        strStrMap.put("十月", "10");
        strStrMap.put("十一月", "11");
        strStrMap.put("十二月", "12");

        if (strStrMap.containsKey(split[1])) {
            split[1] = strStrMap.get(split[1]);
        }
        String outputStr = split[2] + "-" + split[1];

        return outputStr;
    }

    @Override
    public String toString() {
        return "ExeclModel {" +
                "billingTime='" + billingTime + '\'' +
                ", payment=" + payment +
                '}';
    }

    public String getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(String billingTime) {
        this.billingTime = billingTime;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
