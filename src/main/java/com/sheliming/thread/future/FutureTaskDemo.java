package com.sheliming.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call do something");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        System.out.println("main do something");
        Thread.sleep(1000);
        String res = futureTask.get();
        System.out.println(res);
    }
}
