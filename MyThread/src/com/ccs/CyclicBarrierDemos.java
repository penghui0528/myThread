package com.ccs;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemos {

    public static class Soldier implements  Runnable {


        private final CyclicBarrier cyclic;
        private String soldier;



        Soldier(CyclicBarrier cyclic,String soldierName){
            this.cyclic = cyclic;
            this.soldier = soldierName;
        }

        @Override
        public void run() {

            try{
                cyclic.await();
                dowork();
                cyclic.await();
            }catch (Exception e){
             e.printStackTrace();
            }
        }

        private void dowork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier+"-------任务完成!!!-----");
        }
    }


    public static class BarrierRun implements Runnable{

        boolean flag;
        int N;
        public BarrierRun(boolean flag ,int N){
            this.flag = flag;
            this.N =  N;
        }

        @Override
        public void run() {

            if(flag){
                System.out.println("司令：士兵任务完成!");
            }else{
                System.out.println("司令：士兵集合完毕!");
                flag =  true;
            }
        }
    }

    public static void main(String[] args) {
        final int N  =10;
        boolean flag = false;
        CyclicBarrier  cyclic  = new CyclicBarrier(N,new BarrierRun(flag,N));
        System.out.println("集合队伍!");


        for (int i = 0; i < N ; i++) {
            System.out.println("士兵"+i+"报道");
            new Thread(new Soldier(cyclic,"士兵"+i)).start();
        }
    }
}
