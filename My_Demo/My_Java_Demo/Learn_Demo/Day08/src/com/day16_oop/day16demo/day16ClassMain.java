package com.day16_oop.day16demo;

public class day16ClassMain {
    public static void main(String[] args) {
        day16ClassPerson personOne = new day16ClassPerson();
        personOne.setName("feijm");
        personOne.eat();

        day16ClassPerson.Heart heartOne = personOne.new Heart(50);
        day16ClassPerson.Heart heartTwo = new day16ClassPerson().new Heart(50);

        // 静态类不能被调用
        // 语法规定，因为是个静态类，不能通过new对象去访问
//        day16ClassPerson personOTwo = new day16ClassPerson();
//         //只能有一个内部类吗
//        day16ClassPerson.Xueye xueyeFour = personOTwo.Xueye();
        //

        day16ClassPerson.Xueye xueyeOne = new day16ClassPerson.Xueye();

        //这句话的意思是，new一个对象，去调用他的属性
        //day16ClassPerson.Xueye xueyeThree = new day16ClassPerson().Xueye;

    }
}
