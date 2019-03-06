<%-- 
    Document   : userShow
    Created on : 05-Mar-2019, 12:43:55
    Author     : Henning
    Note       : Add balance and adminstrator.
--%>

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

                out.print("<div align= \"right\">");
                out.print("<p>username: " + username + "</p>");
                out.print("<p>email: " + email + "</p>");
                out.print("<br>");
                out.print("</div>");
            %>
        </form>
    </body>
</html>


<!--   
    out.print(username);
    out.print(email);

-->
