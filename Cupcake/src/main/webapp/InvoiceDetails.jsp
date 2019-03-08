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
<%--<%@page import="-Dorg.apache.jasper.compiler.Parser.STRICT_QUOTE_ESCAPING=false"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page= "<%= "includes/" + "Cupcake/navbarTest.jsp"
%>" /> --%>     
<!---Dorg.apache.jasper.compiler.Parser.STRICT_QUOTE_ESCAPING=false-->
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
         
        <jsp:include page="UserInfoBox.jsp" />
        
        <%
            User user = (User) request.getSession().getAttribute("User");
            String username = user.getUsername();
        %>

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
                    ResultSet rs = stmt.executeQuery(
                            "SELECT *"
                            + " FROM lineitems ls "
                            + "LEFT JOIN has_lineitem hs "
                            + "ON ls.idlineitems = hs.lineid "
                            + "LEFT JOIN shoppingcart sc "
                            + "ON sc.idshoppingcart = hs.cartid "
                            + "WHERE sc.idshoppingcart =" + request.getParameter("idshoppingcart") + ";");

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

