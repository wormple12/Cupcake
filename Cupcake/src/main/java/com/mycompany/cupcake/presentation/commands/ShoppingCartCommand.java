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
 * Command class for redirecting to the "products".jsp.
 * Controlls overview and removal of current items in shoppingcart.
 * Used by Front Controller.
 * @author Lukas Bjørnvad (converted to command by Simon Asholt Norup)
 */

public class ShoppingCartCommand extends Command {
/**
 * This is the ShoppingCart Command. Handles removing items from the shopping cart
 * and let's the costumer get an overview of what they have in the shopping cart. 
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
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
