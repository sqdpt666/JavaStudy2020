<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>班级信息</title>
    <link rel="stylesheet" href="../css/template.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="../css/student-grades.css">
    <link rel="stylesheet" href="../css/btn.css">
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
            <div class="sysytemname">班级信息</div>
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
    <div class="content">
        <form action="#" class="table">
            <div class="content-top">
                <h3>班级信息</h3>
                <div class="choice">
                    <ul>
                        <li>专业年级：&nbsp;&nbsp;&nbsp;<select name="academic-year-and-semester" id="academic-year-and-semester-list">
                            <c:forEach items="${requestScope.clazzList}"  var="clazz"   >
                                <option value="${clazz.classId}">${clazz.className}</option>
                            </c:forEach>
                        </select>
                        </li>
                        <li><input type="submit" value="切换班级"></li>
                    </ul>
                </div>
                <div class="search-nav">
                    <div class="search">
                        <span>搜索：</span><input type="text" placeholder="请输入班级编号" name="username">
                    </div>
                    <div class="add">
                        <td><button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/teacher/TeacherServlet/toAddClass">增加</a></button></td>
                    </div>
                </div>
                <table>
                    <tr>
                        <td>班级编号</td>
                        <td>班级名称</td>
                        <td>班主任编号</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${requestScope.clazzList}"  var="clazz"   >
                        <tr>
                            <td>${clazz.classId}</td>
                            <td>${clazz.className}</td>
                            <td>${clazz.teacherId}</td>
                            <td>  <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/teacher/TeacherServlet/toEditClass?classId=${clazz.classId}">修改</a></button>
                                <button class="bttn-unite bttn-sm bttn-primary"><a href="/Project05/teacher/TeacherServlet/toDeleteClass?classId=${clazz.classId}">删除</a></button> </td>
                        </tr>

                    </c:forEach>

                </table>
            </div>
        </form>
    </div>

</div>

</body>

</html>