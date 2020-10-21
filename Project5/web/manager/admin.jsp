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
    <link rel="stylesheet" href="../css/manager-course.css">
    <link rel="stylesheet" href="../css/btn.css" class="btn">
    <link rel="stylesheet" href="../css/mananger.css">

</head>


<body>
    <div class="background">
        <div class="top-bar">

            <div class="left">
                <div class="function-list">
                    <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                        <li><a href="#">......</a></li>
                    </ul>
                </div>
                <div class="sysytemname">学生档案管理系统&nbsp;&nbsp;&nbsp;管理员</div>
            </div>


            <div class="mid">
            </div>


            <div class="right">
                <div class="hello">你好,${requestScope.user.userName}</div>
                <div class="people">
                    <span class="iconfont person">&#xe604;
                    </span>
                    <div class="student-info">
                        <ul>

                            <li class="line"></li>
                            <li> <a href="./login.jsp">退出</a></li>
                            <li class="line"></li>
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
                    <h3>班级管理</h3>
               <%--     <div class="choice">
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
                            <td>班级</td>

                            <td>
                                <ul class="change">
                                    <li>   <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toAddClass">增加班级信息 </a></button> </li>
                                    <li>  <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toDeleteClass">删除班级信息 </a></button></li>
                                    <li> <button class="bttn-unite bttn-sm bttn-primary"> <a href="/Project05/admin/AdminServlet/toFindClass">>查找班级信息 </a></button> </li>

                                </ul>
                            </td>
                        </tr>

                        <tr>
                            <td>课程</td>

                            <td>
                                <ul class="change">
                                    <li>  <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toAddCourse">增加课程信息</a></button></li>
                                    <li> <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toDeleteCourse">删除课程信息</a></button></li>
                                    <li><button class="bttn-unite bttn-sm bttn-primary"> <a href="/Project05/admin/AdminServlet/toFindCourse">查找课程信息</a></button></li>

                                </ul>
                            </td>
                        </tr>

                        <tr>


                            <td>学生</td>

                            <td>
                                <ul class="change">
                                    <li><button class="bttn-unite bttn-sm bttn-primary"> <a href="/Project05/admin/AdminServlet/toAddStudent">增加学生信息</a></button> </li>
                                    <li> <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toDeleteStudent">删除学生信息</a></button></li>
                                    <li>  <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toFindStudent">查找学生信息</a></button> </li>

                                </ul>
                            </td>
                        </tr>

                        <tr>
                            <td>老师</td>

                            <td>
                                <ul class="change">
                                    <li> <button class="bttn-unite bttn-sm bttn-primary"> <a href="/Project05/admin/AdminServlet/toAddTeacher">增加老师信息</a></button></li>
                                    <li>  <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/admin/AdminServlet/toDeleteTeacher">删除老师信息</a></button></li>
                                    <li> <button class="bttn-unite bttn-sm bttn-primary"> <a href="/Project05/admin/AdminServlet/toFindTeacher">查找老师信息</a></button></li>

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