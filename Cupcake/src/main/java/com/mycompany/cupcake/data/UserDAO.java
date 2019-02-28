/*
 */

package com.mycompany.cupcake.data;

import com.mycompany.cupcake.logic.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Simon Asholt Norup
 */
public class UserDAO {

    private Connection c;

    public UserDAO() {
        try {
            DBConnector connector = new DBConnector();
            c = connector.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public User getUser(String username){
        User user = null;
        try {
            user = getLoginInfo(username);
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    // DOES NOT USE PREPARESTATEMENT YET
    private User getLoginInfo(String username) throws SQLException {
        User user = null;

        String query = "select `password` from users where username = '"+username+"';";
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String password = rs.getString("password");
            user = new User(username, password);
        }
        stmt.close(); rs.close();
        return user;
    }

}
