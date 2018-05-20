package Test;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import SendEmail.SimpleSendEmail;

public class mobileAsacam {

	/**
	 * @param args
	 */
	  private static ServerSocket serverSocket;
	  private static ServerSocket serverSocket1;
	    private static Socket clientSocket;
	    private static Socket clientSocket1;
	    private static InputStreamReader inputStreamReader;
	    private static BufferedReader bufferedReader;
	    private static String message;

		// TODO Auto-generated method stub
	    static int filesize=4506600;
        static int bytesRead;
        static int current=0;

	    public static void main(String[] args) throws IOException {

	    	 serverSocket = new ServerSocket(4482);
	    	
int i=0;
int j=0;
	        while (true) {
	            try {
	            	
	            	
	            	
	            	
	            	
	                 System.out.println("Server started. Listening to the port 4444");
	                clientSocket = serverSocket.accept();   //accept the client connection
//	                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
//	                bufferedReader = new BufferedReader(inputStreamReader); //get the client message
//	                message = bufferedReader.readLine();

	                byte [] mybytearray  = new byte [filesize];
	                InputStream is = clientSocket.getInputStream();
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
	                if(i<180){
	                System.out.println(img);
	                }
	               
	               
	                
//	                FileOutputStream fos = new FileOutputStream("F:\\images\\Capture"+img+".jpg");
	              
	                
	                
	                
	               
	                
	                i++;
	              
//	                BufferedOutputStream bos = new BufferedOutputStream(fos);
//	                bytesRead = is.read(mybytearray,0,mybytearray.length);
//	                current = bytesRead;
//System.out.println(bytesRead);
//	                do {
//	                   bytesRead =
//	                      is.read(mybytearray, current, (mybytearray.length-current));
//	                   if(bytesRead >= 0) current += bytesRead;
//	                } while(bytesRead > -1);

	                
	        		OutputStream os = new FileOutputStream("F:\\images\\Capture"+img+".jpg");

	    			float quality = 0.2f;

	    			// create a BufferedImage as the result of decoding the supplied InputStream
	    			BufferedImage image = ImageIO.read(is);

	    			
	    			// get all image writers for JPG format
	    			Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

	    			if (!writers.hasNext())
	    				throw new IllegalStateException("No writers found");

	    			ImageWriter writer = (ImageWriter) writers.next();
	    			ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	    			writer.setOutput(ios);

	    			ImageWriteParam param = writer.getDefaultWriteParam();

	    			// compress to a given quality
	    			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	    			param.setCompressionQuality(quality);

	    			// appends a complete image stream containing a single image and
	    		    //associated stream and image metadata and thumbnails to the output
	    			writer.write(null, new IIOImage(image, null, null), param);

	    			// close all streams
	    			is.close();
	    			os.close();
	    			ios.close();
	    			writer.dispose();
	                
	                
	                
//	                bos.write(mybytearray, 0 , current);
//	                bos.flush();
//bos.close();
	                System.out.println("end-start");    
	                
	                System.out.println(message);
	              
	                clientSocket.close();
//	              compressfile("F:\\images\\Capture"+img+".jpg",img);
//	               
	               
	            		sendmail();
	            	
	                // receive file
	               
	            }
	            
	            catch(Exception e)
	            {
	                System.out.println(e);
	                e.printStackTrace();
	            }

	          
	        }

	    }

		private static void compressfile(String imagepath, String img) throws IOException {
			File imageFile = new File(imagepath);
			File compressedImageFile = new File("F:\\images\\CaptureCOmp"+img+".jpg");

			InputStream is = new FileInputStream(imageFile);
			OutputStream os = new FileOutputStream(compressedImageFile);

			float quality = 0.2f;

			// create a BufferedImage as the result of decoding the supplied InputStream
			BufferedImage image = ImageIO.read(is);

			// get all image writers for JPG format
			Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

			if (!writers.hasNext())
				throw new IllegalStateException("No writers found");

			ImageWriter writer = (ImageWriter) writers.next();
			ImageOutputStream ios = ImageIO.createImageOutputStream(os);
			writer.setOutput(ios);

			ImageWriteParam param = writer.getDefaultWriteParam();

			// compress to a given quality
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(quality);

			// appends a complete image stream containing a single image and
		    //associated stream and image metadata and thumbnails to the output
			writer.write(null, new IIOImage(image, null, null), param);

			// close all streams
			is.close();
			os.close();
			ios.close();
			writer.dispose();
		SimpleSendEmail smp = new SimpleSendEmail("abc.testing0@gmail.com", "abc.testing0@gmail.com", "Mobile Survillience", "Survillience camera moved", "inboticstesting","F:\\images\\CaptureCOmp"+img+".jpg");
		}

		private static void sendmail() {
			SimpleSendEmail smp = new SimpleSendEmail("abc.testing0@gmail.com", "abc.testing0@gmail.com", "Mobile Survillience", "Survillience camera moved", "inboticstesting","F:\\images\\Capture001.jpg");
		}
	

}
