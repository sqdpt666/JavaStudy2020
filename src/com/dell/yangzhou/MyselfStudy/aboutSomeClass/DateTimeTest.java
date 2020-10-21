package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 */
public class DateTimeTest {
    public static void main(String[] args) {
        DateTimeTest dateTimeTest = new DateTimeTest();
       // dateTimeTest.test();
       // dateTimeTest.test02();
       // dateTimeTest.test03();
      /*  try {
            dateTimeTest.test04();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        dateTimeTest.test05();
    }

//1.System类中的currentTimeMillis()
public void  test(){
    long t1=System.currentTimeMillis();//返回当前时间与1970年1月1日0时0分0秒之间毫秒为单位的时间差
    //称为时间戳
    System.out.println(t1);//1597737411309
}
//2.java.util.Date类
//两个构造器的使用
    /*
    *
    *1. new Date() 创建一个当前时间的Date对象
    *2. new Date(Long time) 传入time毫秒，从1970年开始过time毫秒的日期
    * */
//两个方法的使用
/*
  > toString() 返回当前的年月日时分秒
  > getTime() 获取当前Date对象对应的毫秒数.(时间戳)

  */

    public void test02(){

        Date date = new Date();
        System.out.println(date.toString());//Tue Aug 18 15:56:51 CST 2020
        Date date1=new Date(156136861);
        System.out.println(date1);//Sat Jan 03 03:22:16 CST 1970

    }

    /**
     *3.java.sql.Date类
     * >如何实例化
     * >sql.Date --> util.Date  直接赋值就行了，多态
     * > util.Date --> sql.Date  用getTime()得到毫秒数再通过构造器
     *
     *
     */
    public void test03(){

        java.sql.Date date=new java.sql.Date(1133868434330L);
        System.out.println(date);//2005-12-06

        // util.Date --> sql.Date    用getTime()得到毫秒数再通过构造器
          Date d1=new Date(1231651651);
          java.sql.Date d2= new java.sql.Date(d1.getTime());
          System.out.println("d2--"+d2.toString());//
        //sql.Date --> util.Date  直接赋值就行了，多态
          java.sql.Date d3=d2;
          System.out.println("d3--"+d3);//


    }
/**
 *4.SimpleDateFormat
 *     对Date类的格式化和解析
 *     1.两个操作:
 *        1.1格式化:日期-->字符串
 *        1.2解析: 字符串-->日期
 *     2.SimpleDateFormat的实例化
 */
 public void test04() throws ParseException {
   //SimpleDateFormat的实例化
     SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

     //方法一:
     //格式化:日期-->字符串
     Date date = new Date();
     String format = simpleDateFormat.format(date);
     System.out.println(format);// 20-8-19 下午8:10
    //解析: 字符串-->日期
     String s="20-8-19 下午8:03";
     Date parse = simpleDateFormat.parse(s);
     System.out.println(parse);//Wed Aug 19 20:03:00 CST 2020

     //方法二:
     //格式化:日期-->字符串
     SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
     String format2 = simpleDateFormat2.format(date);
     System.out.println(format2);//2020-08-19 08:07:27
     //解析: 字符串-->日期
     String s2="2020-08-08 11:12:13";
     Date parse2 = simpleDateFormat2.parse(s2);
     System.out.println(parse2);//Sat Aug 08 11:12:13 CST 2020


     //练习题: 将"2020-08-08"转化为可以存入数据库的java.sql.Date
     String birth="2020-08-08";
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     Date d1=sdf.parse(birth);
     java.sql.Date d2=new java.sql.Date(d1.getTime());
     System.out.println(d2);


 }

    /**
     * 日历类 Calendar类(抽象类)
     *
     *
     */
    public void test05(){
        //1.实例化
        //方法一:创建其子类 GregorianCalendar 的对象
        //方法二:调用其静态方法 getInstance()
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getClass());//java.util.GregorianCalendar
        //2.常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);//这个月的多少天
        System.out.println(days);//20(今天是2020年8月20号)
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//这年的多少天 //233
        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);//改变calendar本身的属性
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//22
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//19
        //getTime()  日历类 --> Date类
        Date time = calendar.getTime();
        System.out.println(time);//Wed Aug 19 10:38:51 CST 2020
        //setTime() Date类-->日历类
        Date date = new Date();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(i);//233
    }

}
