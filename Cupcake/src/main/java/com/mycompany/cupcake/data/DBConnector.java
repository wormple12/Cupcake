package com.mycompany.cupcake.data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
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
	
    public DBConnector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.cj.jdbc.Driver
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?allowMultiQueries=true"; // &useSSL=false ???
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
