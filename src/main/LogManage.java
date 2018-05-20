package main;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC-08
 */
import Database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogManage {

    public static DatabaseConnection db = new DatabaseConnection();

    public static void dbconnection() {
        db.dbconnection();
    }

    public void addRules(String input ,String mobile) {
        String query = "insert into idsrule values('" + input + "','" + mobile + "')";
        db.getUpdate(query);
    }

    public String state(String dates, int seconds) {
        String combo = "";
        for (int i = 0; i <= 100; i++) {
            if (i == 100) {
                combo = combo + "line.contains(" + dates + String.valueOf(seconds - i + ")");
            } else {
                combo = combo + "line.contains(" + dates + String.valueOf(seconds - i + ")" + "||");
            }
        }
        System.out.println("combo is " + combo);
        return combo;
    }

    public void deleteRules(String input) {
        String query = "delete from idsrule where rules='" + input + "'";
        db.getUpdate(query);
    }

    public int getMax() throws SQLException {
        int max = 0;
        String query = "select count(rules) from idsRule ";
        ResultSet rs = db.getResultSet(query);
        if (rs.next()) {
            max = rs.getInt(1);
        }
        return max;
    }

    public Vector<String> getRules() throws SQLException {
        Vector<String> vec2 = new Vector<>();

        String query = "select * from idsRule ";
        ResultSet rs = db.getResultSet(query);

        while (rs.next()) {
            vec2.add(rs.getString(1));
        }
        return vec2;
    }

    public Vector<Vector> getRuleTable() throws SQLException {
        Vector<Vector> data = new Vector<>();
        
        String query = "select * from idsRule ";
        db.dbconnection();
        ResultSet rs = db.getResultSet(query);

        while (rs.next()) {
            Vector<String> vec = new Vector<>();
            vec.add(rs.getString(1));
            vec.add(rs.getString(2));
            data.add(vec);
        }
        return data;
    }

    public Vector<Vector> getalert(Vector<String> vec3) throws SQLException {
        Vector<Vector> data1 = new Vector<>();
//       DateFormat dateFormat = new SimpleDateFormat("HH");
//       Date date = new Date();
//       String hour=dateFormat.format(date).toString(); 
//       
//       DateFormat dateFormat1 = new SimpleDateFormat("mm");
//       Date date1 = new Date();
//       String min=dateFormat.format(date1).toString(); 
//       int minute=Integer.parseInt(min);
//       int hours=Integer.parseInt(hour);
//       if(minute>10)
//            minute-=10;
//       else
//       {
//           hours-=1;
//           minute=50;
//       }    
//       hour=String.valueOf(hours);
//       min=String.valueOf(minute);
//       System.out.println("datessss "+hour+":"+min);
        try {
            String query = getQuery(vec3);
            ResultSet rs = db.getResultSet(query);
            while (rs.next()) 
            {
                Vector<String> vec = new Vector<>();
                String line = rs.getString(1);
                if (line.contains(mainframe.dates)) {
                    vec.add(line);
                    data1.add(vec);
                }
            }
        } catch (Exception ae) {
        }
        return data1;
    }

    public Vector<Vector> getfloodattack(Vector<String> vec) {
        Vector<Vector> datavec = new Vector<>();
        try {
            String query = "select fromip from log where fromip ";
            for (String i : vec) {
                if (vec.lastElement().equals(i)) {
                    query += "'" + i + "' order by fromip";
                } else {
                    query += "'" + i + "'" + "or fromip=";
                }
            }

            ResultSet rs = db.getResultSet(query);
            while (rs.next()) {
                try {
                    Vector<String> vector = new Vector<>();
                    vector.add(rs.getString(1));
                    datavec.add(vector);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(LogManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database is empty");
            Logger.getLogger(LogManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datavec;
    }

    public String getQuery(Vector<String> vec) {
        String query = "select * from logtable where log like ";
        for (String i : vec) {
            if (vec.lastElement().equals(i)) {
                query += "'%" + i + "%'";
            } else {
                query += "'%" + i + "%'" + " or log like ";
            }
        }
        return query;
    }

    public void deleteTable() {
        String query = "delete from logtable";
        db.getUpdate(query);
    }
}