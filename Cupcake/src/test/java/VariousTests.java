/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cupcake.data.CupcakeDAO;
import com.mycompany.cupcake.data.cc_help_classes.Topping;
import com.mycompany.cupcake.data.user_help_classes.User;
import com.mycompany.cupcake.logic.DBConnector;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.Statement;
import java.util.ArrayList;
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

    //Raw unused query to show versatility of database
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

    //DAO user test
    @Test
    public void testDAOGetUserEmail() throws Exception {
        String expectedEmail = "Redroom4hire@blackmail.onion";
        CupcakeDAO dao = new CupcakeDAO();
        User user = dao.getUser("pinky");
        String actualEmail = user.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testDAOBalanceBygetAllToppings() throws Exception {
        double expected = 5.0;
        CupcakeDAO dao = new CupcakeDAO();
        ArrayList<Topping> list = dao.getAllToppings();
        Topping topping = list.get(1);
        double actual = topping.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testDAOCreateDeleteUser() throws Exception {
        User user = new User("testUser", "testPassword", "testEmail");
        User fetchUser = null;
        
        String ExpectedPass = "testPassword";
        CupcakeDAO dao = new CupcakeDAO();
        dao.createUser(user);
        fetchUser = dao.getUser("testUser");
        String ActualPass = fetchUser.getPassword();
        assertEquals(ExpectedPass, ActualPass);
        try {
            dao.deleteUser(user);
            dao.deleteUser(fetchUser);
        } catch (Exception e) {
            System.out.println("Deletion in testDAOCreateDeleteUser Failed..");
        }
    }

    @Test
    public void testDAOCreateReadUpdateDeleteUser() throws Exception {
        User user = new User("testUser2", "testPassword2", "testEmail2");
        User userToUpdate = new User("testUser3", "testPassword3", "testEmail3");

        String ExpectedPass = "testPassword3";
        CupcakeDAO dao = new CupcakeDAO();
        dao.createUser(user);
        user = userToUpdate;
        dao.updateUser(user);
        String ActualPass = user.getPassword();
        assertEquals(ExpectedPass, ActualPass);
        try {
            dao.deleteUser(user);
        } catch (Exception e) {
            System.out.println("Deletion in testDAOCreateReadDeleteUser Failed..");
        }
    }
}
