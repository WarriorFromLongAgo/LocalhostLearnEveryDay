package com.day18_String;

@SuppressWarnings("all")

public class Toup {
    @Deprecated
    public String toUpTemp(String strOne) {
        System.out.println(" 过气的 ");
        return strOne;
    }

    public String toUp(String strOne) {
        char[] charOne = strOne.toCharArray();
        if (charOne[0] >= 'A' && charOne[0] <= 'Z' || charOne[0] >= 'a' && charOne[0] <= 'z') {
            if (charOne[0] >= 65 && charOne[0] <= 90) {
                System.out.println(" 首字母已经是大写，不需要进行此操作 ");
            } else {
                charOne[0] = (char) (charOne[0] - 32);
            }
        } else {
            System.out.println(" 首字母不为字母，无需此操作 ");
        }
        for (int i = 1; i < strOne.length(); i++) {
            if (charOne[i] >= 'A' && charOne[i] <= 'Z') {
                charOne[i] = (char) (charOne[i] + 32);
            }
        }
        //String strTwo =
        return new String(charOne);
    }


}
