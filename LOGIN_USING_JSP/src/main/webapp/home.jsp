<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Home</h2>
    <p>Welcome to the Home Page</p>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
