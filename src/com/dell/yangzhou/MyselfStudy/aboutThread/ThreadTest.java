package com.dell.yangzhou.MyselfStudy.aboutThread;


/***
 * 多线程的创建方式,方式一:继承Thread类
 * 1.创建一个继承Thread类的子类
 * 2.重写run()方法
 * 3.创建Thread类的子类的对象
 * 4.调用该类start()方法
 */

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread=new MyThread();
        //4.调用该类start()方法 一.启动线程 二.调用run()方法
        myThread.start();
        //问题1:我们不能直接调用run()的方式调用启动线程
        //myThread.run()
        //问题2:再启动一次的话不会再产生一个线程,会报错
        // myThread.start();
        //问题3:如果要再启动一个的话,需要再创建一个对象
        MyThread myThread2=new MyThread();
        myThread2.start();
        //创建Thread类匿名子对象
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2 ==0){
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                }
            }
        }.start();
    }
}
// 1.创建一个继承Thread类的子类
class MyThread extends Thread{
    // 2.重写run()方法
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2 ==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}