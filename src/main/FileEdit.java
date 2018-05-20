package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEdit {

    public static void Main(String ip) {

        File f = new File("c:/httpd.conf.txt");

        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();

        String textinLine;

        try {
            fs = new FileInputStream(f);
            in = new InputStreamReader(fs);
            br = new BufferedReader(in);

            while (true) {
                textinLine = br.readLine();
                if (textinLine == null) {
                    break;
                }
                sb.append(textinLine).append("\n");
            }
            String textToEdit1 = "Deny from";
            int cnt1 = sb.lastIndexOf(textToEdit1);
            //sb.append("\n"+"Deny from 192.168.0.101"+"\n"+"Deny from");
            sb.replace(cnt1, cnt1 + textToEdit1.length(), "Deny from " + ip + "\n" + "\t" + "Deny from");

            fs.close();
            in.close();
            br.close();
        }
        catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        try {
            FileWriter fstream = new FileWriter(f);
            BufferedWriter outobj = new BufferedWriter(fstream);
            outobj.write(sb.toString());
            outobj.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}