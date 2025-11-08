<%@ include file="manu.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Amount</title>
</head>
<body>
    <center>
        <form action="amount" method="post">
            <label>Sum
                <input type="number" name="sum" min="0" max="10000000" value="0">
            </label>
            <button type="submit">DONATE</button>
        </form>
    </center>
</body>
</html>
