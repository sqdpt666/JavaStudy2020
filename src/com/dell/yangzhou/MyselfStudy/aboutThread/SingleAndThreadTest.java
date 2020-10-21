package com.dell.yangzhou.MyselfStudy.aboutThread;

/**
 * 懒汉式单例模式改成线程安全的
 */
public class SingleAndThreadTest {



}

class Bank{
    private Bank(){ }
    private static Bank instance=null;
    public static Bank getInstance(){
        //方式一 效率稍差
   /*     synchronized(Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
      //方式二: 效率更高
        if(instance==null){
            synchronized(Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }


}
