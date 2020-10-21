package com.dell.yangzhou.MyselfStudy.aboutSomeClass;


import java.util.Scanner;

public class MyStringTest {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyStringTest myStringTest = new MyStringTest();

        myStringTest.test01();
        myStringTest.test02();
        myStringTest.test03();
        myStringTest.test04();
        myStringTest.test05();
        myStringTest.test06();
        myStringTest.test07();
        myStringTest.test08();

        myStringTest.closeSc();
    }

    //1.给定一个字符串,判断该字符串中是否包含某个子串.如果包含,求出子串的所有出现位置.
    public void test01() {
        System.out.println("---------------------1----------------------");
        String s = "asdjoahsdlasldk";
        String temp = "as";
        int a = -1;
        String index = "";
        do {
            if (a >= s.length()) {
                break;
            }
            a = s.indexOf(temp, a + 1);
            if (a != -1)
                index = index + " " + a;

        } while (a != -1);
        System.out.println(index.trim());


    }

    //2.编写程序，将控制台输入的字符串全部转为大写
    public void test02() {
        System.out.println("---------------------2----------------------");
        System.out.println("输入要变为大写的字符串");

        String s = scanner.nextLine();
        String s2 = s.toUpperCase();
        System.out.println(s2);

    }

    //3.将字符串“test”变为“tset”
    public void test03() {
        System.out.println("---------------------3----------------------");
        String s = "test";
        String replace = s.replace("es", "se");
        System.out.println(replace);

    }

    //4.将字符串“To be or not to be”每一个单词都逆序，结果为“oT eb ro ton ot eb ”（可以用StringBuffer类，可以自学）
    public void test04() {
        System.out.println("---------------------4----------------------");
        System.out.println("输入一排单词(空格分开)");
        String s = scanner.nextLine();
        String[] s2 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s2.length; i++) {
            StringBuffer sb1 = new StringBuffer(s2[i]);
            sb.append(" " + sb1.reverse());
        }
        s = sb.toString();
        String trim = s.trim();
        System.out.println(trim);

    }

    //5输入一个字符串，判断该字符串是不是邮箱地址
    public void test05() {
        System.out.println("---------------------5----------------------");
        String a = "^\\s*?(.+)@(.+?)\\s*$";
        System.out.println("输入你的邮件");
        String s = scanner.nextLine();
        if (s.matches(a)) {
            System.out.println("是");

        } else {
            System.out.println("否");
        }
    }

    //6.统计一个字符串中出现的大写字母的次数
    public void test06() {
        System.out.println("---------------------6----------------------");
        System.out.println("输入带大写字母的字符串");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                count++;

            }


        }
        System.out.println("大写字母次数:" + count);

    }

    //7.输入一串数字字符串，计算每个数字出现的次数
    public void test07() {
        System.out.println("---------------------7----------------------");
        System.out.println("输入数字字符串");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int[] counts = new int[10];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '0':
                    counts[0]++;
                    break;
                case '1':
                    counts[1]++;
                    break;
                case '2':
                    counts[2]++;
                    break;
                case '3':
                    counts[3]++;
                    break;
                case '4':
                    counts[4]++;
                    break;
                case '5':
                    counts[5]++;
                    break;
                case '6':
                    counts[6]++;
                    break;
                case '7':
                    counts[7]++;
                    break;
                case '8':
                    counts[8]++;
                    break;
                case '9':
                    counts[9]++;
                    break;
                default:
                    break;


            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ":" + counts[i]);
        }


    }

    //8
    public void test08() {
        System.out.println("---------------------8----------------------");
        System.out.println("输入字符串,带空格");
        String s1 = scanner.nextLine();
        //(1) 统计该字符串中字母s出现的次数
        int scount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.toCharArray()[i] == 's') {
                scount++;
            }

        }
        System.out.println("s出现的次数:" + scount);
        //(2) 取出子字符串"test"
        String s2 = s1.replace("test", "");

        //(3) 将字符串中每个单词的第一个字母变成大写， 输出到控制台。
        String[] arr1 = s2.split(" ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i].substring(0, 1).toUpperCase() + arr1[i].substring(1);
        }
        System.out.print("首字母大写:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        //(4) 用两种方式实现该字符串的倒叙输出。(用StringBuffer和for循环方式分别实现)
        //1
        StringBuffer sb = new StringBuffer(s1);
        StringBuffer sb2 = sb.reverse();
        System.out.println("方式一:" + sb2);
        //2
        StringBuffer sb3 = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            sb3.append(s1.toCharArray()[s1.length() - i - 1]);
        }
        System.out.println("方式二" + sb3);
        //(5) 将本字符串转换成一个字符串数组，要求每个数组元素都是一个有意义的额英文单词,并输出到控制台
        String[] arr2 = s1.split(" ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }


    }

    public void closeSc(){
        if(scanner!=null)
        scanner.close();
    }
}
