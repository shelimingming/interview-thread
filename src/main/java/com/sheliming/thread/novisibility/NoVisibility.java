package com.sheliming.thread.novisibility;

/**
 * todo
 * 根据线程的可见性应该是可能读不到的，不知道为什么可以读的到，很奇怪？？？
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
