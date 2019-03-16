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
<%@page import="com.mycompany.cupcake.logic.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>    
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="siteheader.jsp" />
        <jsp:include page="UserInfoBox.jsp" />

        <form method="post">
            <table id ="uglytable" border = "1">
                <tr>
                    <td>idlineitems</td>
                    <td>bottom</td>
                    <td>topping</td>
                    <td>price</td>
                    <td>quantity</td>
                    <td>idorder</td>
                    <td>customer</td>
                </tr>
                <%
                    byte checkSort = 0;
                    try {
                        DBConnector connector = new DBConnector();
                        Connection c = connector.getConnection();
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery(
                                "SELECT *"
                                + " FROM lineitems ls "
                                + "LEFT JOIN has_lineitem hs "
                                + "ON ls.idlineitems = hs.lineid "
                                + "LEFT JOIN orders sc "
                                + "ON sc.idorder = hs.orderid "
                                + "LEFT JOIN bottoms bot ON ls.bottom=bot.bottom_id "
                                + "LEFT JOIN toppings top ON ls.topping=top.topping_id "        
                                + "WHERE sc.idorder =" + request.getParameter("idorder") + ";");

                        while (rs.next()) {
                            if (checkSort == 0) {
                %>
                <tr>
                    <td><%=rs.getInt("idlineitems")%></td>
                    <td><%=rs.getString("bottom_name")%></td>
                    <td><%=rs.getString("topping_name")%></td>
                    <td><%=rs.getInt("price")%></td>
                    <td><%=rs.getInt("quantity")%></td>
                    <td><%=rs.getInt("idorder")%></td>
                    <td><%=rs.getString("customer")%></td>


                </tr>
                <%
                        }
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


