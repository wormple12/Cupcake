<%-- 
    Document   : userShow
    Created on : 05-Mar-2019, 12:43:55
    Author     : Henning
    Note       : Add balance and adminstrator.
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mycompany.cupcake.logic.DBConnector"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Customer Page</title>
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
            <table border = "1">
                <tr>
                    <td>order_number</td>
                    <td>username</td>
                    <td>...</td>
                </tr>
                <%
                    try {
                        User user = (User) request.getSession().getAttribute("User");
                        CupcakeDAO dao = new CupcakeDAO();
                        HashMap<Integer, String> orders = dao.getAllOrdersSimple(user.getUsername());

                        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
                %>
                            <tr>
                                <td><%=entry.getKey()%></td>
                                <td><%=entry.getValue()%></td>
                                <td>

                                    <a href="/Cupcake/InvoiceDetails.jsp?idshoppingcart=<%=entry.getKey()%>" >
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
