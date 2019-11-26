package com.day13_Compare.day13;

public class day13DemoMain {
    public static void main(String[] args) {
        day13Demo day13DemoOne = new day13Demo(1000);
        day13Demo day13DemoTwo = new day13Demo(100);

        day13DemoOne.print();
        day13DemoTwo.print();
        String x =  day13Demo.strOne;

        int compare = day13DemoOne.Compare(day13DemoTwo);
        System.out.println(compare);

        compare = day13DemoTwo.Compare(day13DemoOne);
        System.out.println(compare);

        day13DemoTwo.setIntOne(1000);
        compare = day13DemoOne.Compare(day13DemoTwo);
        System.out.println(compare);
    }
}
