<%--
  Created by IntelliJ IDEA.
  User: 26248
  Date: 2020/9/29
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Project05/teacher/TeacherServlet/addClass">

    <ul class="input">
        <li class="normal"><span>课程名称：</span><input type="text"  name="className">s
        </li>
        <li class="normal"><span>老师Id：</span><input type="text"  value="${requestScope.teacher.teacherId}" readonly="readonly" name="teacherId">
        </li>
        <li class="login"><input type="submit" value="修改"><input type="reset" value="重置"></li>
    </ul>
</form>
</body>
</html>
