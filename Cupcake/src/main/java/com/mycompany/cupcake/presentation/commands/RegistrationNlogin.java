/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.DBConnector;
import com.mycompany.cupcake.data.DataException;
import com.mycompany.cupcake.data.user_help_classes.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lukas Bjørnvad
 */
@WebServlet(name = "RegistrationNlogin", urlPatterns = {"/RegistrationNlogin"})
public class RegistrationNlogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            final CupcakeDAO dao = new CupcakeDAO();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationNlogin</title>");
            out.println("</head>");
            out.println("<body>");
            /*
            Change the form action as it needs context with the database

             */

            out.println("<form action=/Cupcake/RegistrationNlogin> "
                    + "Username: <br>" + "<input type=text name=username> <br> "
                    + "Password:<br> <input type= password name=password> <br> "
                    + "Email:<br> <input type= text name=email> <br><br> <input type=submit>"
                    + "</form>");

            out.println("</body>");
            out.println("</html>");

            final String username = request.getParameter("username");
            final String password = request.getParameter("password");
            final String email = request.getParameter("email");
            if (username != null && password != null && email != null) {

                User user = dao.getUser(username);
                if (user == null) {
                    dao.createUser(new User(username, password, email));
                    user = dao.getUser(username);
                } else if (user.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    // is this enough? I mean, probably... but what do I know, I'm just a poor boy, I need no sympathy 
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
