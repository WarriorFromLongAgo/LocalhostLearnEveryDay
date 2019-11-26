package com.leetcod.di12HighestWaterContainer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HighestWaterContainerTest {
    @Test
    public void testHighestWaterContainerTest() {
        HighestWaterContainer highestWaterContainer = new HighestWaterContainer();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = highestWaterContainer.highestWaterContainer(height);
        Assert.assertEquals(49,result);
    }
    @Test
    public void testHighestWaterContainerTest2() {
        HighestWaterContainer highestWaterContainer = new HighestWaterContainer();
        int[] height = new int[]{2,2,3,4};
        int result = highestWaterContainer.highestWaterContainer(height);
        Assert.assertEquals(6,result);
    }
    @Test
    public void testHighestWaterContainerTest3() {
        HighestWaterContainer highestWaterContainer = new HighestWaterContainer();
        int[] height = new int[]{4,2,3,4};
        int result = highestWaterContainer.highestWaterContainer(height);
        Assert.assertEquals(12,result);
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
