package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

/**
 * 关于StringBuffer和StringBuilder
 * String,StringBuffer,StringBuilder的区别:
 * String:不可变的字符序列,低层使用char[]存储
 * StringBuffer:可变的字符序列 ,线程安全,效率低,,低层使用char[]存储
 * StringBuilder:可变的字符序列 ,线程不安全,效率高 ,JDK5.0新增,,低层使用char[]存储
 *
 * 源码分析
 * String str=new String();//char[] value= new char[0];
 * String str2=new String('a','b');//char[] value= new char[]{'a','b'};
 *
 * StringBuffer s=new StringBuffer();//char[] value= new char[16] 低层创建了一个长度16的char数组
 * s.append('a');//value[0]='a';
 * //问题1:System.out.println(s.length());长度是多少?
 *   答:0 ,不是16,因为重写了length(),返回的是count
 * StringBuffer s2=new StringBuffer("abc");//char[] value= new char["abc".length()+16] 低层创建了一个长度"abc".length()+16的char数组
 * //问题2:System.out.println(s2.length());长度是多少?
 *      答:3
 * //问题3:扩容问题:如果要添加的数据底层数组放不下了,那就需要扩容底层数组
 *        默认情况下,扩容为原来的容量的两倍+2,同时将原数组复制到新数组
 *
 *    指导意义:开发中建议大家使用:StringBuffer(int capacity)或StringBuilder(int capacity) 指定容量
 *
 */
public class StringBufferBuilderTest {
}
