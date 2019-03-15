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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emil PC
 */
public class RegistrationCommand extends Command {
/**
 * Registration command, needs username, password and email which it then tries to use
 * to create a new user in the database.
 * It then forwards you based on wether the creation was succesful or not.
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final CupcakeDAO dao = new CupcakeDAO();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            if (username != null && password != null && email != null) {
                User user = dao.getUser(username);
                if (user == null) {
                    dao.createUser(new User(username, password, email));
                    request.getRequestDispatcher("/NewUser.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/FailedCreation.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/RegisterUser.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
