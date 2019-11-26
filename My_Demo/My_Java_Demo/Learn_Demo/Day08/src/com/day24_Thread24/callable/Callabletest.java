package com.day24_Thread24.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callabletest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Mythread2());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}

class Mythread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "1111111111111";
    }
}
