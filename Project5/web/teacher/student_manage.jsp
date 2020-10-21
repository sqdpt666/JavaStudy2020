<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生管理</title>
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
                    <li><a href="./student-class.html">班级信息查看</a></li>
                    <li class="line"></li>
                    <li><a href="./student-grades.html">学生成绩</a></li>
                    <li class="line"></li>
                    <li><a href="#">......</a></li>
                    <li class="line"></li>
                    <li><a href="#">......</a></li>
                    <li class="line"></li>
                    <li><a href="#">......</a></li>
                </ul>
            </div>
            <div class="sysytemname">学生管理</div>
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
                        <li> <a href="./student-grades.html">学生成绩</a></li>
                        <li class="line"></li>
                        <li> <a href="./student-class.html">查看班级信息</a></li>
                        <li class="line"></li>
                        <li> <a href="./teacher-info.html">个人信息修改</a></li>
                        <li class="line"></li>
                        <li> <a href="./login.html">退出登录</a></li>
                    </ul>
                </div>
                <div class="triangle"></div>
            </div>

            <a href="./login.html"><span class="iconfont icon-tuichu"></span></a>

        </div>
    </div>
    <!-- 中间内容 -->
    <div class="content">
        <form action="#" class="table">
            <div class="content-top">
                <h3>学生管理</h3>
                <div class="choice">
                    <ul>
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
                <div class="search-nav">
                    <div class="search">
                        <span>搜索：</span><input type="text" placeholder="请输入学生编号" name="username">
                    </div>
                    <div class="add">
                        <td><button class="bttn-unite bttn-sm bttn-primary">增加</button></td>
                    </div>
                </div>
                <table>
                    <tr>
                        <td>姓名</td>
                        <td>性别</td>
                        <td>年龄</td>
                        <td>课程名称</td>
                        <td>课程类别</td>
                        <td>成绩</td>
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
                        <td>......</td>
                        <td><button class="bttn-unite bttn-sm bttn-primary">删除</button></td>
                    </tr>
                    <tr>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td><button class="bttn-unite bttn-sm bttn-primary">删除</button></td>
                    </tr>
                    <tr>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td><button class="bttn-unite bttn-sm bttn-primary">删除</button></td>
                    </tr>
                    <tr>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td><button class="bttn-unite bttn-sm bttn-primary">删除</button></td>
                    </tr>
                    <tr>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td>......</td>
                        <td><button class="bttn-unite bttn-sm bttn-primary">删除</button></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>

</div>

</body>

</html>