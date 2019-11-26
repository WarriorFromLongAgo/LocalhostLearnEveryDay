package com.day24_Thread24.runable;

public class RunAble {
    public static void main(String[] args) {
        RunRunAble one = new RunRunAble();
        RunRunAble two = new RunRunAble();
        RunRunAble three = new RunRunAble();
        RunRunAble four = new RunRunAble();

        Thread oneThread = new Thread(one);
        oneThread.setName(" one ");
        Thread twoThread = new Thread(two);
        twoThread.setName(" two ");
        Thread threeThread = new Thread(three);
        threeThread.setName(" three ");
        Thread fourThread = new Thread(four);
        fourThread.setName(" four ");

        String obOne = "asd";
        String obTwo = "as";
        System.out.println(obOne==obTwo);
        System.out.println(obOne.equals(obTwo));

        oneThread.start();
        twoThread.start();
        threeThread.start();
        fourThread.start();
    }
}
