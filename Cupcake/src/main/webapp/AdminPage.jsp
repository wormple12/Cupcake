<%-- 
    Document   : AdminPage
    Created on : 06-Mar-2019, 13:04:39
    Author     : Henning
--%>
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
                Boolean admin = user.getAdmin();
                
                
                Order order

                out.print("<tr><td>" )
                
                
                out.print("<div align= \"right\">");
                out.print("<p>username: " + username + "</p>");
                out.print("<p>email: " + email + "</p>");
                out.print("<p>admin: " + admin + "</p>");
                out.print("<br>");
                out.print("</div>");
            %>
        </form>
    </body>
</html>
























<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<form method="post">

<table border="2">
   <tr>
        <td>user ID</td>
        <td>Birthday</td>
        <td>Gender</td>
        <td>First Name</td>
        <td>Last Name</td>
   </tr>
   <%
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/eyetracker";
       String username="root";
       String password="root";
       String query="select * from eyetracker";
       Connection conn=DriverManager.getConnection(url, username, password);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
           <tr><td><%rs.getInt("userID"); %></td></tr>
           <tr><td><%rs.getDate("dob"); %></td></tr>
           <tr><td><%rs.getString("gender"); %></td></tr>
           <tr><td><%rs.getString("firstName"); %></td></tr>
           <tr><td><%rs.getString("lastName"); %></td></tr>

   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>`