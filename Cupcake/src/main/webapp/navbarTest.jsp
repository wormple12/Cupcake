<%-- 
    Document   : navbar test
    Created on : 08-Mar-2019, 10:12:58
    Author     : Henning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/Cupcake/c/shopping">Cupcakes</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/Cupcake/c/shopping">Home</a></li>
                    <li><a href="/Cupcake/c/possibilities">Menu</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/Cupcake/CustomerPage"><span class="glyphicon glyphicon-user"></span> Customer Page</a></li>
                    <li><a href="/Cupcake/SessionExit.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </div>
        </nav>