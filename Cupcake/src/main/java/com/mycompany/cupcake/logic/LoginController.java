/*
 */

package com.mycompany.cupcake.logic;

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.user_help_classes.User;

/**
 * @author Simon Asholt Norup
 */
public class LoginController {

    public boolean isValid(String username, String password){
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        User user = getUser(username);
        if (user == null) return false;
        return (password.equals(user.getPassword()));
    }
    
    public User getUser(String username){
        return new CupcakeDAO().getUser(username);
    }
        
}
