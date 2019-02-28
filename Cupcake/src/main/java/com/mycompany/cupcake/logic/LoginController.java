/*
 */

package com.mycompany.cupcake.logic;

import com.mycompany.cupcake.data.UserDAO;
import com.mycompany.cupcake.data.User;

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
        return new UserDAO().getUser(username);
    }
    
}
