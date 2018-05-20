/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PC-08
 */
public final class Session extends javax.swing.JFrame {

    DatabaseConnection db = new DatabaseConnection();
    public static String lasttime = "";
    public static String ipadd = "";

    /**
     * Creates new form Session
     */
    public Session() {
    }

    public Session(String time, String ip) {
        ipadd = ip;
        initComponents();
        System.out.println("time= " + time);
        System.out.println("ip= " + ip);
        try {
            int index = time.indexOf(":");
            int lastindex = time.indexOf(":", index + 1);
            int hour = Integer.parseInt(time.substring(0, index));
            System.out.println("hour=" + hour);
            int minute = Integer.parseInt(time.substring(index + 1, lastindex));
            System.out.println("minute=" + minute);

            String firsttime = String.valueOf(hour) + ":" + minute + ":00";
            System.out.println("firsttime= " + firsttime);
            if (minute < 55) {
                lasttime = String.valueOf(hour) + ":" + String.valueOf(minute + 5) + ":00";
            } else {
                if (minute == 55) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(0) + ":00";
                }
                if (minute == 56) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(1) + ":00";
                }
                if (minute == 57) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(2) + ":00";
                }
                if (minute == 58) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(3) + ":00";
                }
                if (minute == 59) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(4) + ":00";
                }
                if (minute == 60) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(5) + ":00";
                }
            }
            System.out.println("lasttime= " + lasttime);
            String Query = "select * from log where(time between '" + firsttime + "' and '" + lasttime + "') and fromip='" + ip + "'";
            db.dbconnection();
            ResultSet rs1 = db.getResultSet(Query);
            if (rs1.next()) {
                rs1.previous();
                tblsession.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            LogFrame.setTableDesign(tblsession);
        }
        catch (SQLException ex) {
            Logger.getLogger(IpAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblsession.show();
    }

    public Session(String ip) {
        initComponents();
        ipadd = ip;
        String time = "";
        try {
            String query = "select time from log where fromip='" + ip + "'";
            db.dbconnection();
            ResultSet rs = db.getResultSet(query);
            if (rs.next()) {
                time = rs.getString(1);
            }
            rs.last();
            String endtime = rs.getString(1);
            System.out.println("endtime= " + endtime);
            int hour = Integer.parseInt(time.substring(0, 2));
            System.out.println("hour=" + hour);
            int minute = Integer.parseInt(time.substring(3, 5));
            System.out.println("minute=" + minute);

            String firsttime = String.valueOf(hour) + ":" + minute + ":00";

            if (minute < 55) {
                lasttime = String.valueOf(hour) + ":" + String.valueOf(minute + 2) + ":00";
            } else {
                if (minute == 55) {
                    lasttime = String.valueOf(hour + 1) + ":" + String.valueOf(0) + ":00";
                }
                if (minute == 56) {
                    lasttime = String.valueOf(hour) + ":" + String.valueOf(1) + ":00";
                }
                if (minute == 57) {
                    lasttime = String.valueOf(hour) + ":" + String.valueOf(2) + ":00";
                }
                if (minute == 58) {
                    lasttime = String.valueOf(hour) + ":" + String.valueOf(3) + ":00";
                }
                if (minute == 59) {
                    lasttime = String.valueOf(hour) + ":" + String.valueOf(4) + ":00";
                }
                if (minute == 60) {
                    lasttime = String.valueOf(hour) + ":" + String.valueOf(5) + ":00";
                }
            }
            //System.out.println("lasttime= "+lasttime);
            String Query = "select * from log where(time between '" + firsttime + "' and '" + lasttime + "') and fromip='" + ip + "' ";
            db.dbconnection();
            ResultSet rs1 = db.getResultSet(Query);
            if (rs1.next()) {
                rs1.previous();
                tblsession.setModel(DbUtils.resultSetToTableModel(rs1));
            } 
            else {
                JOptionPane.showMessageDialog(null, "No more entries ");
            }
            LogFrame.setTableDesign(tblsession);
        }
        catch (SQLException ex) {
            Logger.getLogger(IpAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblsession.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblsession = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblsession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblsession);

        jButton2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton3.setText("NEXT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-513)/2, (screenSize.height-591)/2, 513, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Session session = new Session(lasttime, ipadd);
        session.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Session().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblsession;
    // End of variables declaration//GEN-END:variables
}