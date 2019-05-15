<%--
  Created by IntelliJ IDEA.
  User: 29029
  Date: 2019/4/12
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <base href="<%=request.getContextPath() +"/"%>"/>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <link rel="stylesheet" href="js/layui/css/layui.css" media="all">
</head>
<body>
<a href="/Student/Student_Add.jsp">添加用户</a>
<table class="layui-table">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>性别</th>
        <th>老师姓名</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${page.list}" var="student" >
        <tr>
            <th>${student.id}</th>
            <th>${student.stuName}</th>
            <th>${student.password}</th>
            <th>${student.age}</th>
            <th>${student.sex eq 1?'男':'女'}</th>
            <th>${student.teaName}</th>
            <th><a href="/stuController/getByStuId/${student.id}">编辑</a>|
                <a href="javascript:;"  onclick="DelStuId('删除','stuController/doDelete',${student.id})">删除</a></th>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/common/page.jsp"/>
</body>
<script type="text/javascript">
    function DelStuId(path,url,par) {
        var param = new Object();
        param.id=par;
        if(confirm('是否进行'+path+'操作')) {
           $.post(url,param,function (data) {
               if (data.flag){
                   alert(message);
               } else {
                   alert(message);
               }
           });
        }
    }

</script>
</html>
