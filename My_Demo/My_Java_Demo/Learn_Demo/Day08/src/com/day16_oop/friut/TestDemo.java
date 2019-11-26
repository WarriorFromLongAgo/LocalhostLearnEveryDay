package com.day16_oop.friut;

interface IFriut {
    public abstract void eat();
}

class Factory {
    public static IFriut getInstance(String className) {
        if ("apple".equals(className)) {
            return new Apple();
        }
        if ("orange".equals(className)) {
            return new Orange();
        }
        return null;
    }
}


class Apple implements IFriut {
    @Override
    public void eat() {
        System.out.println(" 削皮吃水果 ");
    }
}

class Orange implements IFriut {
    @Override
    public void eat() {
        System.out.println(" 剥皮吃水果 ");
    }
}

public class TestDemo {
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

