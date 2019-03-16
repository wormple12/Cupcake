/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.data.cc_help_classes.ShoppingCart;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command class for redirecting to the finalization .jsp. Necessary for
 * completing the users purchase. Used by Front Controller. Retrieves attributes
 * from the shopping cart.
 *
 * @author Simon Asholt Norup
 */
public class FinalizationCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("User");
        String username = user.getUsername();
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");

        String pricetext = request.getParameter("tprice");
        double tprice = Double.parseDouble(pricetext);

        CupcakeDAO dao = new CupcakeDAO();
        try {
            if (tprice == 0.0) {
                request.getRequestDispatcher("/FinalizationEmptyCart.jsp").forward(request, response);
            }
            else if (dao.getBalance(username) > tprice) {
                dao.addOrder(cart, username);
                dao.removeBalance(username, tprice);
                request.getRequestDispatcher("/FinalizationSuccess.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/FinalizationFail.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
