package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DBconnection {

    static Connection conn;
    static Statement stat = null;
    

    public static Statement getStatementConnection() {
        try {
//Establish the connection
            String url = "jdbc:mysql://localhost:3307/cake";
            conn = DriverManager.getConnection(url, "root", "");
//Create the connection
            stat = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }
    //Close the connection

    public static void closeCon() throws SQLException {
        conn.close();
    }
}
