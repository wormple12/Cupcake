/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.logic.DBConnector;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.Statement;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henning
 */
public class VariousTests {

    public VariousTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testSQLTableInfoByQuery() {
        boolean actualResult = false;
        String customerName = "";
        try {

            DBConnector connector = new DBConnector();
            Connection c = connector.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT *"
                    + " FROM lineitems ls "
                    + "LEFT JOIN has_lineitem hs "
                    + "ON ls.idlineitems = hs.lineid "
                    + "LEFT JOIN orders sc "
                    + "ON sc.idorder = hs.orderid "
                    + "LEFT JOIN bottoms bot ON ls.bottom=bot.bottom_id "
                    + "LEFT JOIN toppings top ON ls.topping=top.topping_id "
                    + "WHERE sc.idorder = 37075;");
            while (rs.next()) {
                customerName = rs.getString("customer");
            }
            if (customerName.equals("pinky")) {
                actualResult = true;
            }
            assertTrue(actualResult);
            stmt.close();
            rs.close();
            c.close();
        } catch (Exception ex) {
            assertTrue(actualResult);
            Logger.getLogger(VariousTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDAOGetUserEmail() throws Exception {
        String expectedEmail = "Redroom4hire@blackmail.onion";
        CupcakeDAO dao = new CupcakeDAO();
        User user = dao.getUser("pinky");
        String actualEmail = user.getEmail();
        System.out.println("***********");
        System.out.println("Expected:" + expectedEmail);
        System.out.println("Actual:" + actualEmail);
        System.out.println("***********");
        assertEquals(expectedEmail, actualEmail);
    }
}
