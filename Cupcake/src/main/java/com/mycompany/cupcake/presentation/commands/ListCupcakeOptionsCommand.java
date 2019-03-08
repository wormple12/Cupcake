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
            out.println("<head>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "<title>Cupcake Menu</title>\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"altcss.css\">\n"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n"
                    + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n"
                    + "</head>");
            out.println("<body>");
            out.println("<jsp:include page=\"siteheader.jsp\" />");
            out.println("<form action=\"/Cupcake/ProductControl\" method = POST>");
            out.println("<select name = top>Toppings:");
            for (Topping topping : toppings) {
                out.println("<option value =" + topping.getTopping_id() + "> " + topping.getTopping_name() + ", " + topping.getPrice() + ",- DKK</option>");
            }
            
            out.println("</select><select name = bottom>Bottoms:");
            for (Bottom bottom : bottoms) {
                out.println("<option value=\"" + bottom.getBottom_id()+"\">"+  bottom.getBottom_Name() + ", " + bottom.getPrice() + ",- DKK</option>");
            }
            out.println("<input name=\"quantity\">"+"Quantity"+"</input>");
            out.println("<input type= submit>");
            out.println("</form>");
            out.println("</select><p><a href=\"shopping\"> Go back </a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
