package com.sheliming.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    //修饰代码块，作用于调用的对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(j+":"+Thread.currentThread().getName() + ":" + i);
            }
        }
    }
    //修饰非静态方法，作用于调用的对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println(j+":"+Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedTest synchronizedTest =new SynchronizedTest();
        executorService.execute(()->{
            synchronizedTest.test1(1);
        });
        executorService.execute(()->{
            synchronizedTest.test1(2);
        });
    }
}
