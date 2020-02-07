package com.ccs;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements  Runnable{

    static Integer count  = 10;

    static final  CountDownLatch cdl = new CountDownLatch(count);
    static final  CountDownLatchDemo cdld =  new  CountDownLatchDemo();

    @Override
    public void run() {

        //模拟检查
        System.out.println(Thread.currentThread().getName() + "检查完成！！");
        cdl.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            es.submit(cdld);

        }
        cdl.await();
        System.out.println("fire");
        es.shutdown();
    }


//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch cdl = new CountDownLatch(6);
//        for (int i = 1; i <= 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "\t国,被灭");
//                cdl.countDown();
//            }, Objects.requireNonNull(CountryEnum.forEachCountryEnum(i)).getRetMessage()).start();
//        }
//        cdl.await();
//        System.out.println(Thread.currentThread().getName() + "\t秦灭六国,一统华夏");
// }


}
