<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/11
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script>
        window.onload = function () {
            var changeCheckcode = document.getElementById("changeCheckcode");
            changeCheckcode.onclick = function () {
                changeCheckcode.src = "/sessionDemo/checkCodeServlet?" + new Date().getTime();
            }
        }
    </script>
</head>
<body>

<form action="loginSessionDemo" method="post" style="text-align: center">
    <label>账&nbsp&nbsp&nbsp号：<input type="text" name="userName" placeholder="请输入账号"></label>
    <br>
    <label>密&nbsp&nbsp&nbsp码：<input type="password" name="passWord" placeholder="请输入密码"></label>
    <br>
    <img src="/sessionDemo/checkCodeServlet" id="changeCheckcode">点击图片更换验证码
    <br>
    验证码：<input type="text" name="frontEndCheckCode" placeholder="不区分大小写">

</form>
</body>
</html>
