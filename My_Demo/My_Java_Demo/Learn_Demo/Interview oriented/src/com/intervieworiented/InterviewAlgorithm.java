package com.intervieworiented;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author:
 * @Project:
 * @Time:
 * @version:
 * @修改原因: 2019届vivo秋招笔试题第一题
 * <p>
 * 请对组字符串进行排序，字符串由大小写字母和数字组成，需要满足以下比较规则
 * <p>
 * 1、长度不同时，长度较短在排前面
 * 2、长度相同时，按照字典顺序排列（AaBb-Zz, 0-9顺序)，即大写字母在小写字母前，数字排在字母后，要求时间复杂度为O(nlogn)。
 * 比如:
 * abc Abc 123 1bc CBD abed a
 * 排序后结果为:
 * a 1 Abc abc CBD 1bc 123 abcd
 * <p>
 * ---------------------
 * 作者：扎个冲天揪
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_17556191/article/details/94761375
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class InterviewAlgorithm {
    public static void main(String[] args) {
        String[] StrArr = {"abc", "Abc", "123", "1", "1bc", "CBD", "abcd", "a"};
        StringCompare stringCompare = new StringCompare();
        stringCompare.stringCompare(StrArr);

    }
}

class StringCompare {
    public void stringCompare(String[] inputStrArr) {
        Set strSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String strOne = (String) o1;
                String strTwo = (String) o2;

                int tempLength = strOne.length() - strTwo.length();


                return -1;
            }


        });
    }
}
