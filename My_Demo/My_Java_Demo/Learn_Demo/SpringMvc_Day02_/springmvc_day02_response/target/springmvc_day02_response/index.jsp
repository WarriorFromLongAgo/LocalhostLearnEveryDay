<%--
  Created by IntelliJ IDEA.
  User: xuegao
  Date: 2019/10/26
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.js"></script>

    <script>
        $(function () {

            $("input#button1").click(function () {
                alert("11111");
            });

            $("button#button2").click(function () {
                alert("2222222");
                $.ajax({
                    // 发送到服务器的，url
                    url: "/testAjax2",
                    // 发送数据到服务器的格式
                    contentType: "application/json;charset=UTF-8",
                    data: '{"userName":"hehe", "passWord":"123"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // 处理服务器返回的数据
                        alert(data);
                        alert(data[0].userName);
                        alert(data[0].passWord);

                    }
                });
            })
        });

    </script>
</head>
<body>

<a href="/testString">点击跳转 默认页面</a>
<a href="/testString2">点击跳转 会显示数据</a>


<br/>

<a href="/textVoid"> textVoid request.getRequestDispatcher </a>
<a href="/textVoid2"> textVoid2 response.sendRedirect </a>

<br/>
<p>1111111111111111</p>
<a href="/textModelAndView">textModelAndView</a>

<br/>
<p>1111111111111111</p>
<a href="/testForwardOrRedirect">testForwardOrRedirect</a>

<br/>
<p>1111111111111111</p>
<a href="/testRedirect">testRedirect</a>

<br/>

<input type="button" value="点击提交" id="button1">
<button id="button2">点击提交2</button>
</body>
</html>
