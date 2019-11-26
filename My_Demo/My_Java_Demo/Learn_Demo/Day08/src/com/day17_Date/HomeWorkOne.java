package com.day17_Date;

public class HomeWorkOne {
    public static void main(String[] args) {
        Computer computer1 = new Computer(6000, "华硕", 17, 16);
        computer1.computerRun();
        Computer computer2 = new Computer(6000, "华硕", 17, 16);
        computer2.computerRun();
        Computer computer3 = new Computer(6000, "小米", 17, 16);
        computer3.computerRun();

        boolean flag = computer1.equals(computer2);
        System.out.println(flag);
        flag = computer1.equals(computer3);
        System.out.println(flag);
    }
}

class Computer {
    private int price;
    private String brand;
    private int dimension;
    private int ramSize;

    public Computer() {
    }

    public Computer(int price, String brand, int dimension, int ramSize) {
        this.price = price;
        this.brand = brand;
        this.dimension = dimension;
        this.ramSize = ramSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void computerRun() {
        System.out.print("价值" + this.price + "元，品牌为" + this.brand + "的电脑，电脑屏幕是" + this.dimension);
        System.out.println("寸、内存容量为" + this.ramSize + "G");
    }

    @Override
    public boolean equals(Object object) {
        Computer computer = (Computer) object;
        if (this.brand == computer.brand && this.dimension == computer.dimension && this.ramSize == computer.ramSize) {
            return true;
        }
        else {
            System.out.println(this.brand);
            System.out.println(computer.brand);
            return false;
        }
    }
}

