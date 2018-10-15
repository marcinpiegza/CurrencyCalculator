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
        background-image: url("data:image/jpeg;base64,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");
    }

</style>

<h2>
    <blink>This text blinks! :)</blink>

</h2>

<span class="blink"> DUPA</span></h1>
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
    <label for="ExampleInputPLN">Wartość w GBP:</label>
    <input type="number" class="form-control" id="EndingValue" placeholder="GBP" disabled>
</div>


<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Wartosc valuty</label>
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

                     $('#EndingValue').val(result.money)
                    $('#ExampleInputPLN').val(result.rate)

            },
            error: function (result) {
                console.log(result);
            }
            // error:  function(result){

        })
    });
</script>
</body>
</html>