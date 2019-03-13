/*
 */
package com.mycompany.cupcake.presentation;

import com.mycompany.cupcake.presentation.commands.*;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon Asholt Norup
 */
public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public static Command from(HttpServletRequest request) {
        String path = request.getPathInfo().substring(1); // substrings "/" out of the path
//        String path = request.getParameter("path");

        HashMap<String, Command> actions = new HashMap<String, Command>(){{
            put("registration", new RegistrationCommand());
            put("login", new LoginCommand());
            put("shopping", new MainPageCommand());
            put("possibilities", new ListCupcakeOptionsCommand());
            put("showuser", new ShowCustomerCommand());
            put("addtocart", new CupcakeAddedCommand());
            put("cart", new ShoppingCartCommand());
            put("finalize", new FinalizationCommand());
        }};

        return actions.getOrDefault(path, new UnknownCommand());
    }
}
