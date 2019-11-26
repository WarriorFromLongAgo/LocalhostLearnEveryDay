package com.day14_oop.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalMain {
    public static void main(String[] args) {
        //Dog dog = new Dog(2);
        Cat cat = new Cat();
        cat.eat();
        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(1111);
        listTwo.add(2222);
        Collections.sort(listTwo);
        Collections.addAll(listTwo, 3333);
        Collections.addAll(listTwo, 3333);
        Collections.addAll(listTwo, 3333);
        Collections.addAll(listTwo, 4444);

        int i = Collections.max(listTwo);
        System.out.println(i);
        System.out.println(Collections.min(listTwo));
        Collections.replaceAll(listTwo, 3333, 33333333);
        System.out.println(listTwo.toString());
        Collections.reverse(listTwo);
        System.out.println(listTwo.toString());
        Collections.rotate(listTwo, 2);
        System.out.println(listTwo.toString());
        System.out.println(" Collections.shuffle(listTwo) ");
        Collections.shuffle(listTwo);
        System.out.println(listTwo.toString());
        System.out.println(" Collections.sort(listTwo) ");
        Collections.sort(listTwo);
        System.out.println(listTwo.toString());
        System.out.println(" Collections.swap(listTwo,1,3); ");
        Collections.swap(listTwo, 1, 3);
        System.out.println(listTwo.toString());
        System.out.println(" Collections.synchronizedList(listTwo);");
        List<Integer> listThree = Collections.synchronizedList(listTwo);
        System.out.println(listThree.toString());


//        for (Integer integer : listTwo) {
//            System.out.print(integer + ",");
//        }
//        System.out.println();
//        List<Integer> listThree = new ArrayList<>();
//        System.out.println(listThree.size());
//        Collections.copy(listThree, listTwo);
//
//
//        for (Integer integer : listTwo) {
//            System.out.print(integer + ",");
//        }
//        System.out.println();
//        for (Integer integer : listThree) {
//            System.out.print(integer + ",");
//        }
//        System.out.println();
    }
}
