package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

import java.util.Arrays;

public class CompareTest {
    public static void main(String[] args) {
        CompareTest compareTest=new CompareTest();
        //compareTest.Test01();
        compareTest.Test02();
    }


    //Comparable接口的使用举例(自然排序)
    /*
        1.像String,包装类等实现了Comparable接口,重写了comparableTo(obj)方法,给出了比较两个对象
        2.像String,包装类等重写了comparableTo(obj)方法以后,进行了从小到大的排序
        3.重写了comparableTo(obj)方法的规则:
             如果当前对象this大于形参对象,返回正整数
             如果当前对象this小于形参对象,返回负整数
             如果当前对象this等于形参对象,返回0
        4.对于自定义类中,如果需要排序,我们可以让自定义类实现Comparable接口,重写comparableTo(obj)方法,
          在comparableTo(obj)方法中指明如何排序

     */
    public void Test01(){
        String[] arr=new String[]{"aaa","kkk","bbb","ddd","ccc"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void  Test02(){
        Goods[] arr=new Goods[3];
        arr[0]=new Goods("pt",100);
        arr[1]=new Goods("lqq",200);
        arr[2]=new Goods("ptlqq",300);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * Comparator接口的使用:自定义排序
     *
     */





}
