/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.views;

import com.project2.mybudget.App;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Giang
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        setIconImage(App.ICON);
        setSize((int)Math.round(App.SCREEN_SIZE.width/1.5), (int)Math.round(App.SCREEN_SIZE.height/1.5));
        setLocationRelativeTo(null);
        setTitle("MyBudget - [" + App.ACCOUNT.getAccount().getInfo().getName() + "]");
        setMinimumSize(new Dimension(450, 380));

        setGreetingLabel();

        tabPaneInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGreeting = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tabMain = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBudget = new javax.swing.JMenu();
        miIncome = new javax.swing.JMenuItem();
        miExpense = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miReport = new javax.swing.JMenuItem();
        menuWallet = new javax.swing.JMenu();
        miWallets = new javax.swing.JMenuItem();
        miNewWallet = new javax.swing.JMenuItem();
        menuAccount = new javax.swing.JMenu();
        miAccount = new javax.swing.JMenuItem();
        miLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSettings = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        miInstructions = new javax.swing.JMenuItem();
        miAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyBudget");
        setBackground(new java.awt.Color(255, 255, 204));

        lblGreeting.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        lblGreeting.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGreeting.setText("jLabel1");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 51));

        menuBudget.setText("Budget");

        miIncome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miIncome.setText("Add new income");
        miIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIncomeActionPerformed(evt);
            }
        });
        menuBudget.add(miIncome);

        miExpense.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miExpense.setText("Add new expense");
        menuBudget.add(miExpense);
        menuBudget.add(jSeparator2);

        miReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miReport.setText("View report");
        menuBudget.add(miReport);

        jMenuBar1.add(menuBudget);

        menuWallet.setText("Wallets");

        miWallets.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miWallets.setText("My wallets");
        menuWallet.add(miWallets);

        miNewWallet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miNewWallet.setText("New wallet");
        menuWallet.add(miNewWallet);

        jMenuBar1.add(menuWallet);

        menuAccount.setText("Account");

        miAccount.setText("My account");
        miAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAccountActionPerformed(evt);
            }
        });
        menuAccount.add(miAccount);

        miLogout.setText("Logout");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        menuAccount.add(miLogout);
        menuAccount.add(jSeparator1);

        miSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miSettings.setText("Settings");
        miSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSettingsActionPerformed(evt);
            }
        });
        menuAccount.add(miSettings);

        jMenuBar1.add(menuAccount);

        menuHelp.setText("Help");

        miInstructions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        miInstructions.setText("How to use");
        miInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInstructionsActionPerformed(evt);
            }
        });
        menuHelp.add(miInstructions);

        miAbout.setText("About");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        menuHelp.add(miAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabMain)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGreeting, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGreeting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miIncomeActionPerformed

    private void miSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miSettingsActionPerformed

    private void miAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAccountActionPerformed
        JDialog d = new JDialog(this, "MyBudget - Account", true);
        Container content = new AccountDescription().getContentPane();
        d.setContentPane(content);
        d.setSize(content.getSize().width, content.getSize().height + 30);
        d.setLocationRelativeTo(this);
        d.setResizable(false);
        d.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                setGreetingLabel();
            }
        });
        d.setVisible(true);
    }//GEN-LAST:event_miAccountActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to logout now?",
                "MyBudget - Logout", JOptionPane.YES_NO_OPTION);
        // choice: 0 = YES ; 1 = NO
        if (choice == 0) {
            App.ACCOUNT.logout();
            this.dispose();
        }
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutActionPerformed
        JDialog d = new JDialog(this, "MyBudget - Introduction", true);
        Container content = new MainAbout();
        d.setContentPane(content);
        d.setSize(300, 180);
        d.setLocationRelativeTo(this);
        d.setResizable(false);
        d.setVisible(true);
    }//GEN-LAST:event_miAboutActionPerformed

    private void miInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInstructionsActionPerformed
        JDialog d = new JDialog(this, "How to use MyBudget", true);
        Container content = new MainInstructions().getContentPane();
        d.setContentPane(content);
        d.setMaximumSize(new Dimension(180, 220));
        d.setSize(420, 420);
        d.setLocationRelativeTo(this);
        d.setResizable(true);
        d.setVisible(true);
    }//GEN-LAST:event_miInstructionsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new WindowsLookAndFeel());
                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuBudget;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuWallet;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miAccount;
    private javax.swing.JMenuItem miExpense;
    private javax.swing.JMenuItem miIncome;
    private javax.swing.JMenuItem miInstructions;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miNewWallet;
    private javax.swing.JMenuItem miReport;
    private javax.swing.JMenuItem miSettings;
    private javax.swing.JMenuItem miWallets;
    private javax.swing.JTabbedPane tabMain;
    // End of variables declaration//GEN-END:variables

    /**
     * Initialize tabs for tabMain element
     */
    private void tabPaneInit() {
        Component report, wallets;
        report = new JScrollPane(new Report().getContentPane());
        tabMain.add("Report", report);
    }

    private void setGreetingLabel() {
        SimpleDateFormat df = new SimpleDateFormat("H");
        String greeting = "Hi";
        try {
            int hr = Integer.parseInt(df.format(Calendar.getInstance().getTime()));
            greeting = "Good ";
            if (hr >= 0 && hr <= 11) {
                greeting += "morning";
            } else if (hr >= 12 && hr <= 17) {
                greeting += "afternoon";
            } else {
                greeting += "evening";
            }
        } catch (Exception e) {
            greeting = "Hello";
        }

        lblGreeting.setText(greeting + ", " + App.ACCOUNT.getAccount().getInfo().getName() + "!  ");
    }
}
