<%-- 
    Document   : RegisterUser
    Created on : 06-03-2019, 15:21:11
    Author     : Emil PC
--%>

<%@page import="com.mycompany.cupcake.presentation.commands.redirectJSP"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>           
    </head>

    <body>

        <div id="topmenu">
            <select onChange="window.location.href = this.value">   
                <option value = "c/registration"> Create new user </option>
                <option value = "/Cupcake/SessionExit.jsp"> Login </option>
            </select>
        </div>

        <h1> Create new user </h1>
        <form action="/Cupcake/Registration">
            Username: <br> <input type=text name=username style="color: black"> <br> 
            Password: <br> <input type= password name=password style="color: black"> <br> 
            Email: <br> <input type= text name=email style="color: black"> <br>
            <div id="submitbutton1">
                <br> <input type=submit>
            </div>
        </form>
    </body>
</html>