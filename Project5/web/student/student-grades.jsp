<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生成绩</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/student/head.jsp" %>
    <link rel="stylesheet" href="css/template.css">
    <link rel="stylesheet" href="fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="student/css/student-grades.css">
    <link rel="stylesheet" href="css/btn.css">
</head>


<body>
<div class="background">
    <div class="top-bar">
        <div class="left">
            <div class="function-list">
                <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                <ul>
                    <li><a href="StudentServlet/classinfo?uid=${sessionScope.user.userId}">班级信息查看</a></li>
                    <li class="line"></li>
                    <li><a href="StudentServlet/gradeinfo?uid=${sessionScope.user.userId}">查看个人成绩</a></li>
                    <li class="line"></li>
                </ul>
            </div>
            <div class="sysytemname">学生成绩</div>
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
                        <li><a href="UserServlet/getUser?uid=${sessionScope.user.userId}">个人信息修改</a></li>
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
    <div class="content">
        <div class="content-top">
            <h3>我的成绩</h3>
            <div class="choice">
                <ul>
                    <li>学年学期：&nbsp;&nbsp;&nbsp;<select name="academic-year-and-semester"
                                                       id="academic-year-and-semester-list">
                        <option value="1">2020-2021学年第1学期</option>
                        <option value="2">2020-2021学年第2学期</option>
                        <option value="3">2019-2020学年第1学期</option>
                        <option value="4">2019-2020学年第2学期</option>
                    </select>
                    </li>
                    <li>
                        <button class="bttn-unite bttn-sm bttn-primary">切换学期</button>
                    </li>
                </ul>
            </div>
            <table>
                <tr>
                    <td>课程号</td>
                    <td>学号</td>
                    <td>成绩</td>
                </tr>
                <form action="StudentServlet/gradeinfo" method="post">
                    <c:forEach items="${requestScope.gradeinfo}" var="G">
                    <tr>
                        <td>${G.courseId}</td>
                        <td>${G.studentId}</td>
                        <td>${G.grade}</td>
                    </tr>
                    </c:forEach>
            </table>
        </div>
        </form>
    </div>

</div>

</body>

</html>