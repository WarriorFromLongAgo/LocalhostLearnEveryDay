package com.day15_interence.day15employee;

public abstract class day15Demo {
    public int xinzi;
    public String Name;

    public day15Demo() {

    }

    public day15Demo(int xinzi, String name) {
        this.xinzi = xinzi;
        this.Name = name;
    }

    public abstract void work();

}
