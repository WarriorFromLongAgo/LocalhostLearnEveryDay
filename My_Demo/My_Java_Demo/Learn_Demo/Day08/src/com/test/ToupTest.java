package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToupTest {
    /**
     * 测试Toup方法
     */
    @Test
    public void testToup() {
//        Toup toup = new Toup();
//        String strOne = "aaaBBB";
//        String outStr = toup.toUp(strOne);
//        System.out.println(" testUp+++++++ ");
//        //  断言，期望值，实际值
//        Assert.assertEquals("Aaabbb", outStr);

//        abcdabaa

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }

    /*
     * 初始化方法
     * 用于资源申请，所有的测试方法，在执行之前都会执行该方法。
     * */
    @Before
    public void init() {
        System.out.println(" init ");
    }

    /*
     * 释放资源
     * 所有方法，执行完成后，执行该方法
     * */
    @After
    public void close() {
        System.out.println(" close ");
    }
}
