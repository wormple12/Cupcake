package com.mycompany.cupcake.presentation.commands;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author Emil PC
 */
@WebServlet(urlPatterns = {"/RegistrationCommand"})
public class RegistrationCommand extends Command {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void printHTML(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            final CupcakeDAO dao = new CupcakeDAO();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"cupcakebackgroun.css\">");            
            out.println("</head>");
            
            out.println("<body>");
            
            out.println("<div name=\"topmenu\">");
            out.println("<select onChange=\"window.location.href=this.value\">");   
            out.println("<option value = \"c/registration\"> Create new user </option>");
            out.println("<option value = \"/Cupcake/SessionExit.jsp\"> Login </option>");
            out.println("</select>");
            out.println("</div>");
            
            out.println("<h1> Create new user </h1>");
            out.println("<form action=/Cupcake/Registration> "
                     + "Username: <br> <input type=text name=username> <br> "
                     + "Password: <br> <input type= password name=password> <br> "
                     + "Email: <br> <input type= text name=email> <br>"
                     + "Create <br> <input type=submit>"
                     + "</form>");
            out.println("</body>");
            out.println("</html>");            
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            if (username != null && password != null && email != null){// && email != null) {    
                User user = dao.getUser(username);
                if (user == null) {
                    dao.createUser(new User(username,password,email));
                    redirectJSP.redirectUserCreated(response);
                } else {
                    redirectJSP.redirectUserCreationFail(response);
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printHTML(request,response);
    }

}
