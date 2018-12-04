package com.sheliming.thread.create;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        MyThread mt = new MyThread();
        Future<Integer> result = executor.submit(mt);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    public static class MyThread implements Callable<Integer> {

        public Integer call() throws Exception {
            System.out.println("子线程正在运行。。");
            Thread.sleep(3000);
            return 1000;
        }
    }
}
