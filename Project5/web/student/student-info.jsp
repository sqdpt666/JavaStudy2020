<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生个人信息</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/student/head.jsp"%>
    <link rel="stylesheet" href="fontlibrary/awesome/css/all.css">
</head>
<style>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    .clearfix:after {
        content: '';
        display: block;
        clear: both;
    }

    .background {
        width: 100vw;
        height: 100vh;
        background-image: url(image/login-bg.jpg);
        background-repeat: no-repeat;
        background-size: 100vw 100vh;
        margin: 0 auto;
        overflow: hidden;
    }

    .content {
        width: 500px;
        height: 425px;
        margin: 0 auto;
        background-color: rgba(243, 245, 243, .85);
        margin-top: 100px;
    }

    .head {
        display: flex;
        justify-content: space-between;
        width: 500px;
        line-height: 100px;
        margin: 0 auto;
    }

    .head p {
        margin-left: -80px;
        font-size: 20px;
    }

    .head img {
        width: 100px;
    }
    /*  */

    ul.input {
        width: 500px;
        overflow: hidden;
    }

    .input li {
        width: 300px;
        line-height: 20px;
        font-size: 12px;
        margin: 20px 100px;
    }

    .input .line div {
        margin-left: -100px;
        width: 498px;
        background-color: #CACED0;
        border: 1px solid #CACED0;
        margin-bottom: -10px;
    }

    .input li.normal input {
        width: 235px;
        height: 20px;
    }

    .input li.sex .woman {
        margin-left: 25px;
    }

    input::-webkit-input-placeholder {
        font-size: 11px;
    }

    .login input {
        margin: 0 10px;
        margin-left: 50px;
        width: 80px;
        height: 25px;
        font-size: 12px;
    }

    .background .systemname-wrapper {
        width: 100%;
        height: 100px;
        font-size: 50px;
        background-color: rgba(170, 200, 238, .8);
    }

    .background .systemname-wrapper .systemname {
        width: 1000px;
        line-height: 100px;
        margin: 0 auto;
        color: #36879C;
        font-family: 'YouYuan';
        letter-spacing: 50px;
        font-weight: bold;
        text-align: center;
    }
</style>

<body>
<div class="background">
    <div class="systemname-wrapper">
        <div class="systemname">学生档案管理系统</div>
    </div>

    <div class="content">
        <div class="head clearfix">
            <img src="image/logo.png" alt="">
            <p>学生个人信息</p>
        </div>

        <form action="UserServlet/edit" method="post">
            <input value="${requestScope.user.userName}" type="hidden"  name="oldName" >
            <input value="${requestScope.user.userId}" name="userId" type="hidden">
            <input value="${requestScope.user.userType}" name="userType" type="hidden">
            <ul class="input">
                <li class="normal"><span>用户昵称：</span><input type="text" value="${requestScope.user.userName}" name="userName">
                </li>
                <li class="normal"><span>登录密码：</span><input type="text" value="${requestScope.user.userPassword}" name="userPassword">
                </li>
                <li class="normal"><span>重复密码：</span><input type="text" value="${requestScope.user.userPassword}">
                </li>
                <li class="line">
                    <div></div>
                </li>
                <li class="login"><input type="submit" value="修改" ><input type="reset" value="重置"></li>
            </ul>
        </form>

    </div>
</div>



</body>

</html>