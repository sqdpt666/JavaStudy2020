package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 * 造3个窗口卖票,票总共100张,
 * 使用继承Thread类的方式
 * 存在线程安全问题
 * 1.使用synchronized(){}  继承Thread类的方式可以用本身类当作锁
 *
 */
public class WindowTest {
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


class Window extends Thread{
    private static int ticket=100;
    @Override
    public void run() {

        while (true) {
            synchronized (Window.class) {
                if (ticket > 0) {

                    System.out.println(Thread.currentThread().getName() + ": 卖票,票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }


            }
        }

    }
}
