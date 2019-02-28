/*
 */

package com.mycompany.cupcake.data;

import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.user_help_classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Simon Asholt Norup
 */
public class CupcakeDAO {
    
    final static boolean DEBUG = true;
    private Connection c;

    
    //Constructor
    public CupcakeDAO() {
        try {
            DBConnector connector = new DBConnector();
            c = connector.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    
    
    //Return user object based on username
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

    //Creates new user object
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
   
   
   public ArrayList<Bottom> getAllBottoms() throws Exception {
        try {
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct recipe_name from recipe;");
            
            ArrayList<Bottom> allBottoms = new ArrayList();
            while (rs.next()) {
                int bottom_id = rs.getInt("bottom_id");
                String bottom_name = rs.getString("bottom_name");
                double price = rs.getDouble("price");
                allBottoms.add(new Bottom(bottom_id,bottom_name,price));
            }
            
            return null;
            
        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
         return null;
    }
   
}
