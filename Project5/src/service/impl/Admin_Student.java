package service.impl;

import util.JdbcUtilsOnly;

import java.sql.*;
import java.util.Scanner;

public class Admin_Student {
    public static Scanner sc = new Scanner(System.in);

    public static void delete() {
        Connection connection = null;
        try {
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("===============删除学生===============");
            System.out.println("请输入要删除学生的学号:");
            String id = sc.next();
            String sql = "delete from student where studentid='" + id + "'";
            //ResultSet类，用来存放获取的结果集！！
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功！");
            } else if (i == 0){
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            System.out.println("删除失败！");
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }

    public static void add() {
        Connection connection = null;
        try {
            connection = JdbcUtilsOnly.getConnection();
            //要执行的SQL语句
            System.out.println("===============添加学生===============");
            PreparedStatement ps = connection.prepareStatement("insert into student (studentname,studentage,classid) "
                    + "values(?,?,?)");

            System.out.println("请输入新学生的姓名：");
            String sName = sc.next();
            ps.setString(1, sName);

            System.out.println("请输入新学生的年龄：");
            int sAge = sc.nextInt();
            ps.setInt(2, sAge);

            System.out.println("请输入新学生的班级号：");
            int sClassId = sc.nextInt();
            ps.setInt(3, sClassId);

            int i = ps.executeUpdate();//执行更新
            if (i > 0) {
                System.out.println("更新成功！");
            } else if (i == 0){
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }

    public static void find() {
        Connection connection = null;
        try {
            System.out.println("===============查询学生===============");
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("请输入您要查询学生的学号：");
            int id = sc.nextInt();
            String sql = "select * from student where studentid = '" + id + "'";
            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("学号" + "\t\t" + "姓名" + "\t\t" + "年龄");
            System.out.println("--------------------------------------");
            String stuId = null;
            String stuName = null;
            String stuAge = null;
            while (rs.next()) {
                stuId = rs.getString("studentid");
                stuName = rs.getString("studentname");
                stuAge = rs.getString("studentage");
                //输出结果
                System.out.println(stuId + "\t\t" + stuName + "\t\t" + stuAge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }


    public static void main(String[] args) throws SQLException {
        Admin_Student.add();
        Admin_Student.find();
        Admin_Student.delete();

    }
}
