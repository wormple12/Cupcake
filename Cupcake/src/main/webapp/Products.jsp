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
    </head>
    <body>
        <form>
            <%
            ShoppingCart cart = (ShoppingCart)  request.getSession().getAttribute("ShoppingCart");
            double tprice=0;
        for (LineItem item : cart.getCart() )
        {
            int qty = item.getQty();
            Cupcake cupcake = item.getCupcake();
             double price = item.getPrice();
            
            out.print("<div>");
            out.print("<p>Cupcake: " + cupcake.toString() +", Quantity: "+qty+ "</p>");
            out.print("<br>");
            out.print("</div>");
            tprice = tprice +price;
        }    out.print("<h1>"+"Total Price= "+tprice+"</h1>");
            %>
            <input type='submit' value="Finalize the purchase">
        </form>
    </body>
</html>
