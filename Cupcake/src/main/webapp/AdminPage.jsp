<%-- 
    Document   : AdminPage
    Created on : 06-Mar-2019, 13:04:39
    Author     : Henning

    Modified   : 11-Mar-2019
    Author     : Simon
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.logic.DBConnector"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>


<html>
    <head>
        <link rel="stylesheet" type="text/css" href="altcss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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

                    <td>orderid</td>
                    <td>customer</td>
                    <td>...</td>
                </tr>
                <%
                    try {
                        CupcakeDAO dao = new CupcakeDAO();
                        HashMap<Integer, String> orders = dao.getAllOrdersSimple(null);

                        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
                %>
                <tr>
                    <td><%=entry.getKey()%></td>
                    <td><%=entry.getValue()%></td>
                    <td>

                        <a href="/Cupcake/AdminPageOrderDetails.jsp?idorder=<%=entry.getKey()%>" >
                            <div style="height:100%;width:100%">
                                <!--<input type="radio" name="radio1" onclick="handleClick(this.id);" id="customerId" />-->
                                view
                            </div>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </form>
    </body>
</html>





