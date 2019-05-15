<%--
  Created by IntelliJ IDEA.
  User: 29029
  Date: 2019/5/14
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <base href="<%=request.getContextPath() +"/"%>"/>
    <title>Title</title>
    <link rel="stylesheet" href="js/layui/css/layui.css" media="all">
    <script type="text/javascript" src="js/layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<script type="text/javascript">
    layui.use('form',function(){
        var form = layui.form;
        form.render();
    });
</script>
<body>
<div align="center">
    <form action="" class="layui-form">
        <table class="layui-table">
            <tr>
                <input type="hidden" id="id" name="id" value="${stu.id}" >
                <th colspan="2">
                    修改用户
                </th>
            </tr>
            <tr>
                <th>
                    <span style="color: red">*</span>
                    用户名
                </th>
                <td><input class="layui-input" type="text" name="stuName" id="stuName" value="${stu.stuName}"></td>
            </tr>
            <tr>
                <th>
                    <span style="color: red">*</span>
                    密码
                </th>
                <td><input class="layui-input" type="password" name="password" id="password" value="${stu.password}"></td>
            </tr>
            <tr>
                <th>
                    <span style="color: red">*</span>
                    年龄
                </th>
                <td><input class="layui-input" type="text" name="age" id="age" value="${stu.age}"></td>
            </tr>
            <tr>
                <th>
                    <span style="color: red">*</span>
                    性别
                </th>
                <td class="layui-input-block">
                        <input type="radio" name="sex" value="1" ${stu.sex eq 1 ?"checked":""} title="男" >
                        <input type="radio" name="sex" value="0" ${stu.sex eq 0 ?"checked":""} title="女">
                </td>
            </tr>
            <tr>
                <th>
                    <span style="color: red">*</span>
                    所属老师：
                </th>
                <td class="layui-input-inline">
                        <select name="teaId" lay-verify="required" lay-filter="achoo">
                            <c:forEach items="${teacher}" var="tea">
                                <option ${tea.id eq stu.teaId?"selected=''":""} value="${tea.id}">${tea.teaName}</option>
                            </c:forEach>
                        </select>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="button" class="layui-btn" onclick="Stu_Update()" value="提交">
                </th>
            </tr>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">
    function Stu_Update() {
        var param = new Object();
        param.id = $('#id').val();
        param.stuName = $('#stuName').val();
        param.age = $('#age').val();
        param.sex = $('input:radio:checked').val();
        param.teaId = $('select option:selected').val();
        if (pd()){

        }
        debugger
    }
    function pd() {
        var id = $('#id').val();
        var stuName = $('#stuName').val();
        var age = $('#age').val();
        var sex = $('input:radio:checked').val();
        var teaId = $('select option:selected').val();
        if (id =="" || stuName == "" || age == "" || sex=="" || teaId == ""){
            alert('星号标记项不能为空');
            return false;
        }
        return true;
    }
</script>
</html>
