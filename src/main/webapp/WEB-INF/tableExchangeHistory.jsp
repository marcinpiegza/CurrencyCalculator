<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>id</th>
            <th>value</th>
            <th>currency</th>
            <th>date</th>
            <th>rate</th>
            <th>exchangeValue</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${history}" var="history" varStatus="loop">
        <tr>
            <td>${history.id}}</td>
            <td>${history.value}}</td>
            <td>${history.currency}}</td>
            <td>${history.date}}</td>
            <td>${history.rate}}</td>
            <td>${history.exchangeValue}}</td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</div>

</body>
</html>
