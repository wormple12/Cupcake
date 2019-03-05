<%-- 
    Document   : userShow
    Created on : 05-Mar-2019, 12:43:55
    Author     : Henning
    Note       : Add balance and adminstrator.
--%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>


<div id ="derp">
    <%
        User user = (User) request.getAttribute("User");

        String username = user.getUsername();
        String email = user.getEmail();

        out.print("<p>username: " + username + "</p>");
        out.print("<p>email: " + email + "</p>");

    %>
</div>

