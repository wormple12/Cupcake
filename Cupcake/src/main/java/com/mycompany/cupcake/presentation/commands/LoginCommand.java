/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.presentation.redirectJSP;
import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Simon Asholt Norup
 */
public class LoginCommand extends Command {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final CupcakeDAO dao = new CupcakeDAO();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            if (username != null && password != null) {
                User user = dao.getUser(username);
                
                if (user.getUsername().length() == 0) {
                    request.setAttribute("errormessage", "<p style=\"color:red\">Incorrect username/passwords</p>");
                    loadJSP(request, response);
                } else if (!user.getPassword().equals(password)) {
                    request.setAttribute("errormessage", "<p style=\"color:red\">Incorrect password</p>");
                    loadJSP(request, response);
                    
                } else {
                    HttpSession session = request.getSession();
                    session.removeAttribute("User");
                    session.setAttribute("User", dao.getUser(username));
                    redirectJSP.redirectShopping(response);
                }
            } else {
                loadJSP(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
    
}
