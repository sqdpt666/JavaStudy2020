package com.dell.yangzhou.MyselfStudy.aboutThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**多线程的创建方式三:实现Callable接口 ---JDK5.0新增
 * 1.创建一个Callable的实现类
 * 2.实现call方法,将次线程需要声明的操作在call()方法中
 * 3.创建Callable接口实现类的对象
 * 4.将次对象作为参数传递到FutureTask的构造器中
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中
 *
 * 如何理解实现Callable接口创建多线程方式比实现Runnable接口创建多线程方式强大?
 * 1.call()方法可以有返回值,run()没有
 * 2.call()可以抛出异常,run不能
 * 3.Callable支持泛型
 *
 *
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        // 3.创建Callable接口实现类的对象
        NumThread n=new NumThread();
        //4.将次对象作为参数传递到FutureTask的构造器中
        FutureTask f=new FutureTask(n);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中
        Thread t=new Thread(f);
        Thread t2=new Thread(f);
        t.setName("线程甲");
        t2.setName("线程亿");
        t.start();
        t2.start();

        try {
            Object sum=f.get(); //get()方法返回FutureTask的构造器中Callable接口实现类的call()方法返回值
            System.out.println("返回值"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
//1.创建一个Callable的实现类
class NumThread implements Callable {

   //2.实现call方法,将次线程需要声明的操作在call()方法中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i=1;i<101;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
                sum+=i;
                Thread.sleep(100);
            }
        }
    return sum;
    }
}