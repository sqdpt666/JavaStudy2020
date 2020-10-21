package com.dell.yangzhou.MyselfStudy.aboutThread;

//Runnable多线程,使用同步方法的方式解决线程安全问题

public class WindowTest03 {
    public static void main(String[] args) {
        Window3 w=new Window3();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}
class Window3 implements Runnable{
    private static int ticket=100;
    @Override
    public void run() {

        while (true){

            show();

        }


    }


    private synchronized void show(){//非静态方法,锁是this
        if (ticket>0){

            System.out.println(Thread.currentThread().getName()+": 卖票,票号为:"+ticket);
            ticket--;
        }else {
            return;
        }
    }
}