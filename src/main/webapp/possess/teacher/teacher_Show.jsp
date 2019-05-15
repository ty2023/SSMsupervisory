<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<html>
<head>
    <base href="<%=request.getContextPath() +"/"%>"/>
    <title>Title</title>
    <link rel="stylesheet" href="js/layui/css/layui.css" media="all">
</head>
<body>
<a href="/Student/Student_Add.jsp">添加用户</a>
<table class="layui-table">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>入职时间</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${page.list}" var="teacher" >
        <tr>
            <th>${teacher.id}</th>
            <th>${teacher.teaName}</th>
            <th>${teacher.age}</th>
            <th><fm:formatDate value="${teacher.createTime}" pattern="yyyy-MM-dd"/></th>
            <th>${teacher.sex eq 1?'男':'女'}</th>
            <th><a href="#">编辑</a>|<a href="#">删除</a></th>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/common/page.jsp"/>
</body>
</html>
