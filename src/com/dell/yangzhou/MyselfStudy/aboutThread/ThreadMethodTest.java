package com.dell.yangzhou.MyselfStudy.aboutThread;

/***
 * 测试Thread常用方法
 * 1.start() 启动当前线程,调用run()
 * 2.run() 通常需要重写Thread中的此方法,将需要执行的操作放到此方法中
 * 3.currentThread() 静态方法,获取当前线程
 * 4.getName() 获得当前线程的名字
 * 5.setName() 设置当前线程的名字
 * 6.yield() 释放当前cpu的执行权
 * 7.join() 在线程A中调用线程B的join()方法的话,此时线程A进入阻塞状态,直到线程B执行完毕,线程A才结束阻塞状态
 * 8.stop() 已经过时,当执行此方法时,强制结束当前线程
 * 9.sleep(long millitime) 让当前线程进入阻塞状态millitime毫秒,然后继续运行
 * 10.isAlive() 判断当前线程是否还存活
 *
 *
 * 线程的优先级:
 * MAX_PRIORITY  :10
 * MIN_PRIORITY  :1
 * NORM_PRIORITY :5  默认优先级
 * 如何获取和设置当前线程的优先级:
 * getPriorty() :获取当前线程的优先级
 * setPriorty(int p) :设置当前线程的优先级
 * 高优先级比低优先级获得cup执行权的概率更高,并不意味着先执行高优线完后再执行低优先级
 *
 *
 */
public class ThreadMethodTest {

    public static void main(String[] args) {

        HelloThread helloThread=new HelloThread();
        helloThread.setName("多线程李一");
        helloThread.start();

    }


}
class HelloThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2 ==0){
                System.out.println(Thread.currentThread().getName()+i+"优先级"+getPriority());
            }
            if(i%20 ==0){
                yield();
            }
        }
    }
}