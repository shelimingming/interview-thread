package com.sheliming.thread.publish;

import com.sheliming.thread.annoations.NotRecommend;
import com.sheliming.thread.annoations.NotThreadSafe;

/**
 * 对象逸出：一种错误的发布，当对象还没有构造完成时，就是它被其他线程所见。
 */
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
