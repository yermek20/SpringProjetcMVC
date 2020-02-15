<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 13.02.2020
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>
<div class="container mt-5">
    <a href="/listbook" class="btn btn-success">LIST BOOKS</a>
    <a href="/addbook" class="btn btn-success">ADD BOOKS</a>
    <div class="row mb-3">
        <div class="col-sm-12">
            <form action="/search" method="post">

                <div class="form-group">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control" name = "name">
                </div>

                <div class="form-group">
                    <button class="btn btn-success">SEARCH BOOK</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>

