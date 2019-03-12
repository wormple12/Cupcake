<%-- 
    Document   : FinalizationSuccess
    Created on : Mar 11, 2019, 11:48:14 AM
    Author     : Simon Asholt Norup
--%>

<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Finalization</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />
        
        <% 
            User user = (User) request.getSession().getAttribute("User");
            out.println(
                    "<h1>Thank you for your purchase, " + user.getUsername() + "! </h1>"
            );
        %>
        
        <form action="/Cupcake/c/shopping"><input type=submit value="Home"> </form>
    </body>
</html>
