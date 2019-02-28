/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.User;
import com.mycompany.cupcake.logic.LoginController;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Simon Asholt Norup
 */
public class LoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginController c = new LoginController();
        boolean valid = c.isValid(username, password);

//        HttpSession session = request.getSession();
//        session.setAttribute(username, user);
//        User temp = (User) session.getAttribute("user");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Username: " + username + ", Password: " + password + ", Valid: " + valid + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
