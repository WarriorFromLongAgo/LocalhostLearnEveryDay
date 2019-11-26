<%@ page import="com.feijm.model.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/12
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在java脚本中添加属性--%>
<%

    request.setAttribute("first", "121");
    session.setAttribute("userName", "费");
%>
<%--通过EL表达式，获取请求中的数据--%>
<%= request.getAttribute("first") %>
${requestScope.first}
${first}
${sessionScope.userName}
${userName}
<br>
<%--获取对象的属性，以及集合map中的数据--%>
<%
    User user = new User("feijm费", "123", 20);
    user.setBirthday(new Date());
    request.setAttribute("user", user);

%>
${user} <br>
${user.userName} <br>
${user.changeBirthday(user.birthday)} <br>

<%
    List<String> listStr = new LinkedList<>();
    listStr.add("11111");
    listStr.add("22222");
    listStr.add("33333");
    listStr.add("44444");

    request.setAttribute("listStr", listStr);
%>
${listStr[1]} <br>
<%--中括号取值，不会报错indexoutof--%>
${listStr[20]} <br>
<%--但是get会报错信息--%>
<%--${listStr.stream().forEach(string ->{--%>
<%--        System.out.println(string)--%>
<%--        });}--%>

<%
    Map map = new HashMap();
    map.put("1", "11111");
    map.put("2", "11111");
    map.put("3", "11111");
    map.put("b", "11111");
    request.setAttribute("map", map);
%>
${"输出输出"} <br>
${map["1"]} <br>
<%--key不可以为数字--%>
${map.b}
<%--${map.2}--%>

<c:forEach items="${map}" var="item">
    key:<c:out value="${item.key}" /> &nbsp;
    value:<c:out value="${item.value}" /> <br>
</c:forEach>

</body>
</html>
