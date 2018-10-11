<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>

<body>

<div class="form-group">
    <label for="enteredValue">Money</label>
    <input type="text" class="form-control" id="enteredValue">
</div>

<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Date</label>
    <div class="col-10">
        <input class="form-control" type="date" value="2011-08-19" id="enteredDate">
    </div>
</div>

<div class="form-group row">
    <label for="enteredDate" class="col-2 col-form-label">Wartosc valuty</label>
    <div class="col-10">
        <input class="form-control" type="number" value="2011-08-19" id="ExampleInputPLN">
    </div>
</div>

<div class="form-group">
    <label for="enteredCurrency">Select list:</label>
    <select class="form-control" id="enteredCurrency">
        <option>GBP</option>
        <option>USD</option>
        <option>EUR</option>
        <option>CNY</option>
    </select>
    <label for="ExampleInputPLN">Wartość w GBP:</label>
    <input type="number" class="form-control" id="ExampleInputGBP" placeholder="GBP">
</div>

//design pattern observator - click
<button type="button" id="Button">Przelicz</button>

<script>

    $('#Button').click(function() {
        //zapytanie ajaxowe
        $.ajax({
            //ta linijka to to co wysyłąmy JQUERT
            type: "GET",
            url: "/exchange",
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

    });
    )
</script>
</body>
</html>