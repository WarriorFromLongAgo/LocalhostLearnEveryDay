<%@ page import="java.util.List" %>
<%@ page import="com.feijm.model.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: biantai
  Date: 2019/9/13
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>display all</title>

    <!-- Bootstrap -->
    <link href="bootstrap-lib/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--    &lt;!&ndash;[if lt IE 9]>-->
    <!--    &lt;!&ndash;<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>&ndash;&gt;-->
    <!--    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>&ndash;&gt;-->
    <!-- [endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="bootstrap-lib/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="bootstrap-lib/js/bootstrap.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function deleteStudent(id) {
            if (confirm("您确定要删除吗")) {
                location.href = "${pageContext.request.contextPath}/deleteController?id=" + id;
            }
        }

        window.onload = function () {
            var selectAll = document.getElementById("selectAll");
            selectAll.onclick = function () {
                var selectNameArr = document.getElementsByName("tab");
                for (var i = 0; i < selectNameArr.length; i++) {
                    selectNameArr[i].checked = true;
                }
            };

            var unSelectAll = document.getElementById("unSelectAll");
            unSelectAll.onclick = function () {

                var unSelectAllNameArr = document.getElementsByName("tab");
                for (var i = 0; i < unSelectAllNameArr.length; i++) {
                    unSelectAllNameArr[i].checked = false;
                }
            };

            var deleteStudent = document.getElementById("deleteStudent");
            deleteStudent.onclick = function () {
                if (confirm("您确定要删除吗？")) {
                    var deleteFlag = false;
                    var unSelectAllNameArr = document.getElementsByName("tab");
                    for (var i = 0; i < unSelectAllNameArr.length; i++) {
                        // 有一个是选中的
                        if (unSelectAllNameArr[i].checked) {
                            deleteFlag = true;
                            break;
                        }
                    }

                    if (deleteFlag) {
                        alert(123123213123);
                        document.getElementById("seleteForm").submit();
                    }

                }
            }

        }
    </script>
</head>
<body>

<div class="container">

    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin-bottom: 5px">
        <a href="addStudent.jsp">
            <button type="button" class="btn btn-primary">添加学生</button>
        </a>

        <button type="button" class="btn btn-primary" href="javascript:void(0);" id="deleteStudent">删除选中学生</button>
    </div>

    <form action="${pageContext.request.contextPath}/deleteSeleteController" method="post" id="seleteForm">
        <table border="1px" class="table table-bordered table-hover">
            <tr class="success">
                <th>
                    <input type="button" id="selectAll" value="全选">
                    <input type="button" id="unSelectAll" value="全不选">
                </th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${studentList}" var="student" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="tab" value="${student.id}"></td>
                    <td>${s.count}</td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.age}</td>
                    <td>${student.birthplace}</td>
                    <td>${student.qqAccount}</td>
                    <td>${student.mailbox}</td>
                    <td>
                        <button type="button" class="btn btn-default btn-sm">
                            <a href="${pageContext.request.contextPath}/findStudentServlet?id=${student.id}">修改</a>
                        </button>
                        <button type="button" class="btn btn-default btn-sm">
                            <a href="javascript:deleteStudent(${student.id});">删除</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>

            <%--        <tr style="text-align: center" align="center">--%>
            <%--            <td colspan="8">--%>
            <%--                <button id="addStudent">添加联系人</button>--%>
            <%--            </td>--%>
            <%--        </tr>--%>
        </table>
    </form>
</div>

</body>
</html>
