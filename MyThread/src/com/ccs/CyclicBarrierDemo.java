package com.ccs;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static  final Integer count  = 7;

    public static void main(String[] args) {



        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> System.out.println("召唤神龙"));
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t收集到第: " + tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }

}
