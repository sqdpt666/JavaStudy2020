package com.dell.yangzhou.MyselfStudy.aboutThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四:线程池
     * 好处:
 * 1.提高响应速度(减少创建线程的时间)
 * 2.降低资源消耗(重复利用线程池里的线程,不需要每次都创建)
 * 3.便于线程管理:
 *    corePoolSize:核心池的大小
 *    maximumPoolSize 最大线程数
 *    keepAliveTime 线程没任务时,最多存活多久
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        /*设置线程池的属性
        ThreadPoolExecutor s=(ThreadPoolExecutor)service;
        s.setKeepAliveTime();
        s.setCorePoolSize();*/
        //2.执行指定的线程,需要提供一个实现Runnable接口或者Callable接口的实现类的对象
       //适合Runnable
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
      //适合Callable
        //service.submit(Callable xxx);
        //3.关闭线程池
        service.shutdown();
    }
}
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<101;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<101;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}