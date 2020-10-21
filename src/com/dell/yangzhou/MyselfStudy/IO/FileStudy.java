package com.dell.yangzhou.MyselfStudy.IO;

import java.io.File;
import java.io.IOException;

/**
 *
 * File类的使用
 * 1.File类的一个对象,代表一个文件
 * 2.File类的声明在java.io下
 *
 */
public class FileStudy {
  public static void main(String[] args) {
    FileStudy study=new FileStudy();
    study.Test01();
  }
  /**
   * 1.创建一个File实例
   * 2.相对路径
   *   绝对路径
   * 3.
   */
  public void Test01() {
    //构造器1
    File file=new File("hello.txt");//相当于当前目录 // D:\MyDown\idea\JavaStudy2020\src\com\dell\yangzhou\MyselfStudy>
    File file1=new File("D:\\MyDown\\idea\\JavaStudy2020\\src\\com\\dell\\yangzhou\\MyselfStudy"+ File.separator+"he.txt");// File.separator 相当于 "\\" (windows等...)或者 "/" (URL等...)
    System.out.println(file);//hello.txt
    System.out.println(file1);//D:\MyDown\idea\JavaStudy2020\src\com\dell\yangzhou\MyselfStudy\he.txt

    //构造器2
    File file2=new File("D:\\MyDown\\idea\\JavaStudy2020\\src\\com\\dell\\yangzhou","MyselfStudy");
    System.out.println(file2);//D:\MyDown\idea\JavaStudy2020\src\com\dell\yangzhou\MyselfStudy

    //构造器3
    File file3=new File(file2,"h.txt");
    System.out.println(file3);//D:\MyDown\idea\JavaStudy2020\src\com\dell\yangzhou\MyselfStudy\h.txt

   //public String getAbsolutePath():获取绝对路径
    System.out.println("file--"+file.getAbsolutePath());
    //public String getPath() 获取路径


    //public String getName() 获取名称

    //public String getParent() 获得上层目录,若没有,返回null

    //public String Length() 获取文件长度(即:字节数). 不能获取目录的长度

      //public Long lastModified() 获取上一次修改的时间,返回毫秒

    //public String[] list(): 获取指定目录下的所有文件或者目录的名称数组

    //public File[] listFiles(): 获取指定目录下的所有文件或目录的File数组

    //public boolean renameTo(File dest) :把文件重命名并且移动到指定路径
         //file1.renameTo(file2)  如果要成功,file1得存在,file2得不存在
     File file4=new File("D:\\MyDown\\idea\\JavaStudy2020\\src\\com\\dell\\yangzhou\\MyselfStudy\\hello.txt");
     boolean b= file1.renameTo(file4);
     System.out.println(b);
    boolean b2= file4.renameTo(file1);
    System.out.println(b2);

  //boolean isDirectory() 判断是否是文件目录
    //boolean isFile()  判断是否是文件
    //boolean exists()  判断是否存在
    //boolean canRead() 判断是否可读
    //boolean canWrite() 判断是否可写
    //boolean isHidden()  判断是否隐藏


    //boolean createNewFile() 创建文件,若存在则不创建,返回flase
    //boolean mkdir()   创建文件目录,如果此文件目录存在,就不创建,如果上层目录不存在,返回false
    //boolean mkdirs() 创建文件目录,如果上层目录不存在,一并创建
    //boolean delete() 删除文件或者文件夹 (删除不走回收站)
    //1.文件的创建
    File file5=new File("hey.txt");
    if(!file5.exists()){
      try {
        file5.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("创成功");
    }else {
      System.out.println("文件已存在");
      file5.delete();
      System.out.println("文件已删除");
    }
//2.文件目录的创建
    File file6=new File("hello");
    boolean mkdir = file6.mkdir();
    if(mkdir){
      System.out.println("创建成功");
    }else {
      System.out.println("创建失败");
      file6.delete();
    }


  }

}
