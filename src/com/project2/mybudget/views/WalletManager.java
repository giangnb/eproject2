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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duchv
 */
enum btnLabel {Add, Update}

public class WalletManager extends javax.swing.JFrame {

    /**
     * Creates new form WalletManager
     */
    //enum btn {"Update", "Add"};
    List<String> list;
    Wallet.Info winfo;
    String buttonLabel = null;
    DefaultTableModel model = new DefaultTableModel();
    public WalletManager() {
        initComponents();
        setResizable(false);
        txtWalletName.setEnabled(false);
        cbbWalletType.setEnabled(false);
        model.addColumn("My Wallet");
        tblWalletName.setSize(100, 360);
        tblWalletName.setModel(model);
        loadWalletName();
        TableAddListener();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWalletName = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtWalletName = new java.awt.TextField();
        label1 = new java.awt.Label();
        txtWalletType = new java.awt.TextField();
        label2 = new java.awt.Label();
        cbbWalletType = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddorUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("Wallet Manager");

        btnNewWallet.setLabel("New Wallet");
        btnNewWallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewWalletActionPerformed(evt);
            }
        });

        tblWalletName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "My Wallets"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWalletName);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Wallet Name");

        label1.setForeground(new java.awt.Color(255, 0, 0));

        txtWalletType.setEnabled(false);
        txtWalletType.setName(""); // NOI18N

        label2.setText("Wallet Type");

        cbbWalletType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Creadit Card", "Bank Account", "Other", " " }));
        cbbWalletType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbWalletTypeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");

        btnDelete.setText("Delete");

        btnAddorUpdate.setText("Update");
        btnAddorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddorUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbWalletType, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWalletType, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(txtWalletName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(30, 30, 30)
                                .addComponent(btnAddorUpdate)
                                .addGap(27, 27, 27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnNewWallet, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(25, 25, 25)
                        .addComponent(txtWalletType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbWalletType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnDelete)
                            .addComponent(btnAddorUpdate)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddorUpdateActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btnAddorUpdateActionPerformed
   
     private void TableAddListener () {
         //tblWalletName.add(listener);
         ListSelectionModel rowSelectionModel = tblWalletName.getSelectionModel();
         rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                btnAddorUpdate.setLabel(btnLabel.Update.toString());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 int selectedWallet = tblWalletName.getSelectedRow();
                 String RowValue = (String) tblWalletName.getValueAt(selectedWallet, 0);
                 txtWalletName.setText(RowValue);
                 txtWalletName.setEnabled(true);                 
             }
         });
     } 
     
    private void cbbWalletTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbWalletTypeActionPerformed
        // TODO add your handling code here:
        if (cbbWalletType.getSelectedItem() == "Other") {
            txtWalletType.setEnabled(true);
            cbbWalletType.setEnabled(false);
        }
    }//GEN-LAST:event_cbbWalletTypeActionPerformed

    private void btnNewWalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewWalletActionPerformed
        // TODO add your handling code here:
        btnAddorUpdate.setLabel(btnLabel.Add.toString());
        txtWalletName.setEnabled(true);
        cbbWalletType.setEnabled(true);
        
    }//GEN-LAST:event_btnNewWalletActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    private void loadWalletName () {
       list = new ArrayList<>();
       winfo = new Wallet.Info();
        try {
            list = new WalletsController().getWalletInfo();
            for(String item:list) {
                winfo = Json.DeserializeObject(item, Wallet.Info.class);
                String[] row = {winfo.getName()};
                model.addRow(row);
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
    private javax.swing.JTable tblWalletName;
    private java.awt.TextField txtWalletName;
    private java.awt.TextField txtWalletType;
    // End of variables declaration//GEN-END:variables
}
