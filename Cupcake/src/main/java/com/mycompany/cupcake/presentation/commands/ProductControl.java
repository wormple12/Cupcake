/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Cupcake;
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
            CupcakeDAO k = new CupcakeDAO();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Adding cupcakes to shopping cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Adding: " +qty+" "+top+ " with "+ bottom+ " bottom" + "</h1>");
            //out.println("<h1>Adding: "+" bottom" + "</h1>");
            out.println("</body>");
            out.println("</html>");

            try {
                Cupcake newcupcake = new Cupcake(k.getBottom(bottom), k.getTopping(top));
                LineItem item = new LineItem(newcupcake, tqty);
                ShoppingCart cart;
                if (request.getSession().getAttribute("ShoppingCart").toString().length() > 0) {
                    cart = new ShoppingCart();
                    cart.addToCart(item);
                } else {
                    cart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
                }
                request.getSession().removeAttribute("ShoppingCart");
                request.getSession().setAttribute("ShoppingCart", cart);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
