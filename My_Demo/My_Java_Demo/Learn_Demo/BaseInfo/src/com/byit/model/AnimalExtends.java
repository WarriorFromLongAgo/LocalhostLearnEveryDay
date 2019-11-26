package com.byit.model;

public class AnimalExtends {
    public int xx = 10;
    public void MakeNoise(){
        System.out.println("AnimalExtends + MakeNoise");
    }
    public void Eat(){
        System.out.println("AnimalExtends + Eat");
    }
    public void Sleep(){
        System.out.println("AnimalExtends + Sleep");
    }
    public void Roma(){
        System.out.println("AnimalExtends + Roma");
    }


    public static void main(String[] args) {
        Wolf wol = new Wolf();
        AnimalExtends ani = new AnimalExtends();
        wol.Roma();//AnimalExtends + Roma
        System.out.println(wol.xx);//20
        //System.out.println(xx);//当没有实例化Animal，则报错
        System.out.println(ani.xx);//10

        System.out.println();
        AnimalExtends AniWol = new Wolf();
        System.out.println(AniWol.xx);
        AniWol.Eat();
        AniWol.MakeNoise();
        AniWol.Roma();
        AniWol.Sleep();
    }
}
class Canine extends AnimalExtends {
    public void Roma(){
        System.out.println("Canine + Roma");
    }

}
class Wolf extends AnimalExtends {
    public void MakeNoise(){
        System.out.println("Wolf + MakeNoise");
    }
    public void Eat(){
        System.out.println("Wolf + Eat");
    }
    public int xx = 20;
}
class Vet{
    public void GiveShot(AnimalExtends a){
        a.MakeNoise();
    }
}


/**
 * Wolf w = new Wolf() ;
 * w.MakeNoise ---- Wolf.MakeNoise
 * w.roma ----- Canine.roma
 * w.eat ----- Wolf.Eat
 * w.sleep ----- AnimalExtends.sleep
* */
