package com.dell.yangzhou.MyselfStudy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {


    public static void main(String[] args) {
        try {
            new ReflectTest().test01();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //反射对类的作用
    public void  test01() throws Exception {
        Class clazz=Person.class;
        //通过反射,创建person对象
        Constructor constructor = clazz.getConstructor( String.class,int.class);
        Object tom = constructor.newInstance("tom",10);
        Person p=(Person) tom;
        System.out.println("1----------"+p.toString());
       //通过反射,调用指定属性,方法
        //属性
        Field name = clazz.getDeclaredField("name");
        name.set(p,"tom02");
        System.out.println("2----------"+p.toString());
        //方法
        Method showName = clazz.getDeclaredMethod("showName");
        showName.invoke(p);

        //****************************
        //通过反射调用私用的属性和方法
         //私有构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1= (Person) declaredConstructor.newInstance("jerry");
        System.out.println("3----------"+p1);
        //私有属性
        Field age1 = clazz.getDeclaredField("age");
        age1.setAccessible(true);
        age1.set(p1,15);
        System.out.println("4----------"+p1);
        //私有方法
        Method showAge = clazz.getDeclaredMethod("showAge");
        showAge.setAccessible(true);
        showAge.invoke(p1);
        System.out.println("5----------"+p1);

    }

}
class Person{
    private int age;
    public String name ;
    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }
    private Person(String name){
        age=100;
        this.name=name;
    }
    private void showAge(){
        System.out.println(age);
    }
    public void showName(){
        System.out.println(name);

    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
