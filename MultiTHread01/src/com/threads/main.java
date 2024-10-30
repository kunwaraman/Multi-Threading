package com.threads;

public class main {
    public static void main(String[] args) {
        createthreadviarunnable ct = new createthreadviarunnable();
        Thread t1 = new Thread(ct); // new 1st step
        t1.start();// 2nd step runnable jaise hi cpu ko time milega turant chal jayega
        for (; ; ){
            //System.out.println(Thread.currentThread().getName());
            System.out.println("hello");
        }

    }



}
