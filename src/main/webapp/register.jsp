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
<form action="/mainRegister.jsp" method="POST">


    <div class="form-group">
        <label for="exampleInputUsername1">Username</label>
        <input type="text" class="form-control" id="exampleInputUsername1" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="exampleInputGender1">Gender</label>
        <input type="radio button" class="form-control" id="exampleInputGender1" name="gender" placeholder="Gender">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPhone1">Phone</label>
        <input type="Numer" class="form-control" id="exampleInputPhone1" name="phone" placeholder="Phone">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>