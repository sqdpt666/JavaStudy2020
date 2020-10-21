<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生档案管理系统</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/student/head.jsp" %>
    <link rel="stylesheet" href="css/template.css">
    <link rel="stylesheet" href="fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="student/css/student-class.css">

</head>


<body>
<div class="background">
    <div class="top-bar">

        <div class="left">
            <div class="function-list">
                <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                <ul>
                    <li><a href="StudentServlet/classinfo?uid=${requestScope.user.userId}">班级信息查看</a></li>
                    <li class="line"></li>
                    <li><a href="StudentServlet/gradeinfo?uid=${requestScope.user.userId}">查看个人成绩</a></li>
                    <li class="line"></li>
                </ul>
            </div>
            <div class="sysytemname">学生档案管理系统</div>
        </div>


        <div class="mid">
        </div>


        <div class="right">
            <div class="hello">你好${sessionScope.user.userName}<br/></div>
            <div class="people">
                    <span class="iconfont person">&#xe604;
                    </span>
                <div class="student-info">
                    <ul>
                        <li><a href="UserServlet/getUser">个人信息修改</a></li>
                        <li class="line"></li>
                        <li><a href="/Project05/index.jsp">退出登录</a></li>
                    </ul>
                </div>
                <div class="triangle"></div>
            </div>

            <a href="/Project05/index.jsp"><span class="iconfont icon-tuichu"></span></a>

        </div>


    </div>
    <!-- 中间内容 -->
</body>

</html>