/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class OrderingModel {
    
    
     public double getPricePerKg(String cakeName) {
        double pricePerKg = 0.0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cake", "root", "");
            String query = "SELECT PricePerKg FROM cakes WHERE CakeName = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cakeName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pricePerKg = rs.getDouble("PricePerKg");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return pricePerKg;
    }
    
    public void saveOrder(String name, String contact, String address, String total) {
        try {
            Statement stmt = DBconnection.getStatementConnection();
            stmt.executeUpdate("INSERT INTO order_items(Name,Contact,Address,total)VALUES('" + name + "','" + contact + "','" + address + "','" + total + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet fetchOrders() {
        return new DBsearch().searchOrder();
    }

    public void deleteOrder(String orderID) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cake", "root", "");
            String sql = "DELETE FROM order_items WHERE Name = ?";
            PreparedStatement ptst = con.prepareStatement(sql);
            ptst.setString(1, orderID);
            ptst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   /* public ResultSet searchOrder() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cake", "root", "");
            String query = "SELECT * FROM order_items";
            PreparedStatement pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return rs;
    }*/  
}