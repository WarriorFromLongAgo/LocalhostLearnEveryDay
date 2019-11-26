package com.byit.model;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: feijm
 * @Time: 2019年7月14日14:25:13
 * @version: 1.0
 * @修改原因: 无
 */

public class StringGrammar {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        int i = 4;
//        if ((i & 1) == 0) {
//            System.out.println("偶数");
//        }else {
//            System.out.println("奇数");
//        }
        int i = 3;


//        String inputStr = "1234";
//        System.out.println("inputStr.isEmpty() = " + inputStr.isEmpty());
//
//        StringTest ff = new StringTest();
//        ff.constructor();
//
//        ff.strCharAt(inputStr);
//        ff.strContains(inputStr);
//        ff.strEndsWithHashCode(inputStr);
//        ff.strEquals();
//        ff.strGetBytes(inputStr);
//        ff.strIndexOf(inputStr);
//        ff.strJoin();
//        ff.strReplace();
//        ff.strSplit();
//        ff.strTrim();
    }
}

class StringTest {
    public void constructor() throws UnsupportedEncodingException {
        //  构造函数
        String strOne = new String();
        //  什么都不会打印。空格都没有。定义变量后，以及赋值，但是赋值为空，注意不是null
        System.out.println(strOne);

        byte[] byteArr = new byte[]{65, 66, 67, 68};
        String strTwo = new String(byteArr);
        //  ABCD    了解一下ACSii码表
        System.out.println(strTwo);

        //  BC      解密 66 67，从1开始，长度为2
        String strThree = new String(byteArr, 1, 2);
        System.out.println(strThree);

        char[] charOne = new char[]{'a', 'b', 'c', 'd'};
        String strFour = new String(charOne);
        System.out.println(strFour);

        String strFive = new String(charOne, 1, 2);
        System.out.println(strFive);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sbb");
        String strSix = new String(stringBuilder);
        System.out.println(strSix);
        System.out.println("============================================");
    }

    public void strCharAt(String inputStr) {
        System.out.print("String的打印 = ");
        for (int i = 0; i < inputStr.length(); i++) {
            System.out.print(inputStr.charAt(i) + "，");
        }
        System.out.println();
        System.out.println("============================================");
    }

    public void strContains(String inputStr) {
        System.out.println(" inputStr.contains 123 = " + inputStr.contains("123"));
        System.out.println(" inputStr.contains 空 = " + inputStr.contains(""));
        System.out.println(" inputStr.contains 空格 = " + inputStr.contains(" "));

        System.out.println(" 1245693 .contains 123 = " + "1245693".contains("123"));
        System.out.println(" 1234567 .contains 123 = " + "1234567".contains("123"));
        System.out.println(" 9843123 .contains 123 = " + "9843123".contains("123"));
        System.out.println("============================================");

    }

    public void strEndsWithHashCode(String inputStr) {
        System.out.println("inputStr.endsWith 4 = " + inputStr.endsWith("4"));
        System.out.println("inputStr.endsWith 34 = " + inputStr.endsWith("34"));
        System.out.println("inputStr.endsWith 234 = " + inputStr.endsWith("234"));
        System.out.println("inputStr.endsWith 1234 = " + inputStr.endsWith("1234"));
        System.out.println("inputStr.endsWith 3 = " + inputStr.endsWith("3"));
        System.out.println();
        System.out.println("inputStr.startsWith 4 = " + inputStr.startsWith("4"));
        System.out.println("inputStr.startsWith 1 = " + inputStr.startsWith("1"));
        System.out.println("inputStr.startsWith 1234 = " + inputStr.startsWith("1234"));
        System.out.println("inputStr.startsWith 4 , 3 = " + inputStr.startsWith("4", 3));
        System.out.println("inputStr.startsWith 3 , 2 = " + inputStr.startsWith("3", 2));

        System.out.println();
        System.out.println("inputStr.hashCode() = " + inputStr.hashCode());
        System.out.println("1234.HashCod() = " + "123".hashCode());
        System.out.println("============================================");

    }

    public void strEquals() {
        String one = "hello";
        String two = new String("hello");
        String three = "HeLLo";
        //  比较内存地址
        System.out.println("(one == two) = " + (one == two));
        //  对比两个字符串的内容。one.charAt == two.charAt
        System.out.println("one.equals(two) = " + one.equals(two));
        System.out.println();
        //  比较。不区分大小写
        System.out.println("one.equalsIgnoreCase three = " + one.equalsIgnoreCase(three));
        System.out.println();
        String four = new String("1234").intern();
        System.out.println("String three = 1234 intern 后 (three == two) = " + (four == one));
        System.out.println("String three = 1234 intern 后 three.equals(two) = " + four.equals(one));
        System.out.println("============================================");

    }

    public void StrFormat() {

    }

    /**
     * @Author:
     * @Time:
     * @version:
     * @修改原因:
     */
    public void strValueOf(String inputStr) {
        String strNull = "";
        String strOne = "1234";
        String strTwo = "12";

    }

    public byte[] strGetBytes(String inputStr) {
        byte[] bytes = new byte[inputStr.length()];
        bytes = inputStr.getBytes();
        System.out.print("bytes[i] = ");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + "，");
        }
        System.out.println();
        System.out.println("============================================");
        return bytes;
    }

    public void strIndexOf(String inputStr) {
        System.out.println("inputStr.indexOf 48 0 = " + inputStr.indexOf(48));
        System.out.println("inputStr.indexOf 49 1 = " + inputStr.indexOf(49));
        System.out.println("inputStr.indexOf 52 4 = " + inputStr.indexOf(52));


        System.out.println("inputStr.indexOf 1 = " + inputStr.indexOf("1"));
        System.out.println("inputStr.indexOf 4 = " + inputStr.indexOf("4"));

        System.out.println("inputStr.indexOf (1, 1) = " + inputStr.indexOf("1", 1));
        System.out.println("inputStr.indexOf (4, 1) = " + inputStr.indexOf("4", 1));

        System.out.println("inputStr.indexOf (49 1, 1) = " + inputStr.indexOf(49, 1));
        System.out.println("inputStr.indexOf (52 4, 1) = " + inputStr.indexOf(52, 1));

        System.out.println("inputStr.lastIndexOf 49 1 = " + inputStr.lastIndexOf(49, 1));
        System.out.println("inputStr.lastIndexOf 52 4 = " + inputStr.lastIndexOf(52, 1));

        System.out.println("inputStr.lastIndexOf 1 = " + inputStr.lastIndexOf("1"));
        System.out.println("inputStr.lastIndexOf 4 = " + inputStr.lastIndexOf("4"));

        System.out.println("inputStr.lastIndexOf (1, 1) = " + inputStr.lastIndexOf("1", 1));
        System.out.println("inputStr.lastIndexOf (4, 1) = " + inputStr.lastIndexOf("4", 1));

        System.out.println("============================================");
    }

    //public static String join(CharSequence delimiter, CharSequence... elements)       "-","Java","is","cool"
    public void strJoin() {
        String outputStr = String.join("-", "1", "2", "3");
        System.out.println("outputStr= " + outputStr);

        List names = new ArrayList<String>();
        names.add("1");
        names.add("2");
        names.add("3");
        System.out.println("names= " + String.join("-", names));

        String[] arrStr = new String[]{"a", "b", "c"};

        System.out.println("arrStr= " + String.join("-", arrStr));
        System.out.println("============================================");
    }

    public void strReplace() {
        String oneStr = "aaabbb";
        System.out.println("oneStr.replace = " + oneStr.replace("a", "A"));
        System.out.println("oneStr = " + oneStr);
        System.out.println("oneStr.replace = " + oneStr.replace('a', 'A'));
        System.out.println("oneStr = " + oneStr);
        System.out.println("oneStr.replaceAll = " + oneStr.replaceAll("a", "A"));
        System.out.println("oneStr = " + oneStr);
        System.out.println("oneStr.replaceAll = " + oneStr.replaceAll("\\d", "Z"));
        System.out.println("oneStr = " + oneStr);
        System.out.println("oneStr.replaceFirst = " + oneStr.replaceFirst("b", "B"));
        System.out.println("oneStr = " + oneStr);
        System.out.println("============================================");

    }

    public void strSplit() {
        String oneStr = "boo:and:foo";
        System.out.println(oneStr);
        String[] outputStr = oneStr.split(":");
        for (String i : outputStr) {
            System.out.print(i + "，");
        }
        System.out.println();
        System.out.println("============================================");
        outputStr = oneStr.split("o");
        for (String i : outputStr) {
            System.out.print(i + "，");
        }
        System.out.println();
        System.out.println("============================================");
        outputStr = oneStr.split("o", 4);
        for (String i : outputStr) {
            System.out.print(i + "，");
        }
        System.out.println();
        System.out.println("============================================");
        System.out.println("    拆分IP地址  ");
        String TwoStr = "192.168.1.1";
        outputStr = TwoStr.split("\\.");
        for (String i : outputStr) {
            System.out.println(i);
        }
        System.out.println("============================================");
        String Three = "Feijm:20|Feijd:15|Feijgh:10|Feiks:100";
        outputStr = Three.split("\\|");
        for (int i = 0; i < outputStr.length; i++) {
            String[] TempStr = outputStr[i].split(":");
            System.out.println(TempStr[0] + " = " + TempStr[1]);
        }

        System.out.println("============================================");
    }

    public void strTrim() {
        String oneStr = "  4564 5465";
        System.out.println("oneStr.trim = " + oneStr.trim());

        //oneStr.compareTo()


    }
}
