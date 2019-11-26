package com.day18_String.PetShopProject;

import java.util.ArrayList;
import java.util.List;

public class PetShop {
    //  用来存放宠物信息
    private List<Pet> petInfoList = new ArrayList<>();

    public void addPetInfo(Pet petMessage) {
        this.petInfoList.add(petMessage);
    }

    public List<Pet> findPetInfo(String str) {
        List<Pet> findList = new ArrayList<Pet>();

        Object[] objData = this.petInfoList.toArray();

        for (int i = 0; i < objData.length; i++) {
            Pet pet = (Pet) objData[i];
            if (pet.getName().contains(str) || pet.getColor().contains(str)) {
                findList.add(pet);
            }
        }
        return findList;
    }

    public List<Pet> getPetInfo() {
        return this.petInfoList;
    }

    public void deletePetInfo(Pet pet) {
        this.petInfoList.remove(pet);
    }

}
