<%-- 
    Document   : FailedLogin
    Created on : 04-03-2019, 13:50:35
    Author     : Emil PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Login Failed</title>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />

        <h1>Wrong username or password!</h1>
        <p><a href="/Cupcake/RegistrationNlogin"> Please try again! </a></p>
    </body>
</html>
