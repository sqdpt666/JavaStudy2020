package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 *
 * JDK 8的时间类
 */
public class DateTimeTest02 {
    public static void main(String[] args) {
        DateTimeTest02 d=new DateTimeTest02();
     //   d.Test01();
        //d.Test02();
        d.Test03();
    }

    /*
    *
    * LocalDate,LocalTime,LocalDateTime的使用
    * 说明:
    *     1.LocalDateTime的使用频率更高
    * */
   public void Test01(){
       //now()
       LocalDate now = LocalDate.now();//年月日
       LocalTime now1 = LocalTime.now();//时分秒
       LocalDateTime now2 = LocalDateTime.now();//年月日时分秒
       System.out.println(now);//2020-08-20
       System.out.println(now1);//11:00:32.710
       System.out.println(now2);//2020-08-20T11:00:32.710

       //of()  设定指定的年月日时分秒
       LocalDateTime of = LocalDateTime.of(2020, 10, 6, 12, 12, 12);
       System.out.println(of);//2020-10-06T12:12:12

       //getXxx()
       int dayOfMonth = now2.getDayOfMonth();//获得当月的第几天
       System.out.println(dayOfMonth);//20

       //不可变性   (不会改变本身)
       //withXxx() 设置相关属性
       LocalDate localDate=now.withDayOfMonth(22);
       System.out.println(now);//2020-08-20
       System.out.println(localDate);//2020-08-22
       //plusXXX() 加
       LocalDateTime localDateTime = now2.plusMonths(3);
       System.out.println(now2);//2020-08-20T11:13:52.211
       System.out.println(localDateTime);//2020-11-20T11:13:52.211
           //minusXxx() 减
       LocalDateTime localDateTime1 = now2.minusMonths(5);
       System.out.println(localDateTime1);//2020-03-20T11:15:28.835
   }


    /**
     * Instant的使用
     */

    public void Test02(){
        //对应本初子午线的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);//2020-08-20T03:22:46.897Z
        //添加时间偏移量,计算当地时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-08-20T11:22:46.897+08:00
        //toEpochMilli():获得从1970年1月1日0时0分0秒(UTC)开始的毫秒数 相当于-->Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);//1597893942012
        //ofEpochMilli(): 通过给的毫秒数,获得Instant实力 相当于-->Date(Long millis)
        Instant instant1 = Instant.ofEpochMilli(1597893942012L);
        System.out.println(instant1);//2020-08-20T03:25:42.012Z
    }


    /**
     *DateTimeFormatter:格式化解析日期,时间
     *
     */
     public void  Test03(){
         //1.预定义的标准格式
         DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
         //格式化:日期-->字符串
         LocalDateTime now = LocalDateTime.now();
         String format = isoLocalDateTime.format(now);
         System.out.println(now);//2020-08-20T11:35:54.109
         System.out.println(format);//2020-08-20T11:35:54.109
         //解析: 字符串-->日期
         TemporalAccessor parse = isoLocalDateTime.parse("2020-08-20T11:35:54.109");
         System.out.println(parse);//{},ISO resolved to 2020-08-20T11:35:54.109
         //2.本地化相关的格式
         //如:ofLocalizedDateTime()
        // FormatStyle.LONG/FormatStyle.SHORT,FormatStyle.MEDIUM :适用于LocalDateTime
         DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
         DateTimeFormatter formatter1=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
         DateTimeFormatter formatter2=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
         String format1 = formatter.format(now);
         String format2 = formatter1.format(now);
         String format3 = formatter2.format(now);
         System.out.println(format1);//2020年8月20日 上午11时46分38秒
         System.out.println(format2);//20-8-20 上午11:47
         System.out.println(format3);//2020-8-20 11:48:23
         //如:ofLocalizedDate()
         //FormatStyle.LONG/FormatStyle.SHORT,FormatStyle.MEDIUM ,FormatStyle.FULL适用于ofLocalizedDate
         DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
         String format4 = formatter3.format(now);
         System.out.println(format4);//2020年8月20日 星期四

         //重点: 3.自定义的格式
         // 如: ofPattern("yyyy-MM-dd hh:mm:ss")
         DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
         //格式化
         String format5 = formatter4.format(LocalDateTime.now());
         System.out.println(format5);//2020-08-20 02:24:33
         //解析
         TemporalAccessor parse1 = formatter4.parse("2020-08-20 02:24:33");
         System.out.println(parse1);//{HourOfAmPm=2, MilliOfSecond=0, MicroOfSecond=0, MinuteOfHour=24, SecondOfMinute=33, NanoOfSecond=0},ISO resolved to 2020-08-20

     }

}
