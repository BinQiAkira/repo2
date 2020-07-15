<%--
  Created by IntelliJ IDEA.
  User: KaXi
  Date: 2020/6/19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<html>
<head>
	<title>管理员界面</title>
</head>
<body>
<h1>学生宿舍管理系统</h1>
<table>
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>宿舍号码</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.age}</td>
			<td>${student.room_id}</td>
			<td>
				<a href="/student?method=deleteById&id=${student.id}">删除</a>
				<a href="/student?method=findById&id=${student.id}">修改</a>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="add.jsp">如需要增加学生信息请点此处</a>
</body>
</html>
