package com.day13_Compare.day13;

public class day13Demo {
    static String strOne = "bianyiit";
    private int intOne;

    public day13Demo(int intOne) {
        this.intOne = intOne;
    }

//    public day13Demo(int intOne, String strOne) {
//        this.IntOne = intOne;
//        this.strOne = strOne;
//    }

    public String getStrOne() {
        return strOne;
    }

    public void setStrOne(String strOne) {
        strOne = strOne;
    }

    public int getIntOne() {
        return this.intOne;
    }

    public void setIntOne(int intOne) {
        this.intOne = intOne;
    }

    public void print() {
        System.out.println("strOne " + strOne + ",,IntOne" + this.intOne);
    }

    public int Compare(day13Demo day13Demo) {
        if (this.getIntOne() > day13Demo.getIntOne()) {
            return 1;
        } else if (day13Demo.getIntOne() > this.intOne) {
            return -1;
        } else {
            return 0;
        }
    }
}
