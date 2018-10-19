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

    <button type="submit" class="btn btn-primary" id="Login">Login</button>

    <script>
        $('#Login').click(function () {
            //zapytanie ajaxowe
            $.ajax({
                //ta linijka to to co wysyłąmy JQUERT
                type: "POST",
                url: "/exchange/",  // sprawdz
                //enteredvalue - ile spisujemy hajsu
                //enteredDate - data dla ktorej szukamy
                headers: {
                    // mozna to pominac

                    //akceptuje jsona
                    'Accept': 'application/json',
                    //wysyłam cos w postaci jsona
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify({
                    Username: $('#Username').val(),
                    Password: $('#Password').val(),

                }),


                //ta linijka to to co dostajemy w odpowiedzi czyli REST
                success: function (result) {
                    console.log(result);
                    // przy sukcecie ma przejsc do nastepnei index.jsp

                },
                error: function (result) {
                    console.log(result);
                    alert(result.responseJSON.error);
                    //przy błedzie ma wyswietlic komunikat
                }

            })
        });
    </script>


    </form>
</body>
</html>