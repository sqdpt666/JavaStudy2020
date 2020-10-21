<%--
  Created by IntelliJ IDEA.
  User: 26248
  Date: 2020/9/25
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./fontlibrary/awesome/css/all.css">
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
        height: 300px;
        margin: 0 auto;
        background-color: rgba(243, 245, 243, .85);
        margin-top: 150px;
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
    <div class="background">
        <div class="content">
            <div class="head clearfix">
                <img src="image/logo.png" alt="">
                <p>用户登录</p>
            </div>
            <form action="UserServlet/edit" method="post">
                 <input type="hidden" value="${sessionScope.user.userId}">
                <ul class="input">

                    <li class="normal"><span>修改昵称：</span><input type="text"  name="userName">
                    </li>
                    <li class="normal"><span>修改密码：</span><input type="password" name="userPassword">
                    <li class="line">
                        <div></div>
                    </li>
                    <li class="login"><input type="submit" value="修改"><input type="reset" value="重置"><a href="regist.jsp"><input type="button" value="注册"></a></li>
                </ul>
            </form>

        </div>
    </div>



</body>

</html>
