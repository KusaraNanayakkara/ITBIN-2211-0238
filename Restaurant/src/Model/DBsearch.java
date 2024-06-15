package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DBsearch {

    Statement stmt;
    ResultSet rs;

    public ResultSet searchLogin(String usName) {
        try {
            stmt = DBconnection.getStatementConnection();
            String name = usName;
//Execute the Query
            rs = stmt.executeQuery("SELECT * FROM user where Username='" + name + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchOrder(){
        
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cake", "root", "");
            String query = "SELECT * FROM order_items";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    

}
