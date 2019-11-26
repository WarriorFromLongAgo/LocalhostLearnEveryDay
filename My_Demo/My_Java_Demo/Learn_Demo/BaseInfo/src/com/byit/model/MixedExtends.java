package com.byit.model;

public class MixedExtends {
    public static void main(String[] args) {

        C c = new C();

        A a2 = new C();
        a2.m1();
        a2.m2();
        a2.m3();
    }
}

abstract class A {
    int ivar = 7;
    public void m1() {
        System.out.println("A + m1");
    }

    public void m2() {
        System.out.println("A + m2");
    }

    public void m3() {
        System.out.println("A + m3");
    }
}

class B extends A {
    public void m1() {
        System.out.println("B + m1");
    }
}

class C extends B {
    public void m3() {
        System.out.println("C + m3  " + (ivar + 6));
    }
}
