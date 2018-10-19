<%--
  Created by IntelliJ IDEA.
  User: ppieg
  Date: 10/19/2018
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FirstPage</title>
</head>
<body>
<div class="btn-group btn-group-lg">
    <jsp:include page="WEB-INF/fragments/header.jsp"/>
    <a href="register.jsp">
        <button type="button" class="btn btn-primary" id="Registration">Registration</button>
    </a>
    <a href="login.jsp">
        <button type="button" class="btn btn-primary" id="Login">Login</button>
    </a>
</div>

<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>
