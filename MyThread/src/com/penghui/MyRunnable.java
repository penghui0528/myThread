package com.penghui;

public class MyRunnable {

    public static void main(String[] args) {

        TestRunnable runnable = new TestRunnable();
        Thread t  = new Thread(runnable);
        t.start();
    }

}


     class TestRunnable implements Runnable{


         @Override
         public void run() {
             System.out.println("-----"+"测试runnable");
         }
     }

