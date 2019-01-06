package com.sheliming.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池，缓存的线程默认存活60秒。
 * 线程的核心池corePoolSize大小为0，核心池最大为Integer.MAX_VALUE,阻塞队列使用的是SynchronousQueue。
 * 是一个直接提交的阻塞队列，    他总会迫使线程池增加新的线程去执行新的任务。
 *
 * 在没有任务执行时，当线程的空闲时间超过keepAliveTime（60秒），则工作线程将会终止被回收，
 * 当提交新任务时，如果没有空闲线程，则创建新线程执行任务，会导致一定的系统开销。
 * 如果同时又大量任务被提交，而且任务执行的时间不是特别快，
 * 那么线程池便会新增出等量的线程池处理任务，这很可能会很快耗尽系统的资源。
 *
 * 不需要调用shutDown方法，这里可以发现过60秒之后，会自动释放资源。
 */
public class TestNewCachedThreadPool {
    private static Runnable getThread(final int i) {
        return new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println(i + ":" + Thread.currentThread().getName());
            }
        };
    }

    public static void main(String args[]) {
        ExecutorService cachePool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            cachePool.execute(getThread(i));
        }
    }
}
