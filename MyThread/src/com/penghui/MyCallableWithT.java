package com.penghui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCallableWithT {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService  es  = Executors.newFixedThreadPool(10);
        List<Task2> list  = new ArrayList<>();
        for(int i=0; i<8; i++){
            list.add(new Task2());
        }
        es.invokeAll(list);
        es.shutdown();
    }
}

class Task2 implements Callable<String>{

    @Override
    public String call() {
        for (int i=0;i< 2;i++){
          System.out.println("------i="+i);
        }
        return "penghui";
    }
}
