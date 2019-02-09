package com.sheliming.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class, "count");
    public volatile int count = 100;
    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterTest atomicIntegerFieldUpdaterTest = new AtomicIntegerFieldUpdaterTest();
        if(updater.compareAndSet(atomicIntegerFieldUpdaterTest,100,200)) {
            System.out.println("update 1 success");
        }
        if(updater.compareAndSet(atomicIntegerFieldUpdaterTest,100,200)) {
            System.out.println("update 2 success");
        } else {
            System.out.println("update 2 failed");
        }
    }
}
