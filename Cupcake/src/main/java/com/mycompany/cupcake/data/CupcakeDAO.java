/*
 */
package com.mycompany.cupcake.data;

import com.mycompany.cupcake.logic.DBConnector;
import com.mycompany.cupcake.data.cc_help_classes.Bottom;
import com.mycompany.cupcake.data.cc_help_classes.Topping;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.data.cc_help_classes.LineItem;
import com.mycompany.cupcake.data.cc_help_classes.ShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class handles all communication with the "cupcakedb" MySQL database. It fetches information as well as inserts into the database.
 * All methods requiring user input uses PreparedStatements to avoid SQLInjection issues.
 * @author Simon Asholt Norup
 */
public class CupcakeDAO {

    final static boolean DEBUG = true;

    // DOES NOT USE PREPARESTATEMENT YET
    public User getUser(String username) throws Exception {
        User user = null;

        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query = "select * from users where username = '" + username + "';";
        c = connector.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        String password = "";
        String email = "";
        Boolean admin = false;
        username = "";
        while (rs.next()) {
            password = rs.getString("password");
            email = rs.getString("email");
            admin = rs.getBoolean("is_admin");
            username = rs.getString("username");
        }
        if (username != null && !username.isEmpty()) {
            user = new User(username, password, email, admin);
        }
        stmt.close();
        rs.close();
        c.close();
        return user;
    }

    //Creates new user object
    public void createUser(User user) throws Exception {
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " insert into users (username, password, balance, email) VALUES(?,?,?,?)";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setString(1, user.getUsername());
        preparedStmt.setString(2, user.getPassword());
        preparedStmt.setDouble(3, 0);
        preparedStmt.setString(4, user.getEmail());
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

    public double getBalance(String username) throws Exception {
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

    public void addBalance(String username, double amount) throws Exception {
        double balance = getBalance(username) + amount;
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " update users set balance =? "
                + "where username = ?;";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setDouble(1, balance);
        preparedStmt.setString(2, username);
        preparedStmt.execute();

        preparedStmt.close();
        c.close();
    }

    public void removeBalance(String username, double amount) throws Exception {
        double balance = getBalance(username) - amount;
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        String query
                = " update users set balance =? "
                + "where username = ?;";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setDouble(1, balance);
        preparedStmt.setString(2, username);
        preparedStmt.execute();

        preparedStmt.close();
        c.close();
    }

    public Bottom getBottom(int id) throws Exception {
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select * from bottoms WHERE bottom_id= " + id + " ;");
        rs.next();
        int bottom_id = rs.getInt("bottom_id");
        String bottom_name = rs.getString("bottom_name");
        double price = rs.getDouble("price");
        return new Bottom(bottom_id, bottom_name, price);
    }

    public Topping getTopping(int id) throws Exception {
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select * from toppings Where topping_id= " + id + " ;");
        rs.next();
        int topping_id = rs.getInt("topping_id");
        String topping_name = rs.getString("topping_name");
        double price = rs.getDouble("price");
        return new Topping(topping_id, topping_name, price);
    }

    // earlier called "addCartToDB"
    public void addOrder(ShoppingCart cart, String username) throws Exception {
        PreparedStatement preparedStmt;
        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        Random rng = new Random();
        int id = rng.nextInt(99999);
        String query
                = " insert into orders (idorder, customer) VALUES(?,?)";
        preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt(1, id);
        preparedStmt.setString(2, username);
        preparedStmt.execute();
        for (LineItem p : cart.getCart()) {
            int itid = rng.nextInt(99999);
            query
                    = " insert into lineitems (idlineitems, bottom, topping, price, quantity) VALUES(?,?,?,?,?)";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt(1, itid);
            preparedStmt.setInt(2, p.getCupcake().getBottom().getBottom_id());
            preparedStmt.setInt(3, p.getCupcake().getTopping().getTopping_id());
            preparedStmt.setDouble(4, p.getPrice());
            preparedStmt.setInt(5, p.getQty());
            preparedStmt.execute();

            query
                    = " insert into has_lineitem (orderid, lineid) VALUES(?,?)";
            preparedStmt = c.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.setInt(2, itid);
            preparedStmt.execute();
        }
        preparedStmt.close();
        c.close();
    }

    // gets ordernumber + customer name
    public HashMap<Integer, String> getAllOrdersSimple(String username) throws Exception {
        HashMap<Integer, String> result = new HashMap<>();

        DBConnector connector = new DBConnector();
        Connection c = connector.getConnection();
        Statement stmt = c.createStatement();
        StringBuilder query = new StringBuilder("SELECT * FROM orders");
        if (username != null) {
            query.append(" WHERE customer = '" + username + "'");
        }
        query.append(";");
        ResultSet rs = stmt.executeQuery(query.toString());

        while (rs.next()) {
            int no = rs.getInt("idorder");
            String customer = rs.getString("customer");
            result.put(no, customer);
        }

        rs.close();
        stmt.close();
        c.close();
        return result;
    }

    // AdminPageOrderDetails.jsp SHOULD USE AN ORDER CLASS AND A METHOD LIKE THE ONE BELOW, INSTEAD OF THE CURRENT SOLUTION
    // InvoiceDetails.jsp HAS THE SAME ISSUE
    // ==========================================================================================================
//    public ArrayList<LineItem> getOrder(int id) throws Exception {
//        DBConnector connector = new DBConnector();
//        Connection c = connector.getConnection();
//        Statement stmt = c.createStatement();
//        ResultSet rs = stmt.executeQuery(
//                "SELECT *"
//                + " FROM lineitems ls "
//                + "LEFT JOIN has_lineitem hs "
//                + "ON ls.idlineitems = hs.lineid "
//                + "LEFT JOIN orders sc "
//                + "ON sc.idorder = hs.orderid "
//                + "WHERE sc.idorder =" + id + ";");
//        
//        ArrayList<LineItem> order = new ArrayList<>();
//        while (rs.next()) {
//            order.addLineItem(
//                    rs.getInt("idlineitems"),
//                    rs.getString("cupcake"),
//                    rs.getInt("price"),
//                    rs.getInt("quantity"),
//                    rs.getInt("orderid"),
//                    rs.getInt("lineid"),
//                    rs.getInt("idorder"),
//                    rs.getString("customer")
//            );
//        }
//        rs.close();
//        stmt.close();
//        c.close();
//        return order;
//    }
}
