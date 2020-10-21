<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 26248
  Date: 2020/10/8
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Project05/teacher/TeacherServlet/addStudentClass">
    <li>学生id: <input name="studentId" type="text" readonly="readonly" value="${requestScope.studentId}"> </li>
            <li>要添加到的班级：&nbsp;
                <select name="classId" >
                <c:forEach items="${requestScope.clazzList}" var="clazz">
                    <option  value="${clazz.classId}">${clazz.className}(id=${clazz.classId})</option>
                </c:forEach>
                </select>
            </li>
    <input type="submit" value="添加">
</form>
</body>
</html>
