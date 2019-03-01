/*
 */
package com.mycompany.cupcake.data;

import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Topping;
import com.mycompany.cupcake.data.order_help_classes.Order;
import com.mycompany.cupcake.data.user_help_classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Simon Asholt Norup
 */
public class CupcakeDAO {

    final static boolean DEBUG = true;

    //Return user object based on username
    public User getUser(String username) throws Exception {
        User user = null;
        try {
            user = getLoginInfo(username);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    // DOES NOT USE PREPARESTATEMENT YET
    private User getLoginInfo(String username) throws Exception {
        User user = null;

        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query = "select `password` from users where username = '" + username + "';";
        c = connector.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String password = rs.getString("password");
            user = new User(username, password);
        }
        stmt.close();
        rs.close();
        c.close();
        return user;
    }

    //Creates new user object
    public void createUser(String username, String password, String email) throws Exception {
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " insert into users (username, password, balance, email) VALUES(?,?,?,?)";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setString(1, username);
        preparedStmt.setString(2, password);
        preparedStmt.setDouble(3, 0);
        preparedStmt.setString(4, email);
        preparedStmt.execute();

        preparedStmt.close();
        c.close();
    }

    //Returns an ArrayList with all Bottoms from the database
    public ArrayList<Bottom> getAllBottoms() throws Exception {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bottoms;");

            ArrayList<Bottom> allBottoms = new ArrayList();
            while (rs.next()) {
                int bottom_id = rs.getInt("bottom_id");
                String bottom_name = rs.getString("bottom_name");
                double price = rs.getDouble("price");
                allBottoms.add(new Bottom(bottom_id, bottom_name, price));
            }
            stmt.close();
            rs.close();
            c.close();
            return allBottoms;

        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    //Returns an ArrayList with all Toppings from the database
    public ArrayList<Topping> getAllToppings() throws Exception {
        try {
            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from toppings;");

            ArrayList<Topping> allToppings = new ArrayList();
            while (rs.next()) {
                int topping_id = rs.getInt("topping_id");
                String topping_name = rs.getString("topping_name");
                double price = rs.getDouble("price");
                allToppings.add(new Topping(topping_id, topping_name, price));
            }
            stmt.close();
            rs.close();
            c.close();
            return allToppings;

        } catch (SQLException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private double getBalance(String username) throws Exception {
        double balance = -1.0;

        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query = "select `balance` from users where username = '" + username + "';";
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            balance = rs.getDouble("balance");
            if (balance < 0) {
                throw new SQLException();
            }
        }
        stmt.close();
        rs.close();
        c.close();
        return balance;
    }

    public void editBalance(String username, double amount) throws Exception {
        double balance = getBalance(username) + amount;
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " insert into users (balance) VALUES(?) "
                + "where username = ?;";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setDouble(1, balance);
        preparedStmt.setString(2, username);
        preparedStmt.execute();

        preparedStmt.close();
        c.close();
    }

    public Order getOrder(int orderNumber) throws Exception {
        Order order = null;
        try {
            order = getOrderInfo(orderNumber);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    private Order getOrderInfo(int orderID) throws Exception {
        Order order = null;

        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query = "select `username` from orders where orderID = '" + orderID + "';";
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String username = rs.getString("username");
            order = new Order(orderID, username);
        }
        stmt.close();
        rs.close();
        c.close();
        return order;
    }

    public void createOrder(int orderNumber, String username) throws Exception {
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " insert into users (orderNumber, username) VALUES(?,?)";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt(1, orderNumber);
        preparedStmt.setString(2, username);
        preparedStmt.execute();

        preparedStmt.close();
        c.close();
    }
}
