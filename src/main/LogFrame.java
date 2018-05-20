package main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC-08
 */
import com.mysql.jdbc.log.Log;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public final class LogFrame extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Log
     */
    LogManage lm = new LogManage();
    public static String Ip;

    public LogFrame() {
        try {
            setUndecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            initComponents();
            setLocationRelativeTo(null);
            tblipadd.show(false);
            tblsummary.show(false);
            loadip();
            loadlogs();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LogFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblipadd = new javax.swing.JTable();
        txtip = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        txtmobile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsummary = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText(" Optimization Analysis And Detection Of Logs");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Authorized IP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Bright", 1, 24))); // NOI18N

        jButton3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblipadd.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        tblipadd.setModel(new javax.swing.table.DefaultTableModel(
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
        tblipadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblipaddMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblipadd);

        txtip.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        txtip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtipActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        Delete.setText("Remove");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        txtmobile.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel2.setText("Enter Mobile No.");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setText("Ip Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Delete)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtip, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(txtmobile))
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Summary Of IP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Bright", 1, 24))); // NOI18N

        jButton6.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton6.setText("10");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblsummary.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        tblsummary.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblsummary);

        jButton7.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton7.setText("ANALYSE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton2.setText("Flood Attack");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton1.setText("Check Log");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadip() {
        Vector<Vector> temp = new Vector<>();
        DefaultTableModel model = new DefaultTableModel();
        Vector heading;
        heading = new Vector();
        heading.add("Rules");
        heading.add("Mobile no");
        try {
            temp = lm.getRuleTable();
        } catch (Exception ae) {
        }
        model.setDataVector(temp, heading);
        tblipadd.setModel(model);
        tblipadd.setRowHeight(25);
        setTableDesign(tblipadd);
        tblipadd.show(true);
    }

    public void loadlogs() {
        String query = "select * from log";
        try {
            lm.db.dbconnection();
            ResultSet rs = lm.db.getResultSet(query);
            if (rs.next()) {
                rs.previous();
                tblsummary.setModel(DbUtils.resultSetToTableModel(rs));
            }
            setTableDesign(tblsummary);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Query Enter Proper Query");
        }
        tblsummary.show();
    }

    public void run() {
        Vector<String> vec1 = new Vector();
        try {
            vec1 = lm.getRules();
        } catch (SQLException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/dd-HH");
        Date date = new Date();
        String dates = dateFormat.format(date).toString();
        System.out.println("dates " + dates);
        String returnValue = "";
        FileReader file;
        String line = "";
        try {
            file = new FileReader("C:/log.txt");
            BufferedReader reader = new BufferedReader(file);
            while ((line = reader.readLine()) != null) {
                returnValue += line + "\n";

                Vector<String> vec2 = new Vector();
                Vector<Vector> temp1 = new Vector<>();

                DefaultTableModel model1 = new DefaultTableModel();
                Vector heading;
                heading = new Vector();
                heading.add("IDs Alert");
                for (String i : vec1) {
                    if (line.contains(i)) {
                        vec2.add(line);
//                        System.out.println("vec2 " + vec2);
                        temp1.add(vec2);
                        break;
                    }
                }

                model1.setDataVector(temp1, heading);
                tblsummary.setModel(model1);
                tblsummary.setRowHeight(48);
                tblsummary.show();
                tblsummary.show();;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IO Error occured");
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Pattern ptn = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        String ip = txtip.getText();
        String mobile = txtmobile.getText();
        Matcher mtch = ptn.matcher(ip);
        Vector<Vector> temp = new Vector<>();
        
        if (isAvailable(ip)) {
            JOptionPane.showMessageDialog(this, ip + " is already Exists", "Error", JOptionPane.ERROR_MESSAGE);
            txtip.grabFocus();
            return;
        }
        if (" ".equals(txtip.getText()) || (!mtch.find())) {
            JOptionPane.showMessageDialog(null, "Enter Valid Rules");
            txtip.grabFocus();
            return;
        }
        if (!isPhoneNumberValid(mobile)) {
            JOptionPane.showMessageDialog(this, "Enter valid mobile no", "Error", JOptionPane.ERROR_MESSAGE);
            txtmobile.grabFocus();
            return;
        }
        if (isAvailable(mobile)) {
            JOptionPane.showMessageDialog(this, mobile + " is already Exists", "Error", JOptionPane.ERROR_MESSAGE);
            txtmobile.grabFocus();
            return;
        }
        
        lm.addRules(ip, mobile);
        DefaultTableModel model = new DefaultTableModel();
        Vector heading;
        heading = new Vector();
        heading.add("Rules");
        heading.add("Mobile no");
        try {
            temp = lm.getRuleTable();
        } catch (Exception ae) {
        }
        model.setDataVector(temp, heading);
        tblipadd.setModel(model);
        tblipadd.setRowHeight(25);
        tblipadd.show(true);
        txtip.setText("");
        txtmobile.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
    private boolean isAvailable(String data) {
        boolean flag = false;
        try {
            String query = "SELECT * FROM idsrule WHERE rules LIKE '" + data + "'";
            ResultSet rs = lm.db.getResultSet(query);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
        }
        return flag;
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        String expression = "[789]{1}[0-9]{9}";//this to validate only 10 digit numbers
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        Vector<Vector> temp = new Vector<>();
        if (tblipadd.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "First Select row then Delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        lm.deleteRules(Ip);
        DefaultTableModel model = new DefaultTableModel();
        Vector heading;
        heading = new Vector();
        heading.add("Rules");
        heading.add("Mobile no");
        try {
            temp = lm.getRuleTable();
        } catch (Exception ae) {
        }
        model.setDataVector(temp, heading);
        tblipadd.setModel(model);
        tblipadd.setRowHeight(25);
        tblipadd.show(true);
    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Support5();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Support10();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lm.db.dbconnection();
        try {
            Vector<String> vec = new Vector<String>();
            Vector<String> vec1 = new Vector();
            String query = "select fromip from log group by fromip having count(fromip)>10";
            ResultSet rs = lm.db.getResultSet(query);
            vec1 = lm.getRules();
            try {
                while (rs.next()) {
                    int flag = 0;
                    String ip = rs.getString(1);
                    for (String i : vec1) {
                        if (i.equals(ip)) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        vec.add(ip);
                    }
                }
            } catch (Exception ae) {
            }

            Vector<Vector> temp1 = new Vector<>();
            DefaultTableModel model1 = new DefaultTableModel();
            Vector heading;
            heading = new Vector();
            heading.add("Flood attack");

            temp1 = lm.getfloodattack(vec);

            model1.setDataVector(temp1, heading);
            tblsummary.setModel(model1);
            tblsummary.setRowHeight(25);
            tblsummary.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database is Empty");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        IpAddress ip = new IpAddress();
        ip.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtipActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadlogs();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblipaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblipaddMouseClicked
        int rowcount = tblipadd.getSelectedRowCount();
        if (rowcount == 1) {
            int row = tblipadd.getSelectedRow();
            Ip = ((DefaultTableModel) tblipadd.getModel()).getValueAt(row, 0).toString();
        }
    }//GEN-LAST:event_tblipaddMouseClicked
    public static void setTableDesign(JTable jTable) {
        Color c = new Color(210, 170, 150);
        String co = "#E989A6";
        Color color = Color.decode(co);
        jTable.setSelectionBackground(c);
        jTable.setRowHeight(25);
        jTable.setFont(new Font("Lucida Bright", Font.BOLD, 14));
    }

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
            java.util.logging.Logger.getLogger(LogFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LogFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(LogFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblipadd;
    public static javax.swing.JTable tblsummary;
    private javax.swing.JTextField txtip;
    private javax.swing.JTextField txtmobile;
    // End of variables declaration//GEN-END:variables
}