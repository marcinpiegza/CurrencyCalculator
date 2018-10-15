<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ExchangeCurrency</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>


</head>


<body>
<h2>
    <blink>This text blinks! :) </blink>

</h2>

    <span class="blink"> DUPA</span></h1>
<div class="form-group">
    <label for="enteredValue">Money</label>
    <input type="number" class="form-control" id="enteredValue">
</div>

<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Date</label>
    <div class="col-10">
        <input class="form-control" type="date"  id="enteredDate">
    </div>
</div>


<div class="form-group">
    <label for="enteredCurrency">Select currency</label>
    <select class="form-control" id="enteredCurrency">
        <option>GBP</option>
        <option>USD</option>
        <option>EUR</option>
        <option>CNY</option>
    </select>
    <label for="ExampleInputPLN">Wartość w GBP:</label>
    <input type="number" class="form-control" id="ExampleInputGBP" placeholder="GBP" disabled>
</div>


<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Wartosc valuty</label>
    <div class="col-10">
        <input class="form-control" type="number" id="ExampleInputPLN" disabled>
    </div>
</div>



<button type="button" id="Button">Przelicz</button>

<script>

    $('#Button').click(function() {
        //zapytanie ajaxowe
        $.ajax({
            //ta linijka to to co wysyłąmy JQUERT
            type: "GET",
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
            date: JSON.stringify({
                value: $('enteredValue').val(),
                date: $('enteredDate').val(),
                currency: $('enteredCurrency').val()

            }),


            //ta linijka to to co dostajemy w odpowiedzi czyli REST
            success: function (result) {
                console.log(result);
            }

            // error:  function(result){

    })});
</script>
</body>
</html>