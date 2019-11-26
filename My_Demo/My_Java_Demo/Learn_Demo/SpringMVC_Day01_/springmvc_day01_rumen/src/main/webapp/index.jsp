<%--
  Created by IntelliJ IDEA.
  User: xuegao
  Date: 2019/10/23
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>入门程序</h1>

<<a href="/hello">12112</a>

<a href="/testPathVariable/100">testPathVariable</a>

<form action="" method="post">
    <input type="text" name="username"/>
    <<input type="hidden" name="_method" value="PUT"><%--id可以写多种--%>
    <<input type="submit" value="提交">
</form>

</body>
</html>
