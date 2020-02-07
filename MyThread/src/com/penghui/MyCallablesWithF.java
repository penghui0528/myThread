package com.penghui;


import java.util.concurrent.*;

public class MyCallablesWithF {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        MyTask task = new MyTask();

        //Future<String> result = executor.submit(task);
        //executor.shutdown();

        FutureTask<String> futureTask = new FutureTask<String>(task);
        executor.submit(futureTask);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            //System.out.println("task运行结果"+result.get());
              System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

}


class MyTask  implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++){
            sum += i;
        }
        return sum+"";
    }
}
