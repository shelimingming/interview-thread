package com.sheliming.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小的线程池，可以指定线程池的大小，该线程池corePoolSize和maximumPoolSize相等，
 * 阻塞队列使用的是LinkedBlockingQueue，大小为整数最大值。
 * <p>
 * 该线程池中的线程数量始终不变，当有新任务提交时，线程池中有空闲线程则会立即执行，
 * 如果没有，则会暂存到阻塞队列。对于固定大小的线程池，不存在线程数量的变化。
 *
 * 同时使用无界的LinkedBlockingQueue来存放执行的任务。
 * 当任务提交十分频繁的时候，LinkedBlockingQueue迅速增大，存在着耗尽系统资源的问题。
 * 而且在线程池空闲时，即线程池中没有可运行任务时，它也不会释放工作线程，还会占用一定的系统资源，需要shutdown。
 */
public class TestFixedThreadPool {
    private static Runnable getThread(final int i) {
        return new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + ":" + Thread.currentThread().getName());
            }
        };
    }

    public static void main(String args[]) {
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixPool.execute(getThread(i));
        }
        fixPool.shutdown();
    }
}
