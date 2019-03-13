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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emil PC
 *
 */
public class MainPageCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CupcakeDAO dao = new CupcakeDAO();

        try {
            User user = (User) request.getSession().getAttribute("User");
            String username = user.getUsername();
            double balance = dao.getBalance(username);
            request.setAttribute("balance", balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
    }

}
