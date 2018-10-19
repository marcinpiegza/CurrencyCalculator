<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="WEB-INF/fragments/header.jsp"/>
<div class="btn-group btn-group-lg , jumbotron">
<a href="exchange.jsp">
    <button type="button" class="btn btn-primary" id="exchange">Exchange money</button>
</a>
<a href="tableCurrency.jsp">
    <button type="button" class="btn btn-primary" id="actualRates">Show actual rates</button>
</a>
<a href="tableExchangeHistory.jsp">
    <button type="button" class="btn btn-primary" id="exchangesHistory">Show history of exchanges</button>
</a>
</div>

<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</body>
</html>