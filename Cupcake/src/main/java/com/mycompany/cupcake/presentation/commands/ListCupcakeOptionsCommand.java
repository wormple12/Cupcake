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
        
        CupcakeDAO dao = new CupcakeDAO();
        ArrayList<Bottom> bottoms = dao.getAllBottoms();
        
        dao = new CupcakeDAO();
        ArrayList<Topping> toppings = dao.getAllToppings();

        printHTML(response, bottoms, toppings);
    }

    private void printHTML(HttpServletResponse response, ArrayList<Bottom> bottoms, ArrayList<Topping> toppings) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebRecipes: Alle opskrifter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Toppings:</h1>");
            for (Topping topping : toppings) {
                out.println("<p>"+topping.getTopping_id() + ", " + topping.getTopping_name() + ", " + topping.getPrice() + ",- DKK</p>");
            }
            out.println("<h1>Bottoms:</h1>");
            for (Bottom bottom : bottoms) {
                out.println("<p>"+bottom.getBottom_id() + ", " + bottom.getBottom_Name() + ", " + bottom.getPrice() + ",- DKK</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
