<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Enter Quantity</title></head>
<body>
    <h2>Enter Quantity</h2>
    <form action="receipt" method="post">
        <input type="hidden" name="productName" value="<%= request.getAttribute("productName") %>">
        <input type="hidden" name="price" value="<%= request.getAttribute("price") %>">

        Quantity: <input type="number" name="quantity"><br><br>
        <input type="submit" value="Generate Receipt">
    </form>
</body>
</html>
