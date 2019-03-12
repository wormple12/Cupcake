<%-- 
    Document   : UserInfoBox
    Created on : Mar 8, 2019, 11:50:33 AM
    Author     : Simon Asholt Norup
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.logic.DBConnector"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info Box</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <form id = topmenu>
            <%
                User user = (User) request.getSession().getAttribute("User");
                String username = user.getUsername();
                String email = user.getEmail();
                Boolean admin = user.getAdmin();

                out.print("<div align= \"right\">");
                out.print("<p>username: " + username + "</p>");
                out.print("<p>email: " + email + "</p>");
                //out.print("<p>admin: " + admin + "</p>");
                out.print("<br>");
                out.print("</div>");
            %>
        </form>
    </body>
</html>
