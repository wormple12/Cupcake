/*
 */
package com.mycompany.cupcake.presentation;

import com.mycompany.cupcake.presentation.commands.*;
import java.io.IOException;
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
        Command command;
        String path = request.getPathInfo().substring(1); // substrings "/" out of the path

        switch (path) {
            case "possibilities":
                command = new ListCupcakeOptionsCommand();
                break;
            default:
                command = new UnknownCommand();
                break;
        }
        return command;
    }
}
