package service.impl;

import util.JdbcUtilsOnly;

import java.sql.*;
import java.util.Scanner;

/**
 * @author lijiaao
 * @version 1.0
 * @date 2020/9/27 19:27
 */
public class Admin_Class {
    public static Scanner sc = new Scanner(System.in);

    public static void delete() {
        Connection connection = null;
        try {
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("===============删除班级===============");
            System.out.println("请输入要删除班级的班号:");
            String id = sc.next();
            String sql = "delete from clazz where classid='" + id + "'";
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
            System.out.println("===============添加班级===============");
            PreparedStatement ps = connection.prepareStatement("insert into clazz (classname,teacherid) "
                    + "values(?,?)");

            System.out.println("请输入新班级的名称：");
            String cName = sc.next();
            ps.setString(1, cName);

            System.out.println("请输入该班级教师编号：");
            int tId = sc.nextInt();
            ps.setInt(2, tId);

//            System.out.println("请输入新学生的班级号：");
//            int sClassId = sc.nextInt();
//            ps.setInt(3, sClassId);

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
            System.out.println("===============查询班级===============");
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("请输入您要查询班级的班号：");
            int id = sc.nextInt();
            String sql = "select * from clazz where classid = '" + id + "'";
            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("班号" + "\t\t" + "班级名称" + "\t\t" + "教师编号");
            System.out.println("--------------------------------------");
            String classId = null;
            String className = null;
            String teacherId = null;
            while (rs.next()) {
                classId = rs.getString("classId");
                className = rs.getString("className");
                teacherId = rs.getString("teacherId");
                //输出结果
                System.out.println(classId + "\t\t" + className + "\t\t" + teacherId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }


    public static void main(String[] args) throws SQLException {
        Admin_Class.add();
        Admin_Class.find();
        Admin_Class.delete();

    }
}
