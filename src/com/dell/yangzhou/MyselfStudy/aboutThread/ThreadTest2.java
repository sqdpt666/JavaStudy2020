package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 *
 * 创建多线程的方法二:实现 Runnable接口
 * 1.创建一个实现了Runnable接口
 * 2.实现类去实现Runnable中的抽象方法:run()
 * 3.创建实现类的对象
 * 4.将对象作为参数传递到Thread类的构造器中,创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * 比较两种创建线程的方式
 * 开发中: 优先选择实现Runnable接口的方式
 * 原因:1.实现接口的方式没有类的单继承的局限性
 *      2.实现接口的方式更适合处理多个线程共享数据的情况
 *
 * 联系: Thread类本身也是实现了Runnable接口
 * 相同点:两种方式都需要重新run()方法
 *
 *
 * 解决线程安全问题:
 * 方式一:同步代码块
 * synchronized(同步监视器){  //Runnable方式可以用this当锁
 *     //需要同步的代码
 * }
 * 说明:1.操作共享数据的代码,即为需要被同步的代码
 *      2.共享数据:多个线程共同操作的变量.比如:ticket就是共享数据
 *      3.同步监视器,俗称:锁 . 任何对象都可以称当锁
 *         要求:多个线程必须共用一把锁
 *
 * 方式二:同步方法
 *如果需要同步的代码都在一个方法里,可以将这个方法同步
 * 1.同步方法仍有锁,只是不需要显示声明
 * 2.非静态方法锁是this
 * 3.静态方法锁是当前类本身
 *
 *
 *5.同步方式,解决的线程安全问题 ---好处
 *但是在执行锁住的代码时,只有一个线程操作,其他线程需要等待,相当于单线程,牺牲了速度.---局限性
 *
 */



public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        Thread02 thread=new Thread02();
        //4.将对象作为参数传递到Thread类的构造器中,创建Thread类的对象
        Thread t1 = new Thread(thread);
        //5.通过Thread类的对象调用start()
        t1.start();

        Thread t2 = new Thread(thread);
        t2.start();
    }

}
// 1.创建一个实现了Runnable接口
class Thread02 implements Runnable{

//2.实现类去实现Runnable中的抽象方法:run()
    @Override
    public void run() {
     synchronized(this){
    for(int i=0;i<100;i++){
    if(i%2==0){
        System.out.println(Thread.currentThread().getName()+":"+i);
    }
}
    }
    }
}