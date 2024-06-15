/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import controller.OrderingController;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Ordering extends javax.swing.JFrame {
    
    private OrderingController orderingController = new OrderingController();



    public Ordering() {
        initComponents();
        addEventListeners();
        saveDataToTable();
        
    }
            private void saveDataToTable() {
        ResultSet rs = orderingController.getOrders();
        try {
            DefaultTableModel model = (DefaultTableModel) otable.getModel();
            model.setRowCount(0); // Clear existing data in the table
            while (rs.next()) {
                String orderID = rs.getString("OrderID");
                String name = rs.getString("Name");
                String telephone = rs.getString("Contact");
                String address = rs.getString("Address");
                String total = rs.getString("total");
                String[] tbData = {orderID, name, telephone, address, total};
                model.addRow(tbData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
             private void clear() {
        name.setText("");
        telephone.setText("");
        address.setText("");
        choco.setText("");
        butter.setText("");
        ribbon.setText("");
        birthday.setText("");
        coffee.setText("");
        red.setText("");
        chocoprice.setText("");
        butterprice.setText("");
        ribbonprice.setText("");
        birthdayprice.setText("");
        coffeeprice.setText("");
        redprice.setText("");
        total.setText("");
    }
             
private void addEventListeners() {
        // Add key listeners to quantity fields to update prices automatically
        choco.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updatePrice("Chocolate Cake", choco, chocoprice);
            }
        });
        butter.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               updatePrice("Butter Cake", butter, butterprice);
            }
        });
        ribbon.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updatePrice("Ribbon Cake", ribbon, ribbonprice);
            }
        });
        birthday.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               updatePrice("Birthday Cake", birthday, birthdayprice);
            }
        });
        coffee.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updatePrice("Coffee Cake", coffee, coffeeprice);
            }
        });
        red.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               updatePrice("Red Velvet Cake", red, redprice);
            }
        });
    }

 private void updatePrice(String cakeName, javax.swing.JTextField quantityField, javax.swing.JTextField priceField) {
        try {
            int quantity = Integer.parseInt(quantityField.getText());
            if (quantityField.getText().isEmpty()) {
                quantity = 0;
                double pricePerKg = orderingController.getPricePerKg(cakeName);
                double totalPrice = quantity * pricePerKg;
                priceField.setText(String.valueOf(totalPrice));
                updateTotalPrice();
            } else {
                double pricePerKg = orderingController.getPricePerKg(cakeName);
                double totalPrice = quantity * pricePerKg;
                priceField.setText(String.valueOf(totalPrice));
                updateTotalPrice();
            }
        } catch (NumberFormatException e) {
            priceField.setText("0.0");
        }
    }
 
 private void updateTotalPrice() {
        try {
            double totalPrice = Double.parseDouble(chocoprice.getText())
                    + Double.parseDouble(butterprice.getText())
                    + Double.parseDouble(ribbonprice.getText())
                    + Double.parseDouble(birthdayprice.getText())
                    + Double.parseDouble(coffeeprice.getText())
                    + Double.parseDouble(redprice.getText());
            total.setText(String.valueOf(totalPrice));
        } catch (NumberFormatException e) {
            total.setText("0.0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        redprice = new javax.swing.JTextField();
        telephone = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        chocoprice = new javax.swing.JTextField();
        butterprice = new javax.swing.JTextField();
        ribbonprice = new javax.swing.JTextField();
        birthdayprice = new javax.swing.JTextField();
        coffeeprice = new javax.swing.JTextField();
        red = new javax.swing.JTextField();
        choco = new javax.swing.JTextField();
        butter = new javax.swing.JTextField();
        ribbon = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        coffee = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        otable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 245, 231));
        jPanel1.setForeground(new java.awt.Color(167, 114, 125));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Pristina", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(167, 114, 125));
        jLabel1.setText("Order Page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 270, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Contact Number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 149, 27));

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText("Address");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 83, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(167, 114, 125));
        jLabel4.setText("Item");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 84, 41));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(167, 114, 125));
        jLabel5.setText("Quantity (Kg)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 170, 41));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(167, 114, 125));
        jLabel6.setText("Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 70, 41));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Chocolate Cake");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Butter Cake");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Ribbon Cake");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Birthday Cake");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Coffee Cake");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Red Velvet Cake");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 690, -1, -1));

        jButton1.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N
        jButton1.setText("Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 720, 130, 37));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("    Total");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 750, 90, -1));

        jLabel16.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 116, 140, 150));

        saveButton.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 90, 40));
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 740, 150, 40));

        redprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redpriceActionPerformed(evt);
            }
        });
        jPanel1.add(redprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 690, 150, 30));

        telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneActionPerformed(evt);
            }
        });
        jPanel1.add(telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 390, 40));

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 390, 40));

        chocoprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chocopriceActionPerformed(evt);
            }
        });
        jPanel1.add(chocoprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 150, 30));
        jPanel1.add(butterprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 150, 30));
        jPanel1.add(ribbonprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 150, 30));

        birthdayprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdaypriceActionPerformed(evt);
            }
        });
        jPanel1.add(birthdayprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 590, 150, 30));
        jPanel1.add(coffeeprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, 150, 30));
        jPanel1.add(red, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 690, 80, 30));

        choco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chocoActionPerformed(evt);
            }
        });
        jPanel1.add(choco, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 80, 30));
        jPanel1.add(butter, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 80, 30));
        jPanel1.add(ribbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 80, 30));
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 80, 30));
        jPanel1.add(coffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, 80, 30));

        deleteButton.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 720, 90, 40));

        otable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order_ID", "Name", "Contact", "Address", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(otable);
        if (otable.getColumnModel().getColumnCount() > 0) {
            otable.getColumnModel().getColumn(1).setResizable(false);
            otable.getColumnModel().getColumn(2).setResizable(false);
            otable.getColumnModel().getColumn(3).setResizable(false);
            otable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 590, 370));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 51));
        jLabel14.setText("Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 70, 27));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 390, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Documents\\NetBeansProjects\\Restaurant\\src\\Image\\pexels.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 1410, 920));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 1410, 860));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Paymentform().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String Name = name.getText();
        String Contact =telephone.getText();
        String Address =address.getText();
        String Total = total.getText();
       
        orderingController.saveOrder(Name, Contact, Address, Total);
        saveDataToTable();
        clear();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void redpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redpriceActionPerformed

    private void telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
            try {
            int selectedRowIndex = otable.getSelectedRow();
            if (selectedRowIndex != -1) {
                String Order_ID = otable.getValueAt(selectedRowIndex, 0).toString();
                orderingController.deleteOrder(Order_ID);
                DefaultTableModel model = (DefaultTableModel) otable.getModel();
                model.removeRow(selectedRowIndex);
                JOptionPane.showMessageDialog(this, "Data deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        clear();
    
    }//GEN-LAST:event_deleteButtonActionPerformed

   

    
    
    private void chocopriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocopriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chocopriceActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void birthdaypriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdaypriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdaypriceActionPerformed

    private void chocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chocoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ordering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(() -> {
            new Ordering().setVisible(true);
        });
        
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField birthday;
    private javax.swing.JTextField birthdayprice;
    private javax.swing.JTextField butter;
    private javax.swing.JTextField butterprice;
    private javax.swing.JTextField choco;
    private javax.swing.JTextField chocoprice;
    private javax.swing.JTextField coffee;
    private javax.swing.JTextField coffeeprice;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTable otable;
    private javax.swing.JTextField red;
    private javax.swing.JTextField redprice;
    private javax.swing.JTextField ribbon;
    private javax.swing.JTextField ribbonprice;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField telephone;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}