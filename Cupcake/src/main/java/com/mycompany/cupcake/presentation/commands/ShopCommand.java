/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.presentation.commands;

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
 */
public class ShopCommand extends Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            String username = (String) request.getAttribute("username");
            String password = (String) request.getAttribute("password");
            String email = (String) request.getAttribute("email");
            printHTML(new User(username,password,email),response);
    }
    
    private void printHTML(User user, HttpServletResponse response) throws IOException{
    response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = user.getUsername();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopCommand</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopCommand at " + username + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
