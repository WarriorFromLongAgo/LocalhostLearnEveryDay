package com.day16_oop.huomouse;

public class LaptopMain {
    public static void main(String[] args) {
        Laptop laptopOne = new Mouse();
        Laptop laptopTwo = new KeyBoard();
        laptopOne.laptopBoot();

        Mouse mouse = (Mouse) laptopOne;
        mouse.openPort();
        mouse.closePort();

        KeyBoard keyBoard = (KeyBoard) laptopTwo;
        keyBoard.openPort();
        keyBoard.closePort();

        laptopOne.laptopShutDown();
    }
}
