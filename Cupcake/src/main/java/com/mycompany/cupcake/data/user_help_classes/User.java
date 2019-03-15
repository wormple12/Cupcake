/*
 */

package com.mycompany.cupcake.data.user_help_classes;

import com.mycompany.cupcake.data.CupcakeDAO;

/**
 * @author Simon Asholt Norup
 */
public class User {

    private final String username;
    private final String password;
    private final String email;
    private Boolean admin = false;

    /**
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

    /**
     *
     * @return
     */
    public Boolean getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", admin=" + admin + '}';
    }
}
