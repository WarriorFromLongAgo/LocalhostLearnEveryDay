<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath}/product/findAll">点击此处的链接，进行跳转到后台管理页面</a>
<a href="${pageContext.request.contextPath}/order/findPage?pageNum=1&pageSize=5">点击此处的链接，进行跳转到后台管理页面,分页管理</a>

</body>
</html>
