<%-- 
    Document   : Products
    Created on : 05-03-2019, 11:19:05
    Author     : Lukas Bjørnvad
--%>

<%@page import="com.mycompany.cupcake.data.cc_help_classes.ShoppingCart"%>
<%@page import="com.mycompany.cupcake.data.cc_help_classes.LineItem"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.cc_help_classes.Cupcake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Shopping Cart</title>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />

        <form action="/Cupcake/c/finalize" >
            <%
                ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
                User user = (User) request.getSession().getAttribute("User");
                
                for (int i = 0; i < cart.getCart().size(); i++) {
                    LineItem item = cart.getCart().get(i);
                    int qty = item.getQty();
                    Cupcake cupcake = item.getCupcake();
                    double price = item.getPrice();

                    out.print("<div align= \"left\">");
                    out.print("<p>Cupcake: " + cupcake.getTopping().getTopping_name() + " frosting with " + cupcake.getBottom().getBottom_Name()
                            + " bottom, Quantity: " + qty + ", Price: <span class=\"price\">" + price + "</span></p>");

                    out.print("<button type='submit'name=\"remove\" value=" + i + " formaction= \"/Cupcake/c/cart" + "\">" + "Remove</button>");

                    out.print("<br>");
                    out.print("</div>");
                }
                double tprice = cart.getTPrice();
                out.print("<h1>" + "Total Price= " + tprice + "</h1>");
                out.print("<input type='hidden' name=tprice value=" + tprice + ">");

                double balance = (double) request.getAttribute("balance");
                if (tprice < balance) {
                    out.print("<input type='submit' value=\"Finalize the purchase\">");

                } else {
                    out.print("<input type='submit' value=\"Finalize the purchase\" disabled> <br>");
                    out.print("<p style=\"color:red\">Insufficient funds</p>");
                }
            %>
            <input type=submit value="Order more" formaction="/Cupcake/c/possibilities">

        </form>
    </body>
</html>
