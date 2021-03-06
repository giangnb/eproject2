/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project2.mybudget.views;

import com.project2.mybudget.App;
import com.project2.mybudget.exception.AppException;
import com.project2.mybudget.models.Data;
import com.project2.mybudget.models.Wallet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Giang
 */
public class Report extends javax.swing.JFrame {

    NumberFormat numberFmt;

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();

        numberFmt = NumberFormat.getInstance();
        txtEarnReason1.setText("");
        txtEarnReason2.setText("");
        txtEarnReason3.setText("");
        txtSpendReason1.setText("");
        txtSpendReason2.setText("");
        txtSpendReason3.setText("");

        initWalletList();
        initDateChooser();

        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        cboWallet = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateFrom = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        dateTo = new datechooser.beans.DateChooserCombo();
        pnlChart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalEarn = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalSpend = new javax.swing.JLabel();
        txtMoneyStatus = new javax.swing.JLabel();
        txtMoneyBalance = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txtSpendReason1 = new javax.swing.JLabel();
        txtSpendReason2 = new javax.swing.JLabel();
        txtSpendReason3 = new javax.swing.JLabel();
        txtEarnReason1 = new javax.swing.JLabel();
        txtEarnReason2 = new javax.swing.JLabel();
        txtEarnReason3 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("You spent");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("{{spend}}");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your budget at a glance");

        btnRefresh.setBackground(new java.awt.Color(239, 239, 239));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/project2/mybudget/images/btn_refresh.png"))); // NOI18N
        btnRefresh.setToolTipText("Refresh");
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("wallet");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("from");

        dateFrom.setFormat(1);
        dateFrom.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("to");

        dateTo.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("You earned");

        txtTotalEarn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotalEarn.setForeground(new java.awt.Color(0, 102, 0));
        txtTotalEarn.setText("{{earn}}");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("You spent");

        txtTotalSpend.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotalSpend.setForeground(new java.awt.Color(102, 0, 0));
        txtTotalSpend.setText("{{spend}}");

        txtMoneyStatus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtMoneyStatus.setText("{{saved}}");

        txtMoneyBalance.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMoneyBalance.setText("{{amount}}");

        jLabel13.setText("You mostly spent money for:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel14.setText("Your money mostly came from:");

        txtSpendReason1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSpendReason1.setText("jLabel15");

        txtSpendReason2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSpendReason2.setText("jLabel16");

        txtSpendReason3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSpendReason3.setText("jLabel17");

        txtEarnReason1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEarnReason1.setText("jLabel18");

        txtEarnReason2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEarnReason2.setText("jLabel19");

        txtEarnReason3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEarnReason3.setText("jLabel20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotalEarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMoneyBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMoneyStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalSpend, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboWallet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(txtSpendReason1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSpendReason2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSpendReason3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEarnReason1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEarnReason2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEarnReason3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboWallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalEarn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalSpend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMoneyStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMoneyBalance)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEarnReason1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEarnReason2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEarnReason3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSpendReason1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSpendReason2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSpendReason3))
                    .addComponent(jSeparator2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    public static void run() {
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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<Wallet> cboWallet;
    private datechooser.beans.DateChooserCombo dateFrom;
    private datechooser.beans.DateChooserCombo dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JLabel txtEarnReason1;
    private javax.swing.JLabel txtEarnReason2;
    private javax.swing.JLabel txtEarnReason3;
    private javax.swing.JLabel txtMoneyBalance;
    private javax.swing.JLabel txtMoneyStatus;
    private javax.swing.JLabel txtSpendReason1;
    private javax.swing.JLabel txtSpendReason2;
    private javax.swing.JLabel txtSpendReason3;
    private javax.swing.JLabel txtTotalEarn;
    private javax.swing.JLabel txtTotalSpend;
    // End of variables declaration//GEN-END:variables

    private void initWalletList() {
        try {
            DefaultComboBoxModel<Wallet> model = new DefaultComboBoxModel<>();
            model.addElement(new Wallet(0, new Wallet.Info("(all wallets)", "")));
            for (Wallet w : App.WALLET.getWallet()) {
                model.addElement(w);
            }
            cboWallet.setModel(model);
        } catch (AppException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initDateChooser() {
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        d.setTime(d.getTime() - 1000 * 60 * 60 * 24 * 7);
        cal.setTime(d);
        dateFrom.setSelectedDate(cal);

        dateFrom.setMaxDate(dateTo.getCurrent());
        dateTo.setMinDate(dateFrom.getCurrent());
    }

    private void initData() {
        ArrayList<Data> list = new ArrayList<>();
        if (((Wallet) cboWallet.getSelectedItem()).getWalletId() == 0) {
            // All wallets
            App.DATA.loadDataByDate(dateFrom.getSelectedDate().getTime(), dateTo.getSelectedDate().getTime());
            list = App.DATA.getBudget();
        } else {
            // Selected wallet
            App.DATA.loadDataByDateAndWallet(dateFrom.getSelectedDate().getTime(), dateTo.getSelectedDate().getTime(), (Wallet) cboWallet.getSelectedItem());
            list = App.DATA.getBudget();
        }

        double earn = 0d, spend = 0d, balance = 0d;
        for (Data d : list) {
            if (d.getAmount() > 0) {
                earn += d.getAmount();
            } else {
                spend += (-d.getAmount());
            }
        }
        balance = earn - spend;
        txtTotalEarn.setText(numberFmt.format(earn));
        txtTotalSpend.setText(numberFmt.format(spend));
        if (balance > 0) {
            txtMoneyStatus.setText("You saved");
            txtMoneyStatus.setForeground(Color.green);
            txtMoneyBalance.setText(numberFmt.format(balance));
        } else if (balance < 0) {
            txtMoneyStatus.setText("You're in red");
            txtMoneyStatus.setForeground(Color.red);
            txtMoneyBalance.setText(numberFmt.format(-balance));
        } else {
            txtMoneyStatus.setText("Nothing left in pocket");
            txtMoneyStatus.setForeground(Color.darkGray);
            txtMoneyBalance.setText("");
        }

        JFreeChart jFreeChart = initChartObject(earn, spend);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(getSize().width, getSize().height));
        chartPanel.setMouseWheelEnabled(true);
        pnlChart.removeAll();
        pnlChart.add(chartPanel);

        initReasonCount(list);
    }

    private JFreeChart initChartObject(double earn, double spend) {
        DefaultPieDataset ds = new DefaultPieDataset();
        ds.setValue((Comparable) ((Object) "Income"), earn);
        ds.setValue((Comparable) ((Object) "Expense"), spend);

        JFreeChart jFreeChart = ChartFactory.createPieChart((String) "", (PieDataset) ds, (boolean) false, (boolean) true, (boolean) false);
        PiePlot piePlot = (PiePlot) jFreeChart.getPlot();
        piePlot.setSectionPaint((Comparable) ((Object) "Income"), (Paint) new Color(86, 255, 63));
        piePlot.setSectionPaint((Comparable) ((Object) "Expense"), (Paint) new Color(255, 103, 49));
        piePlot.setNoDataMessage("No data available");
        piePlot.setExplodePercent((Comparable) ((Object) "Two"), 0.2);
        piePlot.setLabelGenerator((PieSectionLabelGenerator) new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
        //piePlot.setLabelBackgroundPaint((Paint)new Color(220, 220, 220));
        piePlot.setLegendLabelToolTipGenerator((PieSectionLabelGenerator) new StandardPieSectionLabelGenerator("Tooltip for legend item {0}"));
        piePlot.setSimpleLabels(true);
        piePlot.setInteriorGap(0.1);

        return jFreeChart;
    }

    private void initReasonCount(ArrayList<Data> list) {
        HashSet<String> set = new HashSet<>();
        for (Data d : list) {
            if (d.getAmount() > 0) {
                set.add(d.getReason());
            }
        }

        Hashtable<String, Integer> countEarn = new Hashtable<>();
        for (String s : set) {
            countEarn.put(s, 0);
        }
        for (Data d : list) {
            if (d.getAmount() > 0) {
                Integer i = countEarn.get(d.getReason()) + 1;
                countEarn.put(d.getReason(), i);
            }
        }

        set.clear();

        for (Data d : list) {
            if (d.getAmount() < 0) {
                set.add(d.getReason());
            }
        }

        Hashtable<String, Integer> countSpend = new Hashtable<>();
        for (String s : set) {
            countSpend.put(s, 0);
        }
        for (Data d : list) {
            if (d.getAmount() < 0) {
                Integer i = countSpend.get(d.getReason()) + 1;
                countSpend.put(d.getReason(), i);
            }
        }

        try {
            int maxValue;
            String maxKey;
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countEarn.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtEarnReason1.setText(" - "+maxKey);
            countEarn.remove(maxKey);
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countEarn.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtEarnReason2.setText(" - "+maxKey);
            countEarn.remove(maxKey);
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countEarn.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtEarnReason3.setText(" - "+maxKey);
            countEarn.remove(maxKey);
        } catch (Exception e) {
            // ignore
        }
        
        try {
            int maxValue;
            String maxKey;
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countSpend.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtSpendReason1.setText(" - "+maxKey);
            countSpend.remove(maxKey);
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countSpend.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtSpendReason2.setText(" - "+maxKey);
            countSpend.remove(maxKey);
            maxValue = 0;
            maxKey = "";
            for (Map.Entry<String, Integer> entry : countSpend.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            txtSpendReason3.setText(" - "+maxKey);
            countSpend.remove(maxKey);
        } catch (Exception e) {
            // ignore
        }
    }
}
