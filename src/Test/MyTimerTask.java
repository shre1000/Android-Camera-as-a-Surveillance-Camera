package Test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
 
public class MyTimerTask extends TimerTask {
	  static int filesize=4506600;
      static int bytesRead;
      static int current=0;
      int i=0;
      int j=0;
    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        byte [] mybytearray  = new byte [filesize];
      
        String img;
        img="00"+i;
        if(i>9&&i<=99)
        {
        	  img="0"+i;
        }
        else if(i>99)
        {
        	 img=String.valueOf(i);
        }
        if(i<1800){
        System.out.println(img);
        }
       
       
        
//        FileOutputStream fos = new FileOutputStream("F:\\images\\Capture"+img+".jpg");
      
        
        
        
       
        
        i++;
      
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        bytesRead = is.read(mybytearray,0,mybytearray.length);
//        current = bytesRead;
//System.out.println(bytesRead);
//        do {
//           bytesRead =
//              is.read(mybytearray, current, (mybytearray.length-current));
//           if(bytesRead >= 0) current += bytesRead;
//        } while(bytesRead > -1);

        
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    	BufferedImage capture;
		try {
			capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "png", new File("G:/code/Java_Projects_Code/Test/file/img"+img+".png"));
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	
	
      
     
        System.out.println("File downloaded at client successfully");
        
        
        
//        bos.write(mybytearray, 0 , current);
//        bos.flush();
//bos.close();
        System.out.println("end-start");    
        
       
//      compressfile("F:\\images\\Capture"+img+".jpg",img);
//        SimpleSendEmail smp = new SimpleSendEmail("inbotics.testing0@gmail.com", "inbotics.testing0@gmail.com", "Mobile Survillience", "Survillience camera moved", "inboticstesting","F:\\images\\Capture"+img+".jpg");
       
    		
        // receive file
       
    }
    
  
  

       
    
 
    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*10);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        timer.cancel();
       
    }
 
}