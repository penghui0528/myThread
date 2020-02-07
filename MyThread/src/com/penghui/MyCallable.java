package com.penghui;

import java.util.concurrent.Callable;

public class MyCallable {

    public static void main(String[] args) {
        TestCallable callable  = new TestCallable();
        String rtn = callable.call();
        System.out.println("---callable返回值---"+rtn);



    }
}



class TestCallable implements Callable<String>{

    @Override
    public String call() {
        String rtn  = "123";
        System.out.println("---测试callable---");
        return rtn;
    }
}



