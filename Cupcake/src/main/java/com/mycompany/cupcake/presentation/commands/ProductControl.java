/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Cupcake;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.logic.LineItem;
import com.mycompany.cupcake.logic.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henning
 */
@WebServlet(name = "ProductControl", urlPatterns = {"/ProductControl"})
public class ProductControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.getSession();
            String top = request.getParameter("top");
            String bottom = request.getParameter("bottom");
            String qty = request.getParameter("quantity");
            int tqty = Integer.valueOf(qty);
            int topId = Integer.valueOf(top);
            int botId = Integer.valueOf(bottom);
            CupcakeDAO k = new CupcakeDAO();

            Cupcake newcupcake = new Cupcake(k.getBottom(botId), k.getTopping(topId));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Adding cupcakes to shopping cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Adding: " + qty + " " + newcupcake.getTopping().getTopping_name() + " cupcakes with " + newcupcake.getBottom().getBottom_Name() + " bottom" + "</h1>");
            /* User p = (User) request.getSession().getAttribute("User");
            out.println("<h1>Adding: "+p.getUsername() + "</h1>");*/

            LineItem item = new LineItem(newcupcake, tqty);
            ShoppingCart cart;
            if (request.getSession().getAttribute("ShoppingCart") == null) {
                cart = new ShoppingCart();

            } else {
                cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");

            }
            cart.addToCart(item);
            request.getSession().setAttribute("ShoppingCart", cart);
            out.println("<form  action="+"Products.jsp"+"><input value=\"Go to Checkout\" type=submit>"
                    + "<input type=submit value=\"Order more\" formaction=c/possibilities>"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
