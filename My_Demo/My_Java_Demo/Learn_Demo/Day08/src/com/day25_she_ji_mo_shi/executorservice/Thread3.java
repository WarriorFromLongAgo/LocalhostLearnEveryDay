package com.day25_she_ji_mo_shi.executorservice;

import java.util.concurrent.TimeUnit;

public class Thread3 {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread pa = new Thread(new Work("A", c, a));
        pa.setName("pa");
        Thread pb = new Thread(new Work("B", a, b));
        pa.setName("pb");

        Thread pc = new Thread(new Work("C", b, c));
        pa.setName("pc");

        pa.start();
        TimeUnit.MILLISECONDS.sleep(100);
        pb.start();
        TimeUnit.MILLISECONDS.sleep(100);
        pc.start();
    }
}

class Work implements Runnable {
    private String name;
    private Object pre;
    private Object self;

    public Work(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (pre) {
                synchronized (self) {
                    System.out.print(name);
                    System.out.println();
                    count--;
                    //释放锁，开启下一次的条件
                    self.notify();
                }
                try {
                    if (count == 0) {
                        pre.notifyAll();
                    } else {
                        pre.wait();
                    }
                    //给之前的数据加锁
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }

            }

        }
    }
}