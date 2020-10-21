<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生成绩</title>
    <link rel="stylesheet" href="../css/template.css">
    <link rel="stylesheet" href="../css/btn.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="../css/student-grades.css">
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
    <!-- 中间内容 -->

    <%
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
          //  response.setHeader("Content-Disposition", "inline; filename=" + "excel.xls");

        }
    %>

    <div class="content">
        <form action="#" class="table">
            <div class="content-top">
                <h3>学生成绩</h3>
                <div class="choice">
                    <ul>
                        <li>课程：&nbsp;<select name="academic-year-and-semester" id="academic-year-and-semester-list">
                            <c:forEach items="${requestScope.courseList}" var="course">
                                <option value="${course.courseId}">${course.courseName}</option>
                            </c:forEach>
                        </select>
                        </li>
                        <li><input type="submit" value="切换学期年级"></li>
                    </ul>
                </div>
                <table>
                    <tr>
                        <td>课程id</td>
                        <td>学生id</td>
                        <td>成绩</td>
                    </tr>
                    <c:forEach items="${requestScope.gradeList}" var="grade">
                        <tr>
                            <td>${grade.courseId}</td>
                            <td>${grade.studentId}</td>
                            <td>${grade.grade}</td>
                        </tr>

                    </c:forEach>

                </table>
                <div class="box">
                    <div class="order">
                        <table><tr><td><a href="/Project05/teacher/TeacherServlet/showGrade?isReverse=true">逆序</a></td></tr></table>
                    </div>
                    <div class="average-grade">
                        平均分:&nbsp;<input class="average" type="text" readonly value="${requestScope.avg}">
                    </div>

                    <%
                        if (exportToExcel == null ) {
                    %>
                    <div class="print">
                        <table><tr><td><a href="/Project05/teacher/TeacherServlet/toExcel">导出</a></td></tr></table>
                    </div>
                    <%
                        }
                    %>

                </div>

            </div>
        </form>
    </div>

</div>

</body>

</html>