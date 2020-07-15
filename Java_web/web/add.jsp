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
<div>
    <p>创建学生信息</p>
</div>
<form action="/student" method="post">
    username：<input type="text" name="username"/><br/>
    password：<input type="password" name="password"><br/>
    姓名: <input type="text" name="name"/><br/>
    年龄: <input type="text" name="age"/><br/>
    宿舍号:<input type="number" name="room_id"/><br/>
    <input  type="hidden" name="method" value="add"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
