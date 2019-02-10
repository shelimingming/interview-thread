package com.sheliming.thread.collection;

import com.sheliming.thread.annoations.NotThreadSafe;

import java.util.List;
import java.util.Vector;

@NotThreadSafe
public class VectorNotSafe {
    private static List<Integer> list = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.remove(i);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i);
                    }
                }
            }).start();
        }
    }
}
