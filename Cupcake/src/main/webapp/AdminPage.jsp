<%-- 
    Document   : AdminPage
    Created on : 06-Mar-2019, 13:04:39
    Author     : Henning
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="jquery.js"></script> 
        <script>
            $(function () {
                $("#includedContent").load("b.html");
            });
        </script> 

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
        <table id ="uglytable" border = "1">
            <tr>

                <td>cartid</td>
                <td>customer</td>
                <td>view</td>
            </tr>
            <%
                try {
                    DBConnector connector = new DBConnector();
                    Connection c = connector.getConnection();
                    Statement stmt = c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM shoppingcart");
                    //Order order = (Order) request.getSession().getAttribute("Order");

                    while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getInt("idshoppingcart")%></td>
                <td><%=rs.getString("customer")%></td>
                <td>

                    <a href="/Cupcake/AdminPageOrderDetails.jsp?idshoppingcart=<%=rs.getInt("idshoppingcart")%>" >
                        <div style="height:100%;width:100%">
                            <!--<input type="radio" name="radio1" onclick="handleClick(this.id);" id="customerId" />-->
                            view
                            </td>
                    </a>
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





