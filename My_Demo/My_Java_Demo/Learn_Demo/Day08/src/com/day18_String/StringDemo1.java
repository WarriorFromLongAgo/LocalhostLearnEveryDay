package com.day18_String;

public class StringDemo1 {
    public static void main(String[] args) {
        //equalsDemo();
        //toUp();
        //countNum();
        //reverse();
        int index = indexOfDemo();
        System.out.println(index);
    }

    private static void equalsDemo() {
        String str1 = "asd";
        String str2 = new String("asd");
        System.out.println("str1==str2 = " + (str1 == str2));
        System.out.println("str1.equals(str2) = " + str1.equals(str2));

        String str3 = "abc";
        String str4 = "a" + "b" + "c";
        String str5 = "ab";
        String str6 = str5 + "c";
        System.out.println("所有的结果都是 abc ");
        //  true
        System.out.println(str3 == str4);
        //  false
        System.out.println(str3 == str6);
        //  true
        System.out.println(str3.equals(str4));
        //  true
        System.out.println(str3.equals(str6));
    }


    public static void countNum() {
        //String strOne = "lll";
        // lll AAA GGG  www 123 478 DFS
        String strOne = "4lA71AG8wG2wGA3FlwDlA";
        System.out.println(strOne.length());

        int left = 0;
        int right = strOne.length() - 1;
        int count = 0;

        char middleChar = ' ';
        int middleInt = left + ((right - left) / 2);

        if ((strOne.length() & 1) == 1) {
            middleChar = strOne.charAt(middleInt);
        }
        int up = 0;
        int low = 0;
        int num = 0;
        while (count < middleInt) {
            if (strOne.charAt(left) >= 65 && strOne.charAt(left) <= 90) {
                up++;
            }
            if (strOne.charAt(left) >= 97 && strOne.charAt(left) <= 122) {
                low++;
            }
            if (strOne.charAt(left) >= 48 && strOne.charAt(left) <= 57) {
                num++;
            }
            if (strOne.charAt(right) >= 65 && strOne.charAt(right) <= 90) {
                up++;
            }
            if (strOne.charAt(right) >= 97 && strOne.charAt(right) <= 122) {
                low++;
            }
            if (strOne.charAt(right) >= 48 && strOne.charAt(right) <= 57) {
                num++;
            }
            left++;
            right--;
            count++;
        }
        if (middleChar >= 65 && strOne.charAt(left) <= 90) {
            up++;
        }
        if (middleChar >= 97 && strOne.charAt(left) <= 122) {
            low++;
        }
        if (middleChar >= 48 && strOne.charAt(left) <= 57) {
            num++;
        }

        System.out.println("up = " + up);
        System.out.println("low = " + low);
        System.out.println("num = " + num);
    }

    public static void reverse() {
        String strOne = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("strOne = " + strOne);
        System.out.println(strOne.length());

        char[] charArr = strOne.toCharArray();

        int left = 0;
        int right = strOne.length() - 1;

        System.out.println("charArrLength = " + (strOne.length() / 2));

        int count = 0;
        while (count < (strOne.length() / 2)) {

            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;
            count++;
        }
        String strTwo = new String(charArr);
        System.out.println("strTwo = " + strTwo);
    }

    public static int indexOfDemo() {
        String strOne = "Fuck World ";
        String strTwo = "k W";

        if (strOne.length() == 0 || strOne == "") {
            if (strTwo.length() != 0 || strTwo != "") {
                System.out.println("strOne == 空 strTwo不为空 ，无法开展比对");
                return -1;
            } else {
                System.out.println("两个string 都为空");
                return -1;
            }
        }
        if (strTwo.length() == 0 || strTwo == "") {
            System.out.println("strTwo == 空，无法开展比对");
            return -1;
        }

        for (int i = 0; i < strOne.length() - strTwo.length(); i++) {
            char charOne = strOne.charAt(i);
            char charTwo = strTwo.charAt(0);
            if (charOne == charTwo) {
                boolean flag = true;
                for (int j = 1; j < strTwo.length(); j++) {
                    char charThree = strOne.charAt(i + j);
                    char charFour = strTwo.charAt(j);
                    if (charThree != charFour) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

}
