<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生档案管理系统</title>
    <link rel="stylesheet" href="../css/template.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/person/iconfont.css">
    <style>
        .background{
            background-image: url("../image/login-bg.jpg");
        }
    </style>
</head>

<body>
    <div class="background">
        <div class="top-bar">

            <div class="left">
                <div class="function-list">
                    <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                    <ul>
                        <li><a href="/Project05/teacher/TeacherServlet/showMyClass">班级管理</a></li>
                        <li class="line"></li>
                        <li><a href="/Project05/teacher/TeacherServlet/showGrade?isReverse=false">学生成绩管理</a></li>
                        <li class="line"></li>
                        <li><a href="/Project05/teacher/TeacherServlet/showStudent">学生管理</a></li>
                        <li class="line"></li>
                        <li><a href="#">......</a></li>
                        <li class="line"></li>
                        <li><a href="#">......</a></li>
                    </ul>
                </div>
                <div class="sysytemname">学生档案管理系统</div>
            </div>


            <div class="mid">
            </div>


            <div class="right">
                <div class="hello">你好,${sessionScope.user.userName}</div>
                <div class="people">
                    <span class="iconfont person">&#xe604;
                    </span>
                    <div class="student-info">
                        <ul>
                            <li> <a href="/Project05/teacher/TeacherServlet/toEdit">个人信息修改</a></li>
                            <li class="line"></li>
                            <li> <a href="/Project05/index.jsp">退出登录</a></li>
                        </ul>
                    </div>
                    <div class="triangle"></div>
                </div>

                <a href="/Project05/index.jsp"><span class="iconfont icon-tuichu"></span></a>

            </div>
        </div>

    </div>
</body>

</html>