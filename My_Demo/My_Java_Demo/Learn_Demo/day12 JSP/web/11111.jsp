<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/12
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${10 > 3}">
    <h1>10大于3</h1>
</c:if>

<%
    request.setAttribute("week", 1);
%>
<c:choose>
    <c:when test="${week == 1}"> "今天吃 111 饭" </c:when>
    <c:when test="${week == 2}"> "今天吃 222 饭" </c:when>
    <c:when test="${week == 3}"> "今天吃 333 饭" </c:when>
    <c:when test="${week == 4}"> "今天吃 444 饭" </c:when>
    <c:when test="${week == 5}"> "今天吃 555 饭" </c:when>
    <c:otherwise> 随便吃吃 </c:otherwise>
</c:choose>


<%
    Map map = new HashMap();
    map.put("1", "11111");
    map.put("2", "11111");
    map.put("3", "11111");
    map.put("b", "11111");
    request.setAttribute("map11", map);
%>
${"输出map"} <br>
<c:forEach items="${map11}" var="item" varStatus="v">
    <c:out value="${item.key}" />&nbsp;&nbsp;
    <c:out value="${item.value}" /> <br>
</c:forEach>

<%
    List list = new ArrayList();
    list.add(111);
    list.add(222);
    list.add(333);
    list.add(444);
    request.setAttribute("list11",list);
%>
${"输出list"} <br>
<c:forEach items="${list11}" var="item" varStatus="v">
    ${item} |   ${v.index}    |     ${v.count}  <br>
</c:forEach>
<br>
${"输出0-10"} <br>
<c:forEach begin="0" end="10" step="1" var="i">
    ${i}
</c:forEach>


</body>
</html>
