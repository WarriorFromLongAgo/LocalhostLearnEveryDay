package com.day25_she_ji_mo_shi.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        submit();
    }

    public static void submit()  {
        List<Future<String>> futures = new ArrayList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 10; i++) {
            Future<String> taskFuture = threadPoolExecutor.submit(new MyTask(i));
            //将每一个任务的执行结果保存起来
            futures.add(taskFuture);
        }
        //遍历所有任务的执行结果
        for (Future<String> future : futures) {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("google_lenve_fb" + "submit: "+future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

//                Log.d("google_lenve_fb", "submit: " + future.get());
        }

//        for (int i = 0; i < 100; i++) {
//            Future<String> futureTask = threadPoolExecutor.submit(new MyTask(i));
//            String string = null;
//            try {
//                string = futureTask.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(string);
//        }
        threadPoolExecutor.shutdown();
    }
}


class MyTask implements Callable<String> {

    private int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回每一个任务的执行结果
        return "call()方法被调用----" + Thread.currentThread().getName() + "-------" + taskId;
    }
}
