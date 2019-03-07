<%-- 
    Document   : AdminPage
    Created on : 06-Mar-2019, 13:04:39
    Author     : Henning
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.data.order_help_classes.Order"%>
<%@page import="com.mycompany.cupcake.data.DBConnector"%>
<!--
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>-->




<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <%
                User user = (User) request.getSession().getAttribute("User");
                String username = user.getUsername();
                CupcakeDAO dao = new CupcakeDAO();
                user = dao.getUser(username);
                String email = user.getEmail();
                Boolean admin = user.getAdmin();

//                out.print("<tr><td>" + dao.getOrder(1) + "</tr></td>");
//                out.print("<tr><td>" + dao.getAllBottoms() + "</tr></td>");
                out.print("<div align= \"right\">");
                out.print("<p>username: " + username + "</p>");
                out.print("<p>email: " + email + "</p>");
                out.print("<p>admin: " + admin + "</p>");
                out.print("<br>");
                out.print("</div>");
            %>
        </form>


    </body>

    <form method="post">
        <table border = "1">
            <tr>
                <td>order_number</td>
                <td>username</td>
            </tr>
            <%
                try {
                    DBConnector connector = new DBConnector();
                    Connection c = connector.getConnection();
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
                    //Order order = (Order) request.getSession().getAttribute("Order");

                    while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt("order_number")%></td>
                <td><%=rs.getString("username")%></td>
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





