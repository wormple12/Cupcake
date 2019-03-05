<%-- 
    Document   : SessionExit
    Created on : 05-Mar-2019, 20:44:45
    Author     : Henning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>-->

<div id="tops">
    <%
        
        session.invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("RegistrationNlogin");        
        rd.forward(request, response);
        
    %>
</div>
