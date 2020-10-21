<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生成绩</title>
    <link rel="stylesheet" href="css/template.css">
    <link rel="stylesheet" href="../css/btn.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/other/iconfont.css">
    <link rel="stylesheet" href="../fontlibrary/iconfont/person/iconfont.css">
    <link rel="stylesheet" href="./css/student-grades.css">
</head>


<body>
    <div class="background">
        <div class="top-bar">
            <div class="left">
                <div class="function-list">
                    <a href="#"><span class="iconfont person">&#xe6b5;</span></a>
                    <ul>
                        <li><a href="student_class.jsp">班级信息查看</a></li>
                        <li class="line"></li>
                        <li><a href="student_manage.jsp">查看学生管理</a></li>
                        <li class="line"></li>
                        <li><a href="#">......</a></li>
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
                <div class="hello">你好,果汁盒</div>
                <div class="people">
                    <span class="iconfont person">&#xe604;
                    </span>
                    <div class="student-info">
                        <ul>
                            <li> <a href="student_manage.jsp">查看学生管理</a></li>
                            <li class="line"></li>
                            <li> <a href="student_class.jsp">班级信息查看</a></li>
                            <li class="line"></li>
                            <li> <a href="./student-info.html">个人信息修改</a></li>
                            <li class="line"></li>
                            <li> <a href="login.jsp">退出登录</a></li>
                        </ul>
                    </div>
                    <div class="triangle"></div>
                </div>

                <a href="login.jsp"><span class="iconfont icon-tuichu"></span></a>

            </div>
        </div>
        <!-- 中间内容 -->
        <div class="content">
            <form action="#" class="table">
                <div class="content-top">
                    <h3>学生成绩</h3>
                    <div class="choice">
                        <ul>
                            <li>学年学期：&nbsp;<select name="academic-year-and-semester" id="academic-year-and-semester-list">
                            <option value="1">2020-2021学年第1学期</option>
                            <option value="2">2020-2021学年第2学期</option>
                            <option value="3">2019-2020学年第1学期</option> 
                            <option value="4">2019-2020学年第2学期</option> 
                        </select>
                            </li>
                            <li>专业年级：&nbsp;<select name="academic-year-and-semester" id="academic-year-and-semester-list">
                                <option value="1">应用统计学16级</option>
                                <option value="2">应用统计学17级</option>
                                <option value="3">应用统计学18级</option> 
                                <option value="4">应用统计学19级</option> 
                            </select>
                                </li>
                            <li><input type="submit" value="切换学期年级"></li>
                        </ul>
                    </div>
                    <table>
                        <tr>
                            <td>学生姓名</td>
                            <td>性别</td>
                            <td>年龄</td>
                            <td>课程名称</td>
                            <td>课程类别</td>
                            <td>成绩</td>
                        </tr>
                        <tr>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                        </tr>
                        <tr>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                        </tr>
                        <tr>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                        </tr>
                        <tr>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                        </tr>
                        <tr>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                            <td>......</td>
                        </tr>
                    </table>
                    <div class="box">
                        <div class="order">
                            <table><tr><td>逆序</td></tr></table>
                        </div>
                        <div class="average-grade">
                            平均分:&nbsp;<input class="average" type="text">
                        </div>
                        <div class="print">
                            <table><tr><td>导出</td></tr></table>
                        </div>
                    </div>
                   
                </div>
            </form>
        </div>

    </div>

</body>

</html>