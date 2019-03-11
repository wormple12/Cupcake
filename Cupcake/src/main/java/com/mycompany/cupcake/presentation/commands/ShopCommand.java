/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emil PC
 *
 * Note mute: As of 07-03, printHTML now uses the constructor that includes
 * admin. This might cause issues.
 *
 */
public class ShopCommand extends Command {

    CupcakeDAO dao = new CupcakeDAO();
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        Boolean admin = user.getAdmin();

        printHTML(new User(username, password, email, admin), response);
    }

    private void printHTML(User user, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = user.getUsername();
            Boolean admin = user.getAdmin();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"altcss.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
            out.println("<title>Servlet ShopCommand</title>");
            out.println("</head>");
            out.println("<body>");

            out.println(" <nav class=\"navbar navbar-inverse\">\n"
                    + "            <div class=\"container-fluid\">\n"
                    + "                <div class=\"navbar-header\">\n"
                    + "                    <a class=\"navbar-brand\" href=\"/Cupcake/c/shopping\">Cupcakes</a>\n"
                    + "                </div>\n"
                    + "                <ul class=\"nav navbar-nav\">\n"
                    + "                    <li class=\"active\"><a href=\"/Cupcake/c/shopping\">Home</a></li>\n"
                    + "                    <li><a href=\"/Cupcake/c/possibilities\">Menu</a></li>\n"
                    + "                </ul>\n"
                    + "                <ul class=\"nav navbar-nav navbar-right\">\n"
                    + "                    <li><a href=\"/Cupcake/c/showuser\"><span class=\"glyphicon glyphicon-user\"></span> Customer Page</a></li>\n"
                    + "                    <li><a href=\"/Cupcake/SessionExit.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Log out</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </nav>");
            out.println("<h1>Welcome back    : " + username + "</h1>");
            out.println("<h2>Current balance : " + dao.getBalance(username) + "</h2>");
            out.println("<p><a href=\"possibilities\"> Check out the menu! </a></p>");
            out.println("<p><a href=\"../c/showuser\"> Customer page </a></p>");
            if (admin == true) {
                out.println("<p><a href=\"/Cupcake/AdminPage.jsp\"> Admin </a></p>");
            }
            out.println("<p><a href=\"/Cupcake/SessionExit.jsp\"> Logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
