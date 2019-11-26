package com.byit.model;

import java.lang.Exception;

public class Exception11 {
    public static void main(String args[]) throws Exception {

        dsds jdh = new dsds();
        jdh.EX();
    }
    //public static void ex() throw java.lang.Exception
}

class dsds {
    //直接抛出异常
    public int quotient(int x, int y) throws Exception {
        if (y < 0) {
            throw new MyException("除数不能是负数");
        }
        return x/y;
    }

    public void EX() { // 主方法
        int a = 3;
        int b = 0;
        try { // try语句包含可能发生异常的语句
            int result = quotient(a, b);
            // 处理自定义异常
        } catch (MyException e) {
            // 输出异常信息
            System.out.println(e.getMessage());
            // 处理ArithmeticException异常
        }
        //catch (ArithmeticException e) {
//            // 输出提示信息
//            System.out.println("除数不能为0");
//            // 处理其他异常
//        }
//
        catch (Exception e) {
            // 输出提示信息
            System.out.println("程序发生了其他的异常");
        }
    }

}

class MyException extends Exception {
    String message;

    public MyException(String ErrorMessagr) { // 父类方法
        message = ErrorMessagr;
    }

    @Override
    public String getMessage() { // 覆盖getMessage()方法
        return message;
    }
}

