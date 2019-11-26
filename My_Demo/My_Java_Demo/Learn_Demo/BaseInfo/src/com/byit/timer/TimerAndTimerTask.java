package com.byit.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAndTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //  单位是毫秒，1秒后开始执行，然后每两秒执行一次
        timer.schedule(new myTask(), 1000, 2000);
    }
}

class myTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }
}