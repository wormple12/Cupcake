<%-- 
    Document   : invoiceDetails
    Created on : 05-Mar-2019, 20:14:04
    Author     : Henning
--%>

<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mycompany.cupcake.data.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
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
                User user = (User) request.getSession().getAttribute("User");
                String username = user.getUsername();
                CupcakeDAO dao = new CupcakeDAO();
                user = dao.getUser(username);
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

    <form method="post">
        <table border = "1">
            <tr>
                <td>idlineitems</td>
                <td>cupcake</td>
                <td>price</td>
                <td>quantity</td>
                <td>cartid</td>
                <td>lineid</td>
                <td>idshoppingcart</td>
                <td>customer</td>
            </tr>
            <%
                try {
                    DBConnector connector = new DBConnector();
                    Connection c = connector.getConnection();
                    Statement stmt = c.createStatement();
                    // ResultSet rs = stmt.executeQuery("SELECT * FROM shoppingcart WHERE customer = '" + username + "';");
                    ResultSet rs = stmt.executeQuery("SELECT * FROM lineitems ls LEFT JOIN has_lineitem hs ON ls.idlineitems = hs.lineid LEFT JOIN shoppingcart sc ON sc.idshoppingcart = hs.cartid WHERE sc.idshoppingcart ="+ request.getParameter("idshoppingcart") + ";");

                    //Order order = (Order) request.getSession().getAttribute("Order");
                    while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt("idlineitems")%></td>
                <td><%=rs.getString("cupcake")%></td>
                <td><%=rs.getInt("price")%></td>
                <td><%=rs.getInt("quantity")%></td>
                <td><%=rs.getInt("cartid")%></td>
                <td><%=rs.getInt("lineid")%></td>
                <td><%=rs.getInt("idshoppingcart")%></td>
                <td><%=rs.getString("customer")%></td>

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

