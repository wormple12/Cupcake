/*
 */

package com.mycompany.cupcake.logic;

import java.sql.Connection;

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

}
