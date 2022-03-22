package com.buaa.multithread;

/**
 * 两个线程轮流打印数字，一直到100
 *
 * Java的wait()、notify()学习：
 * wait()的作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁
 * notify()和notifyAll()的作用，则是唤醒当前对象上的等待线程；notify()是唤醒单个线程，而notifyAll()是唤醒所有的线程。
 */

public class TakeTurnsPrint {

    public static class TakeTurns{
        private static boolean flag = true;
        private static int count = 0;
        public synchronized void print1() {//通过加锁保证可见性
            for (int i = 0;i<=50;i++){
                while (flag){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }

                System.out.println("print1:"+ ++count);
                flag = !flag;
                notifyAll();
            }
        }
        public synchronized void print2(){
            for (int i = 0;i<=50;i++){
                while(!flag){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                System.out.println("print2"+":"+ ++count);
                flag = !flag;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        TakeTurns takeTurns = new TakeTurns();

        new Thread(()->{
            takeTurns.print1();
        }).start();

        new Thread(()->{
            takeTurns.print2();
        }).start();

    }


}
