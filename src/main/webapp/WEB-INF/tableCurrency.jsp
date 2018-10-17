<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ppieg
  Date: 10/16/2018
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

    <div id="exchangeDateIda">Kurs na dzień: </div>
    <form action="/" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Waluta</th>
                <th>Sprzedaż</th>
                <th>Kupno</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rates}" var="rate" varStatus="loop">
            <tr>
                <td>${rate.code}}</td>
                <td>${rate.bid}</td>
                <td>${rate.ask}</td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
