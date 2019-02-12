package com.sheliming.thread.produceAndConsume;

public class Test1 {
    public static void main(String[] args)
    {
        Storage1 storage=new Storage1();

        for(int i=1;i<6;i++)
        {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.produce(String.format("生成者%d:", finalI));
                }
            }).start();
        }

        for(int i=1;i<4;i++)
        {
            int finalI = i;
            new Thread(()-> storage.consume(String.format("消费者%d:", finalI))).start();
        }
    }
}
