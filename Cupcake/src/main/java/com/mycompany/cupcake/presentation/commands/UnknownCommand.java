/*
 */

package com.mycompany.cupcake.presentation.commands;

import com.mycompany.cupcake.presentation.Command;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for redirecting to a .jsp describing how a user is trying to access a page that does not exist.
 * @author Simon Asholt Norup
 */
public class UnknownCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/PageNotFound.jsp").forward(request, response);
    }
 
}
