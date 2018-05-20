/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mahendra
 */
public class Support5 {
    
    public static DatabaseConnection db = new DatabaseConnection();

    public Support5() 
    {
        String query = show5();
        try {
            ResultSet rs = db.getResultSet(query);
            System.out.println(query);
            if (rs.next()) {
                rs.previous();
                LogFrame.tblsummary.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Query Enter Proper Query");
        }
        LogFrame.tblsummary.show();
    }

    public static String show5() {
        Vector<String> vec5 = new Vector<>();
        Vector<String> vec = new Vector<>();
        try {
            String query = "select fromip from log";
            db.dbconnection();
            ResultSet rs = db.getResultSet(query);

            while (rs.next()) {
                vec.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Support5.class.getName()).log(Level.SEVERE, null, ex);
        }
        vec5 = get5(vec);
        String query = getQuery(vec5);
        return query;
    }

    public static String getQuery(Vector<String> vec) {
        String query = "select * from log where fromip ";
        for (String i : vec) {
            if (i.equals(vec.lastElement())) {
                query += "'" + i + "'";
            } else {
                query += "'" + i + "'" + " or fromip=";
            }
        }
        query += "order by time";
        return query;
    }

    public static Vector<String> get5(Vector<String> vec) {
        Vector<String> newvec = new Vector<>();
        int k = 0;
        for (String i : vec) {
            k = 0;
            for (String j : vec) {
                if (i.equals(j)) {
                    k++;
                }
            }
            if (k >= 5) {
                newvec.add(i);
            }
        }
        return newvec;
    }
}
