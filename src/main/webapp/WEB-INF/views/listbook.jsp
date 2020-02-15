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
    <a href="/" class="btn btn-success">HOME PAGE</a>
    <br>
    <br>
    <div class="row mb-3">
        <div class="col-sm-12">

            <c:forEach items="${books}" var="b">
                <div class="jumbotron">
                    <h4>
                            ${b.name}
                    </h4>
                    <p class="lead">
                            ${b.author}
                    </p>
                    <b>
                        Price : ${b.price} $
                    </b>
                    </div>
            </c:forEach>

        </div>
    </div>
</div>
</body>
</html>


