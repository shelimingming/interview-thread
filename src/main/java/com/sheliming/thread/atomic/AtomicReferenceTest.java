package com.sheliming.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(1,2);
        count.compareAndSet(2,4);
        System.out.println(count);
    }
}
