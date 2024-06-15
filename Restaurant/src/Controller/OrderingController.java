package controller;

import Model.OrderingModel;
import model.DBconnection;
import model.DBsearch;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderingController {
    public void saveOrder(String name, String contact, String address, String total) {
        try {
            Statement stmt = DBconnection.getStatementConnection();
            String query = "INSERT INTO order_items(Name, Contact, Address, total) VALUES('" + name + "','" + contact + "','" + address + "','" + total + "')";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getOrders() {
        return new DBsearch().searchOrder();
    }

    public double getPricePerKg(String cakeName) {
        return new OrderingModel().getPricePerKg(cakeName);
    }

    public void deleteOrder(String orderId) {
        try {
            Statement stmt = DBconnection.getStatementConnection();
            String query = "DELETE FROM order_items WHERE OrderID = '" + orderId + "'";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
