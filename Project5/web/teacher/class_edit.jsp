<%--
  Created by IntelliJ IDEA.
  User: 26248
  Date: 2020/9/27
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Project05/teacher/TeacherServlet/editClass">
    <input type="hidden" name="classId" value="${requestScope.clazz.classId}">
    <input type="hidden" name="uid" value="${requestScope.user.userId}">
    <ul class="input">
        <li class="normal"><span>课程名称：</span><input type="text" value="${requestScope.clazz.className}" name="className">
        </li>
        <li class="normal"><span>老师Id：</span><input type="text" readonly="readonly" value="${requestScope.clazz.teacherId}" name="teacherId">
        </li>
        <li class="login"><input type="submit" value="修改"><input type="reset" value="重置"></li>
    </ul>
</form>
</body>
</html>
