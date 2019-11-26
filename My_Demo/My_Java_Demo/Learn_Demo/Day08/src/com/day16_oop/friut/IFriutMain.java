package com.day16_oop.friut;

public class IFriutMain {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("对不起，程序执行错误");
            System.out.println("正确的格式为：");
            System.out.println("java IFriutMain 类名称 ");
            System.exit(1);
        }
        IFriut friut = Factory.getInstance(args[0]);
        friut.eat();
    }
}
