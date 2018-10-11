<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="contener">

    <button type="Przelicz" onclick="loadDoc()">Przelicz</button>

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

    <div class="dropdown show">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            currenty
        </a>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <tbody>
            <c:forEach var="exchangeResult" items="${requestScope.books }" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${book.title}</td>
                    <td>${not empty book.borrowerName ? book.borrowerName : '-'}</td>
                    <td><input class="form-check-input" type="radio" name="bookId" value="${book.id}" checked></td>
                </tr>
            </c:forEach>
            </tbody>
        </div>
    </div>


</div>


<script>

    $('#contentInputId').val("content"));

    $('#touchMeId').click(funtion(){
        alert("Przelicz");
    });

    console.log($('#contentInputId').val());



    //zapytanie ajaxowe
    $.ajax({
            //ta linijka to to co wysyłąmy JQUERT
        type: "GET",
        url: "exchange" + enteredValue + "/" + enteredDate,
        //enteredvalue - ile spisujemy hajsu
        //enteredDate - data dla ktorej szukamy
        headers: {
            // mozna to pominac

            //akceptuje jsona
        'Accept':'applucation/json',
            //wysyłam cos w postaci jsona
            'Content-Type': 'applucation/json'
        },
        date:{

        },


            //ta linijka to to co dostajemy w odpowiedzi czyli REST
        success: function(result){
            $('#currencyExchangeInput').val(result.value());
        }
        },



        erroe:  function(result){
        console.log(result);

    }


    )
</script>
</body>
</html>