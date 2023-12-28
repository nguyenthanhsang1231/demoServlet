<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/26/2023
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
student
<c:forEach items="${std}" var="st">
    <h1>${st.name}, ${st.age}, ${st.clazz.name}</h1>
</c:forEach>
</body>
</html>
</body>
</html>
