package com.day14_oop;

import java.util.Random;

public class day14main {
    public static void main(String[] args) {
     /*   day14Demo day14DemoOne = new day14Demo();
        day14Demo day14DemoTwo = new Day14DemoExtend();

        day14DemoOne.print();
        day14DemoTwo.print();
        day14DemoOne.eat();
        day14DemoTwo.eat();
*/

        Day14DemoExtend day14DemoThree = new Day14DemoExtend(1);
        day14Demo day14DemoFour = new day14Demo(1);
        System.out.println(day14DemoThree.id);
        System.out.println(day14DemoFour.id);

        System.out.println(Day14DemoExtend.ADDRESS);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int ii = random.nextInt(100);
            System.out.print(ii + ",");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            double iii = Math.random() * 100 + 1;
            System.out.print((int) iii + ",");
            //System.out.println();
        }

    }
}
