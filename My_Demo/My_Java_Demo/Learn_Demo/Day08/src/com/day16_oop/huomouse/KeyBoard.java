package com.day16_oop.huomouse;

public class KeyBoard extends Laptop implements USBInterface{
    @Override
    public void openPort() {
        System.out.println(" 使用USB键盘 ");
    }

    @Override
    public void closePort() {
        System.out.println(" 断开usb键盘 ");
    }
}
