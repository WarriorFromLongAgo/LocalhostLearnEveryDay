<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/13
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-lib/css/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap-lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap-lib/js/bootstrap.js"></script>


    <script>
        function refreshCode() {
            var checkCode = document.getElementById("checkCode");
            checkCode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();

        }

        // window.onload = function () {
        //     document.getElementById("form").onsubmit = function () {
        //
        //     }
        //
        //
        //     function checkUserName() {
        //         var userName = document.getElementById("userName").value;
        //         for (var i = 0; i < userName.length; i++) {
        //             if()
        //         }
        //     }
        // }
        // window.onload = function () {
        //     var changeCheckcode = document.getElementById("changeCheckcode");
        //     changeCheckcode.onclick = function () {
        //         changeCheckcode.src = "/day13_JSP_Project_war_exploded/checkCodeServlet?" + new Date().getTime();
        //     }
        // }
    </script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/loginController" method="post" id="form">
        <div class="form-group">
            <label for="userName">用户名：</label>
            <input type="text" name="userName" class="form-control" id="userName" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="passWord">密码：</label>
            <input type="password" name="passWord" class="form-control" id="passWord" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="checkCode">验证码：</label>
            <input type="text" name="frontEndCheckCode" class="form-control" placeholder="请输入验证码"
                   style="width: 120px;"/>
            <a href="javascript:refreshCode()">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="checkCode"/>
            </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <c:if test="${errorInfo!=null}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span></button>
            <strong>${errorInfo}</strong>
        </div>
    </c:if>

</div>

<%--<h1 align="center">登录界面</h1>--%>

<%--<form action="loginController" method="post" style="text-align: center">--%>
<%--    <img src="/day13_JSP_Project_war_exploded/checkCodeServlet" id="changeCheckcode" title="看不清点击刷新">--%>
<%--    <br>--%>
<%--    验证码：<input type="text" name="frontEndCheckCode" placeholder="不区分大小写">--%>
<%--    <br>--%>
<%--    <input type="submit" value="登录">--%>
<%--</form>--%>

</body>
</html>
