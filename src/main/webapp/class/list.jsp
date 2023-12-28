<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/25/2023
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
class
<body>
<c:forEach items="${cls}" var="cl">
    <h1>${cl.name}</h1>
</c:forEach>
</body>
</html>
