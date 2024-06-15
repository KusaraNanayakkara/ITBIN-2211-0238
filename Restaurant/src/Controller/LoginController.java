package controller;

import View.Login;
import View.Menu;
import model.DBconnection;
import model.DBsearch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class LoginController {

    public static void login(String Uname, String Pword) {
        try {
            String Username = null; // initial value of the username
            String Password = null; // initial value of the password
            ResultSet rs = new DBsearch().searchLogin(Uname);
//Process the Query
            while (rs.next()) {
                Username = rs.getString("Username"); //assign database login name to the variable
                Password = rs.getString("Password"); //assign database password to the variable
            }
            if (Username != null && Password != null) {
                if (Password.equals(Pword)) {
                    System.out.println("Login Successfull");
                    Login.getFrames()[0].dispose();
                    new Menu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please check the Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
            DBconnection.closeCon();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
