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
import javax.servlet.annotation.WebServlet;
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
            //out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"cupcakebackgroun.css\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div name=\"topmenu\">");
            out.println("<select>");
            out.println("<option value = \"hello\"> Hello </option>");
            out.println("<option value = \"hello1\"> Hello </option>");
            out.println("<option value = \"hello2\"> Hello1 </option>");
            out.println("</select>");
            out.println("</div>");

            out.println("<h1> Login </h1>");
            out.println("<form action=/Cupcake/RegistrationNlogin method=POST> "
                     + "Password: <br> <input type= password name=password> <br> "
                     //+ "Email: <br> <input type= text name=email> <br>"
                     + "<br> <input type=submit>"
                     + "<p><a href=\"c/registration\"> Create New User </a></p>"
                     + "</form>");

            out.println("</body>");
            out.println("</html>");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {// && email != null) {    
                User user = dao.getUser(username);
                
                if (user == null) {
                    redirectJSP.redirectFailedLogin(response);
                } else {
                    HttpSession session = request.getSession();
                    session.removeAttribute("User");
                    session.setAttribute("User", dao.getUser(username));
                    redirectJSP.redirectShopping(response);
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
