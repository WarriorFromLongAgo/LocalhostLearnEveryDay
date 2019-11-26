<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.feijm.model.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/12
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>projectOne</title>
</head>
<body>
<%
    List<User> listUser = new ArrayList<>();
    listUser.add(new User("10000", "11111", 21, new Date(11)));
    listUser.add(new User("20000", "22222", 22, new Date(2222)));
    listUser.add(new User("30000", "33333", 23, new Date(333333)));
    listUser.add(new User("40000", "44444", 24, new Date(44444444)));
    for (User user : listUser) {
        user.changeBirthday(user.getBirthday());
    }

    request.setAttribute("listStr", listUser);
%>

<table border="1px" style="text-align: center;" width="500px" cellspacing="0px" align="center">
    <th>编号</th>
    <th>账号</th>
    <th>密码</th>
    <th>年龄</th>
    <th>日期</th>
    <c:forEach items="${listStr}" var="user" varStatus="v">
        <c:if test="${v.count%2==0}">
            <tr bgcolor="#7fffd4">
                <td>${v.count}</td>
                <td>${user.userName}</td>
                <td>${user.passWord}</td>
                <td>${user.age}</td>
                <td>${user.changeBirthday(user.birthday)}</td>
            </tr>
        </c:if>
        <c:if test="${v.count%2==1}">
            <tr bgcolor="#7fff00">
                <td>${v.count}</td>
                <td>${user.userName}</td>
                <td>${user.passWord}</td>
                <td>${user.age}</td>
                <td>${user.changeBirthday(user.birthday)}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>

</body>
</html>
