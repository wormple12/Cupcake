/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.ShoppingCart;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lukas Bjørnvad (converted to command by Simon Asholt Norup)
 */
public class ShoppingCartCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");

        int toRemove = -1;
        try {
            toRemove = Integer.parseInt(request.getParameter("remove"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (toRemove >= 0 && cart.getCart().size() > 0) {
            cart.getCart().remove(toRemove);
            request.getSession().setAttribute("ShoppingCart", cart);
        }

        try {
            CupcakeDAO dao = new CupcakeDAO();
            User user = (User) request.getSession().getAttribute("User");
            double balance = dao.getBalance(user.getUsername());
            request.setAttribute("balance", balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("/Products.jsp").forward(request, response);
    }

}
