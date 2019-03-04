
package com.mycompany.cupcake.presentation.commands;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class redirectJSP {
    
    public static void redirectShopping (HttpServletResponse response) throws IOException {
        response.sendRedirect("c/shopping");
    }
    public static void redirectFailedLogin (HttpServletResponse response) throws IOException {
        response.sendRedirect("FailedLogin.jsp");
    }
    public static void redirectUserCreated (HttpServletResponse response) throws IOException {
        response.sendRedirect("NewUser.jsp");
    }
    public static void redirectUserCreationFail  (HttpServletResponse response) throws IOException {
        response.sendRedirect("FailedCreation.jsp");
    }
   /* public static void redirectShopping (HttpServletResponse response) throws IOException {
        response.sendRedirect("c/shopping");
    }*/
    
    
    
}
