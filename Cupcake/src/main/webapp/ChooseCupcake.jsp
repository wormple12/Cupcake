<%-- 
    Document   : ChooseCupcake
    Created on : Mar 11, 2019, 2:58:17 PM
    Author     : Simon Asholt Norup
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.cupcake.data.cc_help_classes.Bottom"%>
<%@page import="com.mycompany.cupcake.data.cc_help_classes.Topping"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcake Menu</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />

        <form action="/Cupcake/c/addtocart" method = POST>
            <select name = top><!--Toppings:-->
                <%
                    ArrayList<Topping> toppings = (ArrayList<Topping>) request.getAttribute("toppings");
                    for (Topping topping : toppings) {
                        out.println("<option value =" + topping.getTopping_id() + "> " + topping.getTopping_name() + ", " + topping.getPrice() + ",- DKK</option>");
                    }
                %>
            </select>
            <select name = bottom><!--Bottoms:-->
                <%
                    ArrayList<Bottom> bottoms = (ArrayList<Bottom>) request.getAttribute("bottoms");
                    for (Bottom bottom : bottoms) {
                        out.println("<option value=\"" + bottom.getBottom_id() + "\">" + bottom.getBottom_Name() + ", " + bottom.getPrice() + ",- DKK</option>");
                    }
                %>
            </select>
            <input name="quantity">Quantity
            <input type= submit>
            <p><a href="shopping"> Go back </a></p>
        </form>    
    </body>
</html>
