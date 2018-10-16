<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>ExchangeCurrency</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <script src="webjars/jquery/3.0.0/jquery.min.js"></script>


</head>


<body>


<style>

    body {
        background-color: darkgrey;
    }

    h1 {
        color: tomato;
    }

</style>


<h1 size="100"> EXCHANGE CANTOR</h1>
<div class="form-group">
    <label for="enteredValue">Money</label>
    <input type="number" class="form-control" id="enteredValue" placeholder="PLN">
</div>

<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Date</label>
    <div class="col-10">
        <input class="form-control" type="date" id="enteredDate">
    </div>
</div>


<div class="form-group">
    <label for="enteredCurrency">Select currency</label>
    <select class="form-control" id="enteredCurrency">
        <option>GBP</option>
        <option>USD</option>
        <c:forEach items="${currencies}" var="currency">
            <option>${currency.code}</option>
        </c:forEach>
    </select>
    <label for="ExampleOutput">Kurs na dany dzien:</label>
    <input type="number" class="form-control" id="EndingValue" disabled>
</div>


<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Wartosc po przewalutowaniu: </label>
    <div class="col-10">
        <input class="form-control" type="text" id="ExampleOutput" disabled>
    </div>
</div>


<button type="button" id="Button">Przelicz</button>

<script>
     var selectedCurrency = $('#ExampleOutput').val($('#enteredCurrency').val());
    $('#enteredCurrency').click(function(){
       selectedCurrency;
    });

    $('#Button').click(function () {
        //zapytanie ajaxowe
        $.ajax({
            //ta linijka to to co wysyłąmy JQUERT
            type: "POST",
            url: "/exchange/",
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
                value: $('#enteredValue').val(),
                date: $('#enteredDate').val(),
                currency: $('#enteredCurrency').val()

            }),


            //ta linijka to to co dostajemy w odpowiedzi czyli REST
            success: function (result) {
                console.log(result);

                $('#EndingValue').val(result.rate);
                $('#ExampleOutput').val(result.money + ' ' + $('#enteredCurrency').val())

            },
            error: function (result) {
                console.log(result);
                alert(result.responseJSON.error);
            }
            // error:  function(result){

        })
    });
</script>
<div class="container">
    <form action="/" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Waluta</th>
                <th>Sredni kurs</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Currency}" var="currency" varStatus="loop">
            <tr>
                <td>${currency.code}}</td>
                <td>${currency.rate}</td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>