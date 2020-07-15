<%--
  Created by IntelliJ IDEA.
  User: KaXi
  Date: 2020/6/20
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student" method="post">
    编号：<input type="text" name="id" value="${student.id}" readonly/><br/>
    姓名: <input type="text" value="${student.name}" name="name"/><br/>
    年龄: <input type="number" value="${student.age}" name="age" readonly/><br/>
    宿舍号:<input type="number" value="${student.room_id}" name="room_id"/><br/>
    <input type="hidden" name="method" value="update"/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
