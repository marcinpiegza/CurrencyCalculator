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
<jsp:include page="WEB-INF/fragments/header.jsp"/>
<div class="container">

    <table class="table-dark table-hover">
        <thead>
        <tr>
            <th>Waluta</th>
            <th>Sprzedaz</th>
            <th>Kupno</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rates}" var="rate" varStatus="loop">
        <tr>
            <td>${rate.code}</td>
            <td>${rate.bid}</td>
            <td>${rate.ask}</td>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</div>
<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>
