package com.sheliming.thread.create;

public class TestRunnable {
    public static void main(String[] args) {
        Thread mt = new Thread(new MyThread());
        mt.start();
    }

    public static class MyThread implements Runnable {

        public void run() {
            System.out.println("线程id："+ Thread.currentThread().getId());
        }
    }
}
