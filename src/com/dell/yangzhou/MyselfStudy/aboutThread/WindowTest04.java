package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 * 继承Thread类的多线程,使用同步方法的方式解决线程安全问题
 */

public class WindowTest04 {
    public static void main(String[] args) {
        Window t1=new Window();
        Window t2=new Window();
        Window t3=new Window();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}


class Window4 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {

        while (true) {
            show();
        }

    }

    private static synchronized void show(){//静态方法锁是本身类

            if (ticket > 0) {

                System.out.println(Thread.currentThread().getName() + ": 卖票,票号为:" + ticket);
                ticket--;
            } else {
                return;
            }



    }
}