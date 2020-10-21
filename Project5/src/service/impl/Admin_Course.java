package service.impl;

import util.JdbcUtilsOnly;

import java.sql.*;
import java.util.Scanner;

/**
 * @author lijiaao
 * @version 1.0
 * @date 2020/9/27 19:46
 */
public class Admin_Course {
    public static Scanner sc = new Scanner(System.in);

    public static void delete() {
        Connection connection = null;
        try {
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("===============删除课程===============");
            System.out.println("请输入要删除课程的课程号:");
            String id = sc.next();
            String sql = "delete from course where couseid='" + id + "'";
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
            System.out.println("===============添加课程===============");
            PreparedStatement ps = connection.prepareStatement("insert into course (coursename) "
                    + "values(?)");

            System.out.println("请输入新课程的名称：");
            String cName = sc.next();
            ps.setString(1, cName);


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
            System.out.println("===============查询课程===============");
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("请输入您要查询课程的课程号：");
            int id = sc.nextInt();
            String sql = "select * from course where couseid = '" + id + "'";
            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("课程号" + "\t\t" + "课程名称" + "\t\t" );
            System.out.println("--------------------------------------");
            String couseId = null;
            String courseName = null;

            while (rs.next()) {
                couseId = rs.getString("couseId");
                courseName = rs.getString("courseName");

                //输出结果
                System.out.println(couseId + "\t\t" + courseName+ "\t\t" );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }


    public static void main(String[] args) throws SQLException {
        Admin_Course.add();
        Admin_Course.find();
        Admin_Course.delete();

    }
}
