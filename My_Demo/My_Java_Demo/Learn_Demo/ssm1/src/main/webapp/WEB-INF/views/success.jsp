<%--
  Created by IntelliJ IDEA.
  User: xuegao
  Date: 2019/10/27
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
success

${accountList}

<c:forEach items="${accountList}" var="account">
    ${account.userName}
</c:forEach>

</body>
</html>
