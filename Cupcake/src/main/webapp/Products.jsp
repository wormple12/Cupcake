<%-- 
    Document   : Products
    Created on : 05-03-2019, 11:19:05
    Author     : Lukas Bjørnvad
--%>

<%@page import="com.mycompany.cupcake.data.cc_help_classes.Cupcake"%>
<%@page import="com.mycompany.cupcake.logic.ShoppingCart"%>
<%@page import="com.mycompany.cupcake.logic.LineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />

        <form action="Finalization" >
            <%
                ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
                double tprice = 0;
                for (LineItem item : cart.getCart()) {
                    int qty = item.getQty();
                    Cupcake cupcake = item.getCupcake();
                    double price = item.getPrice();

                    out.print("<div align= \"left\">");
                    out.print("<p>Cupcake: " + cupcake.getTopping().getTopping_name() + " frosting with " + cupcake.getBottom().getBottom_Name()
                            + " bottom, Quantity: " + qty + ", Price: <span class=\"price\">" + price + "</span></p>");
                    out.print("<br>");
                    out.print("</div>");
                    tprice += price;
                }
                out.print("<h1>" + "Total Price= " + tprice + "</h1>");
                out.print("<input type='hidden' name=tprice value=" + tprice + ">");
            %>
            <input type='submit' value="Finalize the purchase">

        </form>
    </body>
</html>
