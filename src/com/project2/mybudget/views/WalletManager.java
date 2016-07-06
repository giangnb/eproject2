/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.views;

import com.project2.mybudget.App;
import com.project2.mybudget.data.Json;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Wallet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project2.mybudget.controllers.WalletsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duchv
 */


public class WalletManager extends javax.swing.JFrame {

    /**
     * Creates new form WalletManager
     */
    //enum btn {"Update", "Add"};
    List<Wallet> list;

    public WalletManager() {
        initComponents();
        setResizable(false);
        setTitle("MyBudget - Wallet");
        txtWalletName.setEnabled(false);
        txtWalletType.setEnabled(false);
        cbbWalletType.setEnabled(false);
        loadWalletName();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNewWallet = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        txtWalletName = new java.awt.TextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        cbbWalletType = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddorUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listWallet = new java.awt.List();
        txtWalletType = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("Wallet Manager");

        btnNewWallet.setLabel("New Wallet");
        btnNewWallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewWalletActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Wallet Name");

        label1.setForeground(new java.awt.Color(255, 0, 0));

        label2.setText("Wallet Type");

        cbbWalletType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Creadit Card", "Bank Account", "Other", " " }));
        cbbWalletType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbWalletTypeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAddorUpdate.setText("Update");
        btnAddorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddorUpdateActionPerformed(evt);
            }
        });

        listWallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWalletMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listWallet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(btnNewWallet, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(30, 30, 30)
                                .addComponent(btnAddorUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbWalletType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtWalletName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtWalletType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnNewWallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtWalletName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbWalletType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(txtWalletType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnDelete)
                            .addComponent(btnAddorUpdate)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddorUpdateActionPerformed
        // TODO add your handling code here:
        Wallet wallet = new Wallet();

        String cbbSelected = null;

        if (cbbWalletType.getSelectedItem().toString() == "Other") {
            cbbSelected = txtWalletType.getText();
        } else {
            cbbSelected = cbbWalletType.getSelectedItem().toString();
        }
        if (btnAddorUpdate.getText() == "Add") {
            Wallet.Info info = new Wallet.Info();
            info.setName(txtWalletName.getText());
            info.setType(cbbSelected);

            try {
                boolean result = new WalletsController().AddNewWallet(info);
                JOptionPane.showMessageDialog(this, result + "\n Added Wallet " + txtWalletName.getText() + " Success");

            } catch (SQLException ex) {
                Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AppException ex) {
                Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                String walletSelected = listWallet.getSelectedItem();

                Wallet.Info info = new Wallet.Info();
                info.setName(txtWalletName.getText());
                info.setType(cbbSelected);
                String Id = String.valueOf(new WalletsController().getWalletId(walletSelected));
                boolean result = new WalletsController().EditWallet(info, Id);
                JOptionPane.showMessageDialog(this, result + "Update Success Wallet" + txtWalletName.getText());
            } catch (AppException ex) {
                Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnAddorUpdateActionPerformed


    private void cbbWalletTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbWalletTypeActionPerformed
        // TODO add your handling code here:
        if (cbbWalletType.getSelectedItem() == "Other") {
            txtWalletType.setEnabled(true);
            cbbWalletType.setEnabled(false);
        }
    }//GEN-LAST:event_cbbWalletTypeActionPerformed

    private void btnNewWalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewWalletActionPerformed
        // TODO add your handling code here:
        //btnAddorUpdate.setLabel(btnLabel.Add.toString());
        btnAddorUpdate.setLabel("Add");
        txtWalletName.setText("");
        txtWalletType.setText("");
        txtWalletName.setEnabled(true);
        cbbWalletType.setEnabled(true);

    }//GEN-LAST:event_btnNewWalletActionPerformed


    private void listWalletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWalletMouseClicked
        // TODO add your handling code here:
        btnAddorUpdate.setLabel("Update");

        String walletSelected = listWallet.getSelectedItem();
        String Type;
        try {
            Type = new WalletsController().loadWalletType(walletSelected);
            if (!Type.equals("Cash") || !Type.equals("Creadit Card") || !Type.equals("Bank Account")) {
                txtWalletType.setEnabled(true);
                cbbWalletType.setSelectedItem("Other");
                txtWalletType.setText(Type);
            }
            cbbWalletType.setSelectedItem(Type);

        } catch (AppException ex) {
            Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtWalletName.setText(walletSelected);
        txtWalletName.setEnabled(true);
        cbbWalletType.setEnabled(true);
    }//GEN-LAST:event_listWalletMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String walletSelected = listWallet.getSelectedItem();
        int Id = new WalletsController().getWalletId(walletSelected);
        try {
            boolean result = new WalletsController().DeleteWallet(Id);
            JOptionPane.showMessageDialog(this, result + "\n Delete Success.");
        } catch (AppException ex) {
            Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    private void loadWalletName() {
        list = new ArrayList<>();
        try {
            list = new WalletsController().getWallet();
            for (Wallet item : list) {
                listWallet.add(item.getInfo().getName());
            }
        } catch (AppException ex) {
            Logger.getLogger(WalletManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(WalletManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WalletManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WalletManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WalletManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WalletManager().setVisible(true);
                new WalletManager().setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddorUpdate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private java.awt.Button btnNewWallet;
    private javax.swing.JComboBox<String> cbbWalletType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.List listWallet;
    private java.awt.TextField txtWalletName;
    private java.awt.TextField txtWalletType;
    // End of variables declaration//GEN-END:variables
}
