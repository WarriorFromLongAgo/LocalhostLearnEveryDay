<%--
  Created by IntelliJ IDEA.
  User: xuegao
  Date: 2019/11/3
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/insert" method="post">
    <input type="text" name="userName" placeholder="userName">
    <input type="text" name="money" placeholder="money">

    <input type="submit" value="提交">
</form>
<br/>

<form action="/user/delete" method="post">
    <input type="text" name="aid" placeholder="aid">

    <input type="submit" value="提交">
</form>
<br/>

<form action="/user/update" method="post">
    <input type="text" name="aid" placeholder="aid">
    <input type="text" name="userName" placeholder="userName">
    <input type="text" name="money" placeholder="money">

    <input type="submit" value="提交">
</form>
<br/>

<form action="/user/findByAid" method="post">
    <input type="text" name="aid">

    <input type="submit" value="提交">
</form>
<br/>
<%--${pageContext.request.contextPath}--%>

<form action="/user/findAll" method="post">
    <input type="submit" value="提交">
</form>
<br/>

<a href="/user/boke">跳转页面</a>

</body>
</html>
