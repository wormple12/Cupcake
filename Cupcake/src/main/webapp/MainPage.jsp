<%-- 
    Document   : MainPage
    Created on : Mar 12, 2019, 3:02:32 PM
    Author     : Simon Asholt Norup
--%>

<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css.css">
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>

    <body>
        <jsp:include page="siteheader.jsp" />

        <%
            User user = (User) request.getSession().getAttribute("User");
            String username = user.getUsername();
            Boolean admin = user.getAdmin();
            double balance = (double) request.getAttribute("balance");

            out.println("<h1>Welcome back    : " + username + "</h1>");
            out.println("<h2>Current balance : " + balance + "</h2>");
        %>

        <p><a href="/Cupcake/c/possibilities"> Check out the menu! </a></p>
        <p><a href="/Cupcake/c/showuser"> Customer page </a></p>
        <%
            if (admin == true) {
                out.println("<p><a href=\"/Cupcake/AdminPage.jsp\"> Admin </a></p>");
            }
        %>
        <p><a href="/Cupcake/SessionExit.jsp"> Logout</a></p>

    </body>
</html>
