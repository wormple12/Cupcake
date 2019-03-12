/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Topping;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon Asholt Norup
 */
public class ListCupcakeOptionsCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Bottom> bottoms = null;
        ArrayList<Topping> toppings = null;
        try {
            CupcakeDAO dao = new CupcakeDAO();
            bottoms = dao.getAllBottoms();
            toppings = dao.getAllToppings();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        request.setAttribute("bottoms", bottoms);
        request.setAttribute("toppings", toppings);
        
        request.getRequestDispatcher("/ChooseCupcake.jsp").forward(request, response);
    }

}
