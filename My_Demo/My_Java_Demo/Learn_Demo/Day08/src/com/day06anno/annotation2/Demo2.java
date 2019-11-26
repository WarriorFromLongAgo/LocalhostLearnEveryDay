package com.day06anno.annotation2;

public class Demo2 {

    @TwoAnno(name = "one")
    public int one() {
        System.out.println("methodone");
        return 1;
    }

    @TwoAnno(name = "two")
    public void two() {
        System.out.println("methodtwo");
    }

    @TwoAnno(name = "three")
    public int three() {
        System.out.println("methodthree");
        return 3;
    }

}
