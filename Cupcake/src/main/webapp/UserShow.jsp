<%-- 
    Document   : userShow
    Created on : 05-Mar-2019, 12:43:55
    Author     : Henning
    Note       : Add balance and adminstrator.
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.data.DBConnector"%>
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

                out.print("<div align= \"right\">");
                out.print("<p>username: " + username + "</p>");
                out.print("<p>email: " + email + "</p>");
                //out.print("<p>admin: " + admin + "</p>");
                out.print("<br>");
                out.print("</div>");
            %>
        </form>

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
                        ResultSet rs = stmt.executeQuery("SELECT * FROM shoppingcart WHERE customer = '"+username+"';");
                        //Order order = (Order) request.getSession().getAttribute("Order");

                        while (rs.next()) {
                %>
                <tr>
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


    </body>
</html>


<!--   
    out.print(username);
    out.print(email);

-->
