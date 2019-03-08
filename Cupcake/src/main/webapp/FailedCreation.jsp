<%-- 
    Document   : FailedCreation
    Created on : 04-03-2019, 14:54:11
    Author     : Emil PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css">
        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
         <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/Cupcake/c/shopping">Cupcakes</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/Cupcake/c/shopping">Home</a></li>
                    <li><a href="/Cupcake/c/possibilities">Menu</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/Cupcake/CustomerPage"><span class="glyphicon glyphicon-user"></span> Customer Page</a></li>
                    <li><a href="/Cupcake/SessionExit.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </div>
        </nav>
        <h1>User creation has failed!</h1>
        <p> Maybe name or email has already been taken.. </p>
        <p><a href="/Cupcake/RegistrationNlogin"> Go back </a></p>
    </body>
</html>
