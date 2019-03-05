<%-- 
    Document   : userShow
    Created on : 05-Mar-2019, 12:43:55
    Author     : Henning
    Note       : Add balance and adminstrator.
--%>

<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User has been created!</h1>
        
        <p><a href="/Cupcake/RegistrationNlogin"> Go back </a></p>
    </body>
</html>

    <%
        User user = (User) request.getAttribute("User");

        String username = user.getUsername();
        String email = user.getEmail();

//        out.print("<p>username: " + username + "</p>");
//        out.print("<p>email: " + email + "</p>");
        System.out.println(username);
        out.print( username );
        out.print(email);
        out.print("lul");

    %>
welcome&lt;to&gt;
</div>-->

