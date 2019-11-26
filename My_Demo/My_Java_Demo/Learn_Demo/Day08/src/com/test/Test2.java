package com.test;

/**
 * @PackageName：com.test
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/11/2 20:22
 */
public class Test2 {
    public static void main(String[] args) {
        Test3 test = null;
        test.hello();
    }
}


class Test3 {
    public static void hello() {
        System.out.println("hello");
    }
}
