package service.impl;

import util.JdbcUtilsOnly;

import java.sql.*;
import java.util.Scanner;

/**
 * @author lijiaao
 * @version 1.0
 * @date 2020/9/27 19:12
 */
public class Admin_Teacher {
    public static Scanner sc = new Scanner(System.in);

    public static void delete() {
        Connection connection = null;
        try {
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("===============删除教师===============");
            System.out.println("请输入要删除教师的id:");
            String id = sc.next();
            String sql = "delete from teacher where teacherid='" + id + "'";
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
            System.out.println("===============添加教师===============");
            PreparedStatement ps = connection.prepareStatement("insert into teacher (teachername,teacherage) "
                    + "values(?,?)");

            System.out.println("请输入新教师的姓名：");
            String tName = sc.next();
            ps.setString(1, tName);

            System.out.println("请输入新教师的年龄：");
            int sAge = sc.nextInt();
            ps.setInt(2, sAge);

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
            System.out.println("===============查询教师===============");
            connection = JdbcUtilsOnly.getConnection();
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = connection.createStatement();
            //要执行的SQL语句
            System.out.println("请输入您要查询教师的id：");
            int id = sc.nextInt();
            String sql = "select * from teacher where teacherid = '" + id + "'";
            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("id" + "\t\t" + "姓名" + "\t\t" + "年龄");
            System.out.println("--------------------------------------");
            String teacherId = null;
            String teacherName = null;
            String teacherAge = null;
            while (rs.next()) {
                teacherId = rs.getString("teacherId");
                teacherName = rs.getString("teacherName");
                teacherAge = rs.getString("teacherAge");
                //输出结果
                System.out.println(teacherId + "\t\t" + teacherName + "\t\t" + teacherAge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsOnly.close(connection);
        }
    }


    public static void main(String[] args) throws SQLException {
        Admin_Teacher.add();
        Admin_Teacher.find();
        Admin_Teacher.delete();

    }
}
