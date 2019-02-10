package com.sheliming.thread.publish;

import com.sheliming.thread.annoations.NotThreadSafe;

import java.util.Arrays;

/**
 * 发布对象：使一个对象能够被当前范围之外的代码所使用
 */
@NotThreadSafe
public class UnsafePublish {
    private String[] status = {"a", "b", "c"};

    public String[] getStatus() {
        return status;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStatus()));

        unsafePublish.getStatus()[0] = "s";
        System.out.println(Arrays.toString(unsafePublish.getStatus()));
    }
}
