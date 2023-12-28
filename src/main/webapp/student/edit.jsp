
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-9">
            <h2>Edit Hoc Sinh</h2>
            <form method="post">
                <input type="text" name="name" value="${student.name}">
                <input type="text" name="age" value="${student.age}">
                <select name="classId">
                    <c:forEach items="${classes}" var="cl">
                        <option value="${cl.id}">${cl.name}</option>
                    </c:forEach>
                </select>
                <button>EDIT STUDENT</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

