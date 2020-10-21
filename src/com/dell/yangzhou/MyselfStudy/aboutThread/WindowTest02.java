package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 *
 *  造3个窗口卖票,票总共100张,
 *  使用继承Runnable接口的方式
 *
 *
 *
 */
public class WindowTest02 {
    public static void main(String[] args) {
        Window2 w=new Window2();
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
class Window2 implements Runnable{
    private static int ticket=100;
    @Override
    public void run() {

        while (true){
            if (ticket>0){

                System.out.println(Thread.currentThread().getName()+": 卖票,票号为:"+ticket);
                ticket--;
            }else {
                break;
            }


        }


    }
}