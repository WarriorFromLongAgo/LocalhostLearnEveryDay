package com.day16_oop.huomouse;

public class Mouse extends Laptop implements USBInterface {
    @Override
    public void openPort() {
        System.out.println(" 使用USB鼠标 ");
    }

    @Override
    public void closePort() {
        System.out.println(" 断开usb鼠标 ");
    }
}
