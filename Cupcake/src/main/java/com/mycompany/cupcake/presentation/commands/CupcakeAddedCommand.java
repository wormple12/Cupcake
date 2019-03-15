/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Cupcake;
import com.mycompany.cupcake.data.cc_help_classes.LineItem;
import com.mycompany.cupcake.data.cc_help_classes.ShoppingCart;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command class for redirecting to the "CupcakeAdded".jsp.
 * Necessary when adding objects to the shoppingcart.
 * Carries parameters on session to the .jsp.
 * Used by Front Controller.
 * @author Simon Asholt Norup
 */
public class CupcakeAddedCommand extends Command { // EARLIER CALLED PRODUCTCONTROL.java
/**
 * Adds item to the shoppingcart, links to the shopping cart overview.
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String top = request.getParameter("top");
        String bottom = request.getParameter("bottom");
        String qty = request.getParameter("quantity");
        int tqty = Integer.valueOf(qty);
        int topId = Integer.valueOf(top);
        int botId = Integer.valueOf(bottom);

        try {
            CupcakeDAO k = new CupcakeDAO();
            Cupcake cupcake = new Cupcake(k.getBottom(botId), k.getTopping(topId));
            request.setAttribute("Cupcake", cupcake);

            ShoppingCart cart;
            if (request.getSession().getAttribute("ShoppingCart") == null) {
                cart = new ShoppingCart();
            } else {
                cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
            }
            LineItem item = new LineItem(cupcake, tqty);
            cart.addToCart(item);
            request.getSession().setAttribute("ShoppingCart", cart);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("/CupcakeAdded.jsp").forward(request, response);
    }

}
