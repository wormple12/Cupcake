/*
 */

package com.mycompany.cupcake.data.user_help_classes;

import com.mycompany.cupcake.data.CupcakeDAO;

/**
 * Help class for the User object. Holds relevance when handling the SQL database user table.
 * @author Simon Asholt Norup
 */
public class User {

    private final String username;
    private final String password;
    private final String email;
    private Boolean admin = false;

    /**
     *User class constructor without the admin parameter.
     *Implemented for functions where admin status doesn't have any relevance.
     * 
     * @param username
     * @param password
     * @param email
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }   

    /**
     *User class constructor with the admin parameter.
     *Implemented for functions where admin status has relevance.
     * 
     * @param username
     * @param password
     * @param email
     * @param admin
     */
    public User(String username, String password, String email, Boolean admin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

  
    public Boolean getAdmin() {
        return admin;
    }

   
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
   
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", admin=" + admin + '}';
    }
}
