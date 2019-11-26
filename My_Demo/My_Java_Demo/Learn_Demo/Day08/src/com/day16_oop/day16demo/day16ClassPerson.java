package com.day16_oop.day16demo;

public class day16ClassPerson {
    private String name;

    public day16ClassPerson() {

    }

    public day16ClassPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " 吃饭");
    }

    public class Heart {
        private int xueya;

        public Heart(int xueya) {
            this.xueya = xueya;
        }

        public int getXueya() {
            return xueya;
        }

        public void setXueya(int xueya) {
            this.xueya = xueya;
        }

        public void xintiao(int count) {
            System.out.println(name + " 心跳为 " + count);
        }
    }

    public static class Xueye {
        private int liusu;

        public Xueye() {
            System.out.println(" 静 态 ");
        }

        public Xueye(int liusu) {
            this.liusu = liusu;
        }

        public void liusuwei() {
            System.out.println("流速为 " + this.liusu);
        }
    }

}
