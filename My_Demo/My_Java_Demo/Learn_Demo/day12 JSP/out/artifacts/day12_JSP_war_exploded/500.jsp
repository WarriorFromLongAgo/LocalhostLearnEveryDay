<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器正忙..................</h1>
<%
    String message = exception.getMessage();
    out.print(message);
    StackTraceElement[] stackTrace = exception.getStackTrace();



%>
</body>
</html>
