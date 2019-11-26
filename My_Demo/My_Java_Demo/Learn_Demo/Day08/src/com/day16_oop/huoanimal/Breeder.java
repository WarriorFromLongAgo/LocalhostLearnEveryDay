package com.day16_oop.huoanimal;

public class Breeder extends Animal {
    @Override
    public void drinkWarter() {
        super.drinkWarter();
    }

    @Override
    public void eat() {
        System.out.println(" 吃饭 ");
    }

    public void train(Animal animal) {
        if (animal instanceof Dog) {
            drinkWarter();
            animal.eat();
            ((Dog) animal).SmimWay();
        } else if (animal instanceof Sheep) {
            drinkWarter();
            animal.eat();
            ((Sheep) animal).SmimWay();
        } else if (animal instanceof Frog) {
            drinkWarter();
            animal.eat();
        } else {
            System.out.println(" 饲养员不具备此类饲养权限， ");
            return;
        }
    }
}
