<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生档案管理系统</title>
    <link rel="stylesheet" href="../teacher/css/template.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="./css/manager-course.css">
    <link rel="stylesheet" href="../css/btn.css">
    <link rel="stylesheet" href="./css/mananger.css">
</head>

<body>
    <div class="background">
        <div class="top-bar">
            <div class="left">
                <div class="function-list">
                    <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                    <ul>
                        <li><a href="./mananger-student.jsp">学生管理</a></li>
                        <li class="line"></li>
                        <li><a href="./mananger-teacher.jsp">教师管理</a></li>
                        <li class="line"></li>
                        <li><a href="admin.jsp">班级管理</a></li>
                        <li class="line"></li>
                        <li><a href="#">课程管理</a></li>
                        <li class="line"></li>
                        <li><a href="#">......</a></li>
                    </ul>
                </div>
                <div class="sysytemname">学生档案管理系统&nbsp;&nbsp;&nbsp;课程管理</div>
            </div>


            <div class="mid">
            </div>


            <div class="right">
                <div class="hello">你好,果汁盒</div>
                <div class="people">
                    <span class="iconfont person">&#xe604;
                    </span>
                    <div class="student-info">
                        <ul>
                            <li> <a href="./mananger-student.jsp">学生管理</a></li>
                            <li class="line"></li>
                            <li> <a href="./mananger-teacher.jsp">教师管理</a></li>
                            <li class="line"></li>
                            <li> <a href="./mananger-course.jsp">班级管理</a></li>
                            <li class="line"></li>
                            <li> <a href="#">课程管理</a></li>
                            <li class="line"></li>
                            <li> <a href="./login.jsp">退出</a></li>
                        </ul>
                    </div>
                    <div class="triangle"></div>
                </div>

                <a href="./login.jsp"><span class="iconfont icon-tuichu"></span></a>

            </div>
        </div>
        <!-- 中间内容 -->
        <div class="content">
            <form action="#" class="table">
                <div class="content-top">
                    <h3>课程管理</h3>
             <%--       <div class="choice">
                        <ul>
                            <li>学年学期：&nbsp;&nbsp;&nbsp;<select name="academic-year-and-semester" id="academic-year-and-semester-list">
                        <option value="1">2020-2021学年第1学期</option>
                        <option value="2">2020-2021学年第2学期</option>
                        <option value="3">2019-2020学年第1学期</option> 
                        <option value="4">2019-2020学年第2学期</option> 
                             </select>
                            </li>
                            <li><button class="bttn-unite bttn-lg bttn-primary">切换学期</button></li>
                        </ul>
                    </div>--%>
                    <table id="ver-zebra">
                        <tr>
                            <td>学年学期</td>
                            <td>课程代码</td>
                            <td>课程序号</td>
                            <td>课程名称</td>
                            <td>课程类别</td>
                            <td>学分</td>
                            <td>操作</td>
                        </tr>
                        <tr>

                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>
                                <ul class="change">
                                    <a href="/Project05/admin/AdminServlet/toAddCourse"><li><button class="bttn-unite bttn-sm bttn-primary">增加课程信息</button></li> </a>
                                    <a href="/Project05/admin/AdminServlet/toDeleteCourse"><li><button class="bttn-unite bttn-sm bttn-primary">删除课程信息</button></li> </a>
                                    <a href="/Project05/admin/AdminServlet/toFindCourse"><li><button class="bttn-unite bttn-sm bttn-primary">查找课程信息</button></li> </a>

                                </ul>
                            </td>
                        </tr>
                    </table>

                </div>
            </form>
        </div>

    </div>

</body>

</html>