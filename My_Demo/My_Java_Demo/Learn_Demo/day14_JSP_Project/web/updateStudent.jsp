<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/15
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="bootstrap-lib/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap-lib/js/jquery.min.js"></script>
    <script src="bootstrap-lib/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateStudentController" method="post">
        <input type="hidden" name="id" value="${studentById.id}">

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" placeholder="请输入姓名"
                   value="${studentById.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${studentById.sex=='男'}">
                <input type="radio" name="sex" value="男" checked />男
                <input type="radio" name="sex" value="女"/>女
                <input type="radio" name="sex" value="未知"/>未知
            </c:if>
            <c:if test="${studentById.sex=='女'}">
                <input type="radio" name="sex" value="男" />男
                <input type="radio" name="sex" value="女" checked />女
                <input type="radio" name="sex" value="未知" />未知
            </c:if>
            <c:if test="${studentById.sex=='未知'}">
                <input type="radio" name="sex" value="男" />男
                <input type="radio" name="sex" value="女" />女
                <input type="radio" name="sex" value="未知" checked />未知
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" value="${studentById.age}"/>
        </div>

        <div class="form-group">
            <label for="birthplace">籍贯：</label>
            <select name="birthplace" class="form-control" id="birthplace">
                <option value="广东">广东</option>
                <option value="广西" selected >广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qqAccount">QQ：</label>
            <input type="text" class="form-control" name="qqAccount" id="qqAccount" placeholder="请输入QQ号码"
                   value="${studentById.qqAccount}"/>
        </div>

        <div class="form-group">
            <label for="mailbox">Email：</label>
            <input type="text" class="form-control" name="mailbox" id="mailbox" placeholder="请输入邮箱地址"
                   value="${studentById.mailbox}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
