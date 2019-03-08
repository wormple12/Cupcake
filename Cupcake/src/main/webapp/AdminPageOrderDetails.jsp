<%-- 
    Document   : AdminPageDetails
    Created on : 07-Mar-2019, 21:21:22
    Author     : Henning
--%>

<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.data.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>    
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />

        <jsp:include page="UserInfoBox.jsp" />
        
        <%
            User user = (User) request.getSession().getAttribute("User");
            String username = user.getUsername();
        %>

    </body>

    <form method="post">
        <table border = "1">
            <tr>
                <td>order_number</td>
                <td>topping id</td>
                <td>bottom id</td>
                <td>quantity id</td>
            </tr>
            <%
                try {
                    DBConnector connector = new DBConnector();
                    Connection c = connector.getConnection();
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM ordered_cupcakes WHERE order_number=" + request.getParameter("ordernumber") + ";");
                    //Order order = (Order) request.getSession().getAttribute("Order");

                    while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt("order_number")%></td>
                <td><%=rs.getInt("topping_id")%></td>
                <td><%=rs.getInt("bottom_id")%></td>
                <td><%=rs.getInt("amount")%></td>

            </tr>
            <%
                }
            %>
        </table>
        <%
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        %>
    </form>
</html>


