package com.day25_she_ji_mo_shi.singlecasedesign.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverTest {
    public static void main(String[] args) {
        Person personA = new Person();
        Person personB = new Person();
        Person personC = new Person();

        House house = new House(80000.0);

        house.addObserver(personA);
        house.addObserver(personB);
        house.addObserver(personC);

        house.setPrice(150000.0);
    }
}

class Person implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof House) {
            if (arg instanceof Double) {
                System.out.println("人们关注的房子价值上涨，新的价格是" + arg);
            }
        }
    }
}

class House extends Observable {
    private double price;

    public House(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > this.price) {
            super.setChanged();
            super.notifyObservers(price);
        }
        this.price = price;
    }

}
