package com.buaa.sort;

public class DeadLock {
        // 创建两个锁对象
        private Object o1 = new Object();
        private Object o2 = new Object();

        public void m1() throws InterruptedException {
            synchronized (o1) {
                // 获取到o1锁
                System.out.println(Thread.currentThread().getName() + " locked o1.");
                System.out.println(Thread.currentThread().getName() + " begin to lock o2...");
                // 当前线程休眠500毫秒，保证另外一个线程已经获取到o2
                Thread.sleep(500);
                synchronized (o2) {
                    // 此时再尝试去获取到o2，因为o2已经被另外的线程拿到，而获取到o2的线程在等待获取到o1，所以会出现死锁。
                    System.out.println(Thread.currentThread().getName() + " locked o2.");
                }
            }
        }

        public void m2() throws InterruptedException {
            // 逻辑同m1()。
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " locked o2.");
                System.out.println(Thread.currentThread().getName() + " begin to lock o1...");
                Thread.sleep(500);
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " locked o1.");

                }
            }
        }

        // 测试代码
        public static void main(String[] args) {
            DeadLock deadLock = new DeadLock();
            // 创建两个线程，分别执行m1(),m2()
            new Thread(() -> {
                try {
                    deadLock.m1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    deadLock.m2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


}
