<%-- 
    Document   : RegisterUser
    Created on : 06-03-2019, 15:21:11
    Author     : Emil PC
--%>

<%@page import="com.mycompany.cupcake.presentation.commands.redirectJSP"%>
<%@page import="com.mycompany.cupcake.data.CupcakeDAO"%>
<%@page import="com.mycompany.cupcake.data.user_help_classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
            <html>
            <head>
            <title>Servlet Registration</title>
            <link rel="stylesheet" type="text/css" href="css.css">
            <link rel="stylesheet" type="text/css" href="cupcakebackgroun.css">            
            </head>
            
            <body>
            
            <div id="topmenu">
            <select onChange="window.location.href=this.value">   
            <option value = "c/registration"> Create new user </option>
            <option value = "/Cupcake/SessionExit.jsp"> Login </option>
            </select>
            </div>
            
            <h1> Create new user </h1>
            <form action="/Cupcake/Registration">
                Username: <br> <input type=text name=username style="color: black"> <br> 
                      Password: <br> <input type= password name=password style="color: black"> <br> 
                      Email: <br> <input type= text name=email style="color: black"> <br>
                        <div id="submitbutton1">
                            <br> <input type=submit>
                        </div>
                      </form>
            </body>
            </html>    
            
            <%/*
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            final CupcakeDAO dao = new CupcakeDAO();
            if (username != null && password != null && email != null){// && email != null) {    
                User user = dao.getUser(username);
                if (user == null) {
                    dao.createUser(new User(username,password,email));
                    redirectJSP.redirectUserCreated(response);
                } else {
                    redirectJSP.redirectUserCreationFail(response);
                }
            }  */
            %>