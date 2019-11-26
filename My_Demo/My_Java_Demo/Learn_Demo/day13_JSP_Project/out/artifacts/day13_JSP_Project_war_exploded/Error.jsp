<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/13
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>服务器正忙。。。。。。。。。。。。</h1>
<%
    out.print(exception.getMessage());
%>
</body>
</html>
