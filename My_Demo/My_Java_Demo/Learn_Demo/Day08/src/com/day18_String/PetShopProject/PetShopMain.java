package com.day18_String.PetShopProject;

import java.util.List;

public class PetShopMain {
    public static void main(String[] args) {
        PetShop petShop = new PetShop();
        petShop.addPetInfo(new Dog("金毛", "黄色", 2));
        petShop.addPetInfo(new Dog("二哈", "黑白色", 3));
        petShop.addPetInfo(new Dog("萨摩耶", "黑色", 3));
        petShop.addPetInfo(new Dog("牧羊犬", "白色", 1));
        petShop.addPetInfo(new Cat("布偶猫", "白色", 1));
        petShop.addPetInfo(new Cat("田园猫", "黑白色", 1));
        petShop.addPetInfo(new Cat("白猫", "黑色", 1));

        List<Pet> allList = petShop.findPetInfo("白");

        Object[] objArr = allList.toArray();
        for (int i = 0; i < objArr.length; i++) {
            System.out.println(objArr[i]);
        }
    }
}
