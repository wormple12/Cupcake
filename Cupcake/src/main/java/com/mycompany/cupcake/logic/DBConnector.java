package com.mycompany.cupcake.logic;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is used to connect to any MySQL database that allows remote access.
 * What database to connect to and what SQL user to log in as is determined by the constant variables currently hardcoded.
 * Currently, the DBConnector connects to the MySQL server on Simon Asholt Norup's Ubuntu droplet.
 * @author RODA
 */
public class DBConnector {
    private Connection connection = null;
	
    //Constants
    private static final String IP	 = "165.227.148.141"; //;
    private static final String PORT     = "3306";
    public static final String DATABASE  = "cupcakedb";
    private static final String USERNAME = "mute"; 
    private static final String PASSWORD = "Toor";	     	
	
    /**
     * Constructor that handles the actual connection process and initializes the Connection variable.
     * @throws Exception
     */
    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.cj.jdbc.Driver
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?allowMultiQueries=true"; // &useSSL=false ???
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    /**
     * @return the connection initialized as the DBConnector object was created
     */
    public Connection getConnection() {
        return this.connection;
    }
}
