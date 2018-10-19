<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Table rows%cols</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
//wysyłamy postem ale spring odbierze do postem i sam to zrobi
<jsp:include page="WEB-INF/fragments/header.jsp"/>

<form action="/login" method="post">

    <div class="form-group">
        <label for="exampleInputUsername1">Username</label>
        <input type="text" class="form-control" id="exampleInputUsername1" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary" id="Login">Login</button>
</form>
<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>