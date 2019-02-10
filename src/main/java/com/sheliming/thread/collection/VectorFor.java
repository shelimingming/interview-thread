package com.sheliming.thread.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorFor {
    private static void test1(Vector<Integer> vector) {
        for (Integer i:vector ) {
            if(i.equals(3)) {
                vector.remove(i);
            }
        }
    }
    private static void test2(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if(i.equals(3)) {
                vector.remove(i);
            }
        }
    }
    private static void test3(Vector<Integer> vector) {
        for(int i=0;i<vector.size();i++) {
            if(vector.elementAt(i).equals(3)) {
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> list = new Vector<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        test1(list);
    }

}
