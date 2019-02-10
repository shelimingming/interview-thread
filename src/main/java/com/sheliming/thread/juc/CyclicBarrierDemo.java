package com.sheliming.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int theadNum = i;
            executorService.execute(() -> {
                handle(theadNum);
            });
        }
    }

    private static void handle(int threadNum) {
        try {
            Thread.sleep(1000);
            System.out.println("线程"+threadNum+"准备完成。");
            cyclicBarrier.await();
            System.out.println("线程"+threadNum+"开始执行。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
