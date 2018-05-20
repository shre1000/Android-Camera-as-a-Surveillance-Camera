/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendEmail;
/**
 *
 * @author Administrator
 */
public class sendEmailThread implements Runnable {

    String fromemail = "";
    String toemail = "";
    String Subject = "";
    String message = "";
    String password = "";
    String Attachment = "";

    public sendEmailThread(String frmemail, String temail, String sbject, String msg, String pwd,String attachement) {
        fromemail = frmemail;
        toemail = temail;
        Subject = sbject;
        message = msg;
        password = pwd;
        Attachment = attachement;
    }
    @Override
    public void run() {
        try {
            SimpleSendEmail smp = new SimpleSendEmail(fromemail, toemail, Subject, message, password,Attachment);
        } catch (Exception e) {
        }
    }
}