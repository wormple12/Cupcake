/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Topping;
import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            dao = new CupcakeDAO();
            toppings = dao.getAllToppings();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        printHTML(response, bottoms, toppings);
    }

    private void printHTML(HttpServletResponse response, ArrayList<Bottom> bottoms, ArrayList<Topping> toppings) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebRecipes: Alle opskrifter</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Toppings:</h1>");
            for (Topping topping : toppings) {
                out.println("<p>" + topping.getTopping_id() + ", " + topping.getTopping_name() + ", " + topping.getPrice() + ",- DKK</p>");
            }
            out.println("<h1>Bottoms:</h1>");
            for (Bottom bottom : bottoms) {
                out.println("<p>" + bottom.getBottom_id() + ", " + bottom.getBottom_Name() + ", " + bottom.getPrice() + ",- DKK</p>");
            }
            out.println("<p><a href=\"shopping\"> Go back </a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
