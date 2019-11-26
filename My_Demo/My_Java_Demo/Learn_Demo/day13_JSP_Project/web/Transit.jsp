<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/13
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transit</title>
</head>
<body>
<h1 align="center">${userAccount.userName}，欢迎您</h1>
<h1 align="center">功能中转处</h1>
<%--<a href="${pageContext.request.contextPath}/findAllController">显示所有的学生信息</a>--%>
<a href="${pageContext.request.contextPath}/pageAllController">显示所有的学生信息</a>
</body>
</html>
