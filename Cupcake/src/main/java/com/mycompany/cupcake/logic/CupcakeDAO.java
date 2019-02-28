/*
 */

package com.mycompany.cupcake.logic;

import com.mycompany.cupcake.data.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Simon Asholt Norup
 */
public class CupcakeDAO {
    
    private Connection c;

    public CupcakeDAO() {
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

   public void createUser(String email, String username, String password) throws Exception{
         PreparedStatement preparedStmt ;
         DBConnector connector = new DBConnector();
            c = connector.getConnection();
       String query
                = " insert into users (email, username, password) VALUES(?,?,?)";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setString(1, email);
        preparedStmt.setString(2, username);
        preparedStmt.setString(3, password);
        preparedStmt.execute();
   }
}
