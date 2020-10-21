package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

public @interface AnnotationTest {
    /**
     * 注解
     * 示例一:生成文档相关的注解
     * 示例二:编译时进行格式检测(JDK内置的3个基本注解)
     *    1.@Override:限定重写父类的方法,该注解只能用于方法
     *    2.@Deprecated:用于表示所修饰的元素(类,方法等)已经过时.
     *    3.@SuppressWarnings:抑制编译器警告
     *
     *
     *    如何自定义注解?
     *      1.注解声明
     *      2.内部定义成员,通常使用value表示
     *      3.可以指定成员变量的默认值,使用default定义
     *      4.如果自定义的注解没有成员,表示是一个标识作用
     *  JDK提供的4种元注解
     *  1.Retention 指定所修饰的Annotation的生命周期:SOURCE\ClASS(默认行为)\RUNTIME
     *       只有声明为RUNTIME声明周期的注解,才能通过反射获取
     *  2.Target 用于指定被修饰的Annotation 能用于修饰哪些程序元素
     *  3.Documented  表示所修饰的注解将被javadoc解析时,保存下来
     *  4.Inherited
     *
     *
     */


}
