<%-- 
    Document   : userLoginCheck
    Created on : 05-Mar-2019, 11:10:53
    Author     : Henning
--%>

<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%
    
    try {
        User userLoggedIn = (User) session.getAttribute("username");
        if (userLoggedIn == null) {
        request.setAttribute("errormessage", "User not logged in...");
        response.sendRedirect("index.jsp");
    }
    } catch (Exception e)
    {
        e.printStackTrace();
    }

    
%>