<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2023
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/homeregister">
    <input type="hidden" name="action" value="add">
    <input type="text" placeholder="user name" name="userName">
    <input type="text" placeholder="pass word" name="passWord">
    <button>OK</button>
</form>
</body>
</html>
