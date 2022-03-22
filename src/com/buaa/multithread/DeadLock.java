package com.buaa.multithread;

import static java.lang.Thread.sleep;

public class DeadLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(()->{
            synchronized (A){
                System.out.println("t1-lock A");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("t1-lock B");
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (B){
                System.out.println("t2-lock B");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("t2-lock A");
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
