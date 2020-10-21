package com.dell.yangzhou.MyselfStudy.aboutSomeClass;

/**
 * String类的使用
 *String:字符串,使用 ""引起来.String的两种定义方式:1.字面量定义 2.new + 构造器
 * 1.String类声明为final的 ,不可被继承
 * 2.String类实现了Serializable接口:表示可以序列化
 * 3.String类实现了Comparable接口:表示可以比较大小
 * 4.String内部定义了final char[] value用于存储字符串数据
 * 5.String代表一个不可变的字符序列.简称:不可变性
 *     体现:1.当对字符串重新赋值时,需要重新指定内存区域赋值,不能使用原因的value进行赋值
 *          2.对现有字符串进行连接操作也需要在内存区域重新赋值
 *          3.调用String的replace()方法修改指定字符或者字符串时,也需要重新在内存区域赋值
 * 6.通过字面量方式(区别于new方式)给一个字符串赋值,此时的字符串值声明在字符串常量池中
 * 7.字符串常量池中不会存储相同内容的字符串
 *
 * 面试题: String s=new String("abc");方式创建的对象,在内存中创建了几个对象
 *        答:两个,一个是堆空间中new结构,另一个是char[]对应的常量池中的数据
 *        String s="abc";方式呢?
 *        答:一个.是char[]对应的常量池中的数据
 *
 *
 * length(),返回字符长度
 * charAt(int index) 返回下标为index的字符
 * isEmpty()判断是否为空
 * toUpperCase() 返回一个新字符串,将字符串转化成大写,不改变本来的
 * toLowerCase() 返回一个新字符串,将字符串转化成小写,不改变本来的
 * trim()  去掉首尾空字符
 * equals(String s) 比较字符内容是否相同
 * equalsIgnoreCase(String s) 比较字符内容是否相同,忽略大小写
 * compareTo(String s) 比较大小 比较的是字符的ASCII码
 * substring(int start,int end) 将原数组从下标start开始取到(end-1)返回,end不填就取到最后,不改变原数组
 * endsWith(String s) 判断字符串是否以字符串s结束
 * startsWith(String s) 判断字符串是否以字符串s开始
 * startsWith(String s,int index) 判断字符串从index索引开始是否以字符串s开始
 * contains(CharSequence e) 判断当前字符串是否包含e
 * indexOf(String s,int index) 从从index开始(默认为第一个)前往后找,返回字符串中字符串s第一次出现的第一个索引,没有就返回-1
 * lastIndexOf(String s,int index) 从index(默认为最后一个)开始聪从后往前找,返回字符串中字符串s第一次出现的第一个一个索引,没有就返回-1
 * String replace(char oldChar,char new char)
 * String replace(CharSequence target,CharSequence replacement)使用指定的字面值替换此字符串所以匹配字面值目标序列的字符串
 * String replaceAll(String regex,String replacement) 使用replacement替换此字符串所有匹配给定的正则表达式的子字符串
 * String replaceFirst(String regex,String replacement) 使用replacement替换此字符串第一个匹配给定的正则表达式的子字符串
 * boolean matches(String regex)判断是否满足正则表达式
 * String[] split(String regex) 根据正则表达式拆分字符串
 * String[] split(String regex,int limit) 根据正则表达式拆分字符串,最多不超过limit个,如果超过了,剩下的全放到最后一个元素中
 *
 *
 */
public class StringTest {

    public static void main(String[] args) {
        StringTest t=new StringTest();
        t.test1();
    }

    public void test1(){
        //字面量的定义方式
        String s1="abc";
        String s2="abc";
        //通过new+构造器的方式:此时s3和s4保存的地址值,是数据在堆空间中开辟空间以后对应的地址值
        String s3=new String("abc");
        String s4=new String("abc");

        System.out.println(s1 == s2);//比较s1与s2的地址值,返回为true
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false


        String a1="abc";
        String a2="def";
        String a3="abcdef";
        String a4="abc"+"def";
        String a5=a1+"def";
        String a6="abc"+a2;
        String a7=a1+a2;
        //结论:常量与常量的拼接结果在常量池,只要其中有一个变量,结果就在堆中
        System.out.println(a3 == a4);//true
        System.out.println(a3 == a5);//false
        System.out.println(a3 == a6);//false
        System.out.println(a3 == a7);//false
        System.out.println(a5 == a6);//false
        System.out.println(a6 == a7);//false

        String a8=a5.intern();//返回值得到的a8使用常量池中存在的"abcdef"
        System.out.println(a8==a3);//true

        /*
        * String中常用方法
        * */

        //length(),返回字符长度
        String b="helloworld";
        System.out.println(b.length());

        //charAt(int index) 返回下标为index的字符
        System.out.println(b.charAt(0));

        //isEmpty()判断是否为空
        System.out.println(b.isEmpty());

        //toUpperCase() 返回一个新字符串,将字符串转化成大写,不改变本来的
        String b2=b.toUpperCase();
        System.out.println(b2);//HELLOWORLD
        System.out.println(b);//helloworld

        //toLowerCase() 返回一个新字符串,将字符串转化成小写,不改变本来的
        String b3=b.toLowerCase();
        System.out.println(b3);//helloworld
        System.out.println(b);//helloworld

        //trim()  去掉首尾空字符
        String b4="    he ll o world  ";
        String b5=b4.trim();
        System.out.println(b4);//"    he ll o world  "
        System.out.println(b5);//"he ll o world"

        //equals(String s) 比较字符内容是否相同
        String c1="abc";
        String c2="abc";
        System.out.println(c1.equals(c2));//true

        //equalsIgnoreCase(String s) 比较字符内容是否相同,忽略大小写
        String c3="aBc";
        c3.equalsIgnoreCase(c1);//true

        //concat(String s) 将制定字符串连接到此字符串的结尾.等价于+
        c1.concat("123");//abc123

        //compareTo(String s) 比较大小 比较的是字符的ASCII码
        String d1="abc";
        String d2="abd";
        System.out.println(d1.compareTo(d2));//-1 (c-d)=-1

        //substring(int start,int end) 将原数组从下标start开始取到(end-1)返回,end不填就取到最后,不改变原数组
        String d3="我的大帅哥";
        System.out.println(d3.substring(2));//大帅哥
        System.out.println(d3.substring(2,4));//大帅

        //endsWith(String s) 判断字符串是否以字符串s结束
        //startsWith(String s) 判断字符串是否以字符串s开始
        //startsWith(String s,int index) 判断字符串从index索引开始是否以字符串s开始
        String d4="abcdefg";
        boolean is=d4.startsWith("abc");//true
        boolean is2=d4.endsWith("fg");////true
        boolean is3=d4.startsWith("cd",2);////true
        System.out.println(is+","+is2+","+is3);

        //contains(CharSequence e) 判断当前字符串是否包含e
        String d5="abcdefg";
        System.out.println(d5.contains("def"));//true
        System.out.println(d5.contains("df"));//false

        //indexOf(String s,int index) 从从index开始(默认为第一个)前往后找,返回字符串中字符串s第一次出现的第一个索引,没有就返回-1
        String d6="abcdefg";
        System.out.println(d6.indexOf("bc"));//1
        System.out.println(d6.indexOf("bc",1));//1
        System.out.println(d6.indexOf("ac"));//-1
        //  lastIndexOf(String s,int index) 从index(默认为最后一个)开始聪从后往前找,返回字符串中字符串s第一次出现的第一个一个索引,没有就返回-1
        System.out.println(d6.lastIndexOf("bc"));//1
        System.out.println(d6.lastIndexOf("bc",1));//1
        System.out.println(d6.lastIndexOf("ac"));//-1

        //替换
        //String replace(char oldChar,char new char)
        String f1="北京尚硅谷北京";
        String f2=f1.replace('北','东');
        System.out.println(f1);//北京尚硅谷北京
        System.out.println(f2);//东京尚硅谷东京
        //String replace(CharSequence target,CharSequence replacement)使用指定的字面值替换此字符串所以匹配字面值目标序列的字符串
        String f3=f1.replace("北京","上海");
        System.out.println(f3);//上海尚硅谷上海
        //String replaceAll(String regex,String replacement) 使用replacement替换此字符串所有匹配给定的正则表达式的子字符串
        //String replaceFirst(String regex,String replacement) 使用replacement替换此字符串第一个匹配给定的正则表达式的子字符串
        //匹配
        //boolean matches(String regex)判断是否满足正则表达式
        //切片
        //String[] split(String regex) 根据正则表达式拆分字符串
        //String[] split(String regex,int limit) 根据正则表达式拆分字符串,最多不超过limit个,如果超过了,剩下的全放到最后一个元素中

        //String与基本数据类型,包装类的转换
        //String--->基本数据类型,包装类:调用包装静态类 parseXXX(str)
        //基本数据类型,包装类--->String :调用String重载的valueof(XXX)
        //String--->char[]  调用toCharArray()
        //char[]--->String  调用String的构造器



    }

}


