package com.dell.yangzhou.MyselfStudy.IO;


import java.io.*;

/**
 *
 * input:从外部到内存
 * output:从内存到外部
 * 流的分类:字节流(8 bit) inputStream,OutputStream
 *         字符流(16 bit) Reader Writer
 *
 *
 *
 */
public class IOstudy {
    public static void main(String[] args)  {
  IOstudy iOstudy=new IOstudy();
  iOstudy.Test();
        System.out.println("-------------------");
  iOstudy.Test02();
        System.out.println("-------------------");
        iOstudy.Test03();
        System.out.println("-------------------");
        iOstudy.Test04();
        System.out.println("-------------------");

    }


    public void Test(){
        FileReader fileReader = null;
        try {
            //1.实例化file
            File file=new File("hey.txt");
            //2.指明流
            fileReader =new FileReader(file);
            //3.数据的读入
            //read() 返回读入一个字符,如果达到末尾,返回-1
            int data;
            while ((data=fileReader.read())!=-1){
                System.out.print((char) data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            try {
                if(fileReader!=null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Test02(){
        FileReader fileReader = null;
        try {

            File file=new File("hey.txt");
            fileReader =new FileReader(file);
            //指明每次读取的大小
            char[] cbf=new char[5];
            int data2 = 0;
            while ( (data2=fileReader.read(cbf))!=-1){
              //  System.out.println();
                //方式1
               /* for(int i=0;i<data2;i++){
                    System.out.print(cbf[i]);
                }*/
                //方式二
                String s=new String(cbf,0,data2);
                System.out.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            try {
                if(fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Test03(){
        FileWriter fw= null;

        try {
            //不存在会自动创建
            File file=new File("hey2.txt");
            //append参数为true表示追加, false表示覆盖,默认false
            fw = new FileWriter(file,true);
            fw.write("I have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
//文本的复制
    public void Test04(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File file=new File("hey.txt");
            File file1=new File("hey3.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file1);

            char[] chars=new char[5];
            int len;
            while (  -1!=(len=fr.read(chars))    ){

                fw.write(chars,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw!=null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
//字节流
    public void Test05(){

        FileInputStream fr= null;
        FileOutputStream fw= null;
        try {
            File file=new File("hey.txt");
            File file1=new File("hey3.txt");
            fr = new FileInputStream(file);
            fw = new FileOutputStream(file1);

            byte[] chars=new byte[5];
            int len;
            while (  -1!=(len=fr.read(chars))    ){

                fw.write(chars,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
//缓存流
    public void Test06(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos= null;
        try {
            //1.文件
            File file=new File("hey.txt");
            File file1=new File("hey4.txt");
            //2.字节流
            FileInputStream fi=new FileInputStream(file);
            FileOutputStream fo=new FileOutputStream(file1);
            //3.缓存流
            bis = new BufferedInputStream(fi);
            bos = new BufferedOutputStream(fo);

            //4.复制
            byte[] bytes=new byte[5];
            int len;
            while ((len=bis.read(bytes) )!=-1)
            {

                bos.write(bytes,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流 先造后关  ,
            try {
                if(bos!=null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis!=null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明 :关闭外层会自动关闭内存
            // fo.close();
            // fi.close();
        }



    }
//转换流
    public void Test07(){
/*
        FileInputStream fis=new FileInputStream("hey.txt");
        InputStreamReader isr=new InputStreamReader(fir);//默认系统的字符集
        InputStreamReader isr=new InputStreamReader(fir,"UTF-8");//指明字符集
        char[] chars=new char[10];
        int len;
        while ((len=isr.read(chars))!=-1){
            String s=new String(chars,0,len);
            System.out.println(s);

        }*/
    }

}
