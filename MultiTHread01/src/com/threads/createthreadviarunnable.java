package com.threads;

public class createthreadviarunnable implements Runnable {

    @Override
    public void run() {
        for (; ; ){
            System.out.println("hello world");
        }

    }
}
