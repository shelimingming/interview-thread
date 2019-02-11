package com.sheliming.thread.future;

import java.util.concurrent.*;

public class FutureDemo {
    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("call do something");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println("main do something");
        Thread.sleep(1000);
        String res = future.get();
        System.out.println(res);
    }
}
