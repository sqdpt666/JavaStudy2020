package com.dell.yangzhou.MyselfStudy.aboutThread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三: Lock锁 ---JDK5.0新增
 *
 * 面试题:synchronized 和 lock 的异同
 * 同:   二者都可解决线程安全问题
 * 不同:  synchronized机制在执行完相应的同步代码以后,自动释放同步监视器
 *        lock需要手动的启动同步(调用lock()),也需要手动结束同步(调用unlock())
 */
public class LockText {
    public static void main(String[] args) {
        Window5 w=new Window5();
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
class Window5 implements Runnable{
    private static int ticket=100;
    //1.实例化Reentrantlock
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //2.调用锁定方法lock()
                lock.lock();
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+": 卖票,票号为:"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}