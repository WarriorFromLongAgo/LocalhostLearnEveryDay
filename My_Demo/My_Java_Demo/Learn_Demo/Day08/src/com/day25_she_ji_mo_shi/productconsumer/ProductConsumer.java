package com.day25_she_ji_mo_shi.productconsumer;

public class ProductConsumer {
    public static void main(String[] args) {
        MiddleWaiting middleWaiting = new MiddleWaiting();

        Thread product = new Thread(new Chef_Productor(middleWaiting));
        Thread consumer = new Thread(new Waiter_Consumer(middleWaiting));

        product.start();
        consumer.start();
    }
}
