<%-- 
    Document   : CupcakeAdded
    Created on : Mar 12, 2019, 1:47:53 PM
    Author     : Simon Asholt Norup
--%>

<%@page import="com.mycompany.cupcake.data.cc_help_classes.Cupcake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcake added to cart</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />
        
        <%
            Cupcake cupcake = (Cupcake)request.getAttribute("Cupcake");
            int qty = Integer.parseInt(request.getParameter("quantity"));
            
            out.println("<h1>Adding: " + qty + " " + cupcake.getTopping().getTopping_name() + " cupcakes with " + cupcake.getBottom().getBottom_Name() + " bottom" + "</h1>");

            out.println("<form  action=" + "/Cupcake/c/cart" + "><input value=\"Go to Checkout\" type=submit>"
                + "<input type=submit value=\"Order more\" formaction=/Cupcake/c/possibilities>"
                + "</form>");
        %>
    </body>
</html>
