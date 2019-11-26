package com.day25_she_ji_mo_shi.singlecasedesign.robot;

import java.awt.*;

public class demo1 {
    public static void main(String[] args) {
        Robot tempRobot = null;
        try {
            tempRobot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (tempRobot != null) {
            tempRobot.mouseMove(100, 100);
        }

    }
}
