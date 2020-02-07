package com.penghui;

public class MyThread {


    public static void main(String[] args) {
        for(int i=1;i<11;i++){
            TestThread t = new TestThread("penghui"+i);
            t.start();
        }
    }

}
    class TestThread extends Thread{

        private String name;

        public TestThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
        }
    }

