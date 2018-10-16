<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    body{
       background-color: darkgrey ;
    }

</style>





    <span class="blink"> EXCHANGE CANTOR</span></h1>
<div class="form-group">
    <label for="enteredValue">Money</label>
    <input type="number" class="form-control" id="enteredValue">
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
        <c:forEach items="${sorts}" var="item">
            Try: ${item}<br>
        </c:forEach>

        <option>GBP</option>
        <option>USD</option>
        <option>EUR</option>
        <option>CNY</option>
    </select>
    <label for="ExampleInputPLN">Kurs na dany dzien:</label>
    <input type="number" class="form-control" id="EndingValue" placeholder="GBP" disabled>
</div>


<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Wartosc po przewalutowaniu</label>
    <div class="col-10">
        <input class="form-control" type="number" id="ExampleInputPLN" disabled>
    </div>
</div>


<button type="button" id="Button">Przelicz</button>

<script>

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

                     $('#EndingValue').val(result.rate)
                    $('#ExampleInputPLN').val(result.money)

            },
            error: function(result){
                alert(result);
            }
            // error:  function(result){

        })
    });
</script>
</body>
</html>