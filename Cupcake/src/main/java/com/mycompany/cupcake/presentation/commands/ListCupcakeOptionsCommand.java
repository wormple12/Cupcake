/*
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
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
        ArrayList<Bottom> recipes = dao.getAllBottoms();
        
        dao = new CupcakeDAO();
        StringBuilder recipe_list = new StringBuilder();
        for (Recipe recipe : recipes) {
            int id = dao.getRecipeID(recipe.getName(), recipe.getAuthor());
            String link_url = "http://localhost:8080/WebRecipes/c/recipe?id="+id;
            recipe_list.append("<p><a href=\""+link_url+"\">"+recipe.getName()+"</a> - (skrevet af "+recipe.getAuthor()+")</p><br> ");
        }
        dao.closeConnection();

        printHTML(response, recipe_list);
    }

    private void printHTML(HttpServletResponse response, StringBuilder recipe_list) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebRecipes: Alle opskrifter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Velkommen til WebRecipes!</h1>");
            out.println(recipe_list.toString());
            out.println("</body>");
            out.println("</html>");
        }
    }

}
