<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/26/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/students?action=create">Add Student</a>
                        </li>
                        <button><a href="/home?action=sortage">Sort by Age</a></button>
                        <button><a href="/home?action=sortname">Sort by Name</a></button>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <form method="get" class = "search-bar">
                        <input type="text" id="searchName" name="search">
                        <input type="submit" value="Tìm kiếm">
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-3 text-center">
            <h2>Danh Sach lop</h2>
            <c:forEach items="${cls}" var="cl">
                <h5><a href="">${cl.name}</a></h5>
            </c:forEach>
        </div>
        <div class="col-9">
            <h2>Danh Sach Hoc Sinh</h2>
            <table class="table table-striped mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">AGE</th>
                    <th scope="col">CLASS NAME</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${std}" var="st">
                    <tr>
                        <th scope="row">${st.id}</th>
                        <td>${st.name}</td>
                        <td>${st.age}</td>
                        <td>@${st.clazz.name}</td>
                        <td>
                            <button><a href="/students?action=delete&id=${st.id}">DELETE</a></button>
                        </td>
                        <td>
                            <button><a href="/students?action=edit&id=${st.id}">EDIT</a></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

</body>
</html>
