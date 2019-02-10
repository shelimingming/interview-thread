package com.sheliming.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedStaticTest {
    //修饰代码块，作用于调用的对象
    public void test1(int j) {
        synchronized (SynchronizedStaticTest.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(j+":"+Thread.currentThread().getName() + ":" + i);
            }
        }
    }
    //修饰非静态方法，作用于调用的对象
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println(j+":"+Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedStaticTest synchronizedTest =new SynchronizedStaticTest();
        executorService.execute(()->{
            synchronizedTest.test1(1);
        });
        SynchronizedStaticTest synchronizedTest2 =new SynchronizedStaticTest();
        executorService.execute(()->{
            synchronizedTest2.test1(2);
        });
    }
}
