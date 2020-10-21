package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 * 使用两个线程交替打印1-100
 * 涉及3个方法:
 * wait() 一旦执行此方法,当前线程进入阻塞状态,并且释放同步监视器
 * notify() 一旦执行此方法,将唤醒一个阻塞状态的线程,如果有多个阻塞线程,则唤醒优先级高的
 * notifyAll() 唤醒所以阻塞状态的线程
 *
 * 说明:
 * 1.wait() ,notify(),notifyAll()使用的时候,必须使用在同步代码块或者同步方法中
 * 2.wait() ,notify(),notifyAll()使用的时候,调用者必须是同步代码块或同步方法中的监视器,否则会出现异常
 * 3.wait() ,notify(),notifyAll()是定义在java.lang.Object类中的
 *
 * 面试题:
 * sleep()和wait()的异同?
 * 相同点:一旦执行,都可以使得当前线程进入阻塞状态
 * 不不同点: 1.两个方法声明的位置不同,Thread类中声明sleep(),Object类中声明的wait()
 *          2.调用的要求不一样: sleep()可以在任何需要的场景调用,wait()必须使用在同步方法或者同步代码块中
 *          3.关于是否释放同步监视器:sleep()不会释放,wait()会释放
 */
public class CommunicationTest {
    public static void main(String[] args) {
           Number number=new Number();
           Thread t1=new Thread(number);
           Thread t2=new Thread(number);

           t1.setName("线程一");
           t2.setName("线程二");

           t1.start();
           t2.start();


    }
}

class Number implements Runnable{
   private int number=1;

    @Override
    public void run() {




            while (true)
            {   synchronized (this) {
                notify();//结束一个线程阻塞状态

                if(number<101){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                }else {
                    break;
                }
                try {
                    wait();//线程进入阻塞,并且释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}