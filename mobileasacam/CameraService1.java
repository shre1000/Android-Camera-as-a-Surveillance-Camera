package com.example.mobileasacam;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;












import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CameraService1 extends Service  implements SurfaceHolder.Callback
{
	Socket client;
	Socket client1;
	  PrintWriter printwriter;
	  PrintWriter printwriter1;
	  EditText textField;
	  Button button;
	  String messsage;
	 SurfaceHolder sHolder; 
     //a variable to control the camera
     Camera mCamera;
     String msg="";
     //the camera parameters
     Parameters parameters;
     private WindowManager windowManager;
     private SurfaceView surfaceView;
     private Camera camera = null;
     private MediaRecorder mediaRecorder = null;
     String sendBySms="Your mobile is theft/changed by this number";
     String simid1 = "";
     String imei1 = "";
     String email="";
      //Camera variables
      //a surface holder
     int i=0;
     String fileNameOfImage;
      /** Called when the activity is first created. */
    @Override
    public void onCreate()
    {
        super.onCreate();
         
    }
    @Override
    public void onStart(Intent intent, int startId) {
    	
    	
      // TODO Auto-generated method stub
      super.onStart(intent, startId);
    
      
      final int ONGOING_NOTIFICATION_ID = 1;
	  Notification notification = new Notification(R.drawable.ic_launcher, "",
		        System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, CameraService1.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this,"",
		        "", pendingIntent);
		startForeground(ONGOING_NOTIFICATION_ID, notification);
 	 
		
		
		 
        
        // TextView te=(TextView)findViewById(R.id.textView1);
		 
         //Getting Phone Number
        // String tnumber=tManager.getLine1Number();
         
 
	
        	 if(i%2==0)
        		{
       	 	 mCamera = Camera.open();
       	 	 callForImage();
       	 
       	
//      	 	 sendSms();
        	 	
        		}
        		else if(i%2==1)
        		{
        			 mCamera = Camera.open();	
        			 callForImage();
        			
        			
        			 
        		}
        		
	 
         
//	Toast.makeText(CameraService1.this, "inside", Toast.LENGTH_LONG).show(); 
  
        
 	// startService(new Intent(this, CameraService.class));
	
     
        
      
   }

    
    
 
private void callForImage() {
	   SurfaceView sv = new SurfaceView(getApplicationContext());
	   

       try {
		mCamera.setPreviewDisplay(sv.getHolder());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     parameters = mCamera.getParameters();
      
      //set camera parameters
    mCamera.setParameters(parameters);
    mCamera.startPreview();
    mCamera.takePicture(null, null, mCall);
    
   

  
 
    
    
//Get a surface
sHolder = sv.getHolder();
//tells Android that this surface will have its data constantly replaced
sHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
	}


boolean imagesAreEqual(Bitmap i1, Bitmap i2)
{
    if (i1.getHeight() != i2.getHeight())
     return false;
    if (i1.getWidth() != i2.getWidth()) return false;

//    for (int y = 0; y < i1.getHeight(); ++y)
//       for (int x = 0; x < i1.getWidth(); ++x)
            if (i1.getPixel(10,200) != i2.getPixel(10, 200)) return false;

    return true;
}


Camera.PictureCallback mCall = new Camera.PictureCallback()
   {
 
      public void onPictureTaken(byte[] data, Camera camera)
      {
            //decode the data obtained by the camera into a Bitmap
 
            FileOutputStream outStream = null;
                 try{
                	  boolean flaf=false;
                	 
                	 if(i%3==0)
                	 {
                		 fileNameOfImage= "ImageFromFrontCam.jpg";
                	 }
                	 else if(i%3==1)
                	 {
                		 fileNameOfImage= "ImageFromBackCam.jpg"; 
                	 }
                     outStream = new FileOutputStream("/sdcard/"+fileNameOfImage);
                     outStream.write(data);
                     outStream.close();
                     
                     mCamera.release();
                    String fileNameOfImage1= "ImageForCompare.jpg"; 
//                     Bitmap bmp = BitmapFactory.decodeFile("/sdcard/"+fileNameOfImage);
//       			  ByteArrayOutputStream bos = new ByteArrayOutputStream();
//       			  bmp.compress(CompressFormat.JPEG, 10, bos);
//       			  InputStream in = new ByteArrayInputStream(bos.toByteArray());
//       			  ContentBody foto = new InputStreamBody(in, "image/jpeg", "/sdcard/"+fileNameOfImage1);
//                     sendmail("/sdcard/ImageFromBackCam.jpg"); 
//                  bos.close();
//                  in.close();
//       			  
       			  
       			  if(i>1){
                     String image1Forcompare="/sdcard/ImageFromFrontCam.jpg";
                     File imgFile1 = new  File(image1Forcompare);
                     Bitmap myBitmap1= BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
                     
                     
                     
                     
                     String image2Forcompare="/sdcard/ImageFromBackCam.jpg";
                     File imgFile2 = new  File(image2Forcompare);
                     Bitmap myBitmap2= BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
                     
                 boolean checkImages=    imagesAreEqual(myBitmap1,myBitmap2);
               
//                 Toast.makeText(getApplicationContext(), "checkImages "+checkImages, Toast.LENGTH_LONG).show(); 
                 if(!checkImages)
                     {
                    	 flaf=true;
//                    	 Toast.makeText(getApplicationContext(), "flaf "+flaf, Toast.LENGTH_LONG).show();
//                    	 fileNameOfImage="cameramoved.jpg"; 
//                    	sendmail("ImageFromFrontCam.jpg"); 
                     }
                     
                     }
//                     if(fileNameOfImage.equals("ImageFromFrontCam.jpg"))
                     
                     
                    
                   
					if(flaf)
                     {
                    	 msg="changed";
                     }
                     else
                     {
                    	 msg="not";
                     }
					 String abc="";
			    	  new updatephotos().execute(abc);
                     
//                     try
//					    {
//                    	 
//                    	 HttpClient httpclient = new DefaultHttpClient();
//                         httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
//
//                         HttpPost httppost = new HttpPost("http://192.168.0.101:8080/Test/sockettest?msg="+msg);
//                         File file = new File("/sdcard/"+fileNameOfImage);
//
//                         MultipartEntity mpEntity = new MultipartEntity();
//                        ContentBody cbFile = new FileBody(file, "image/jpeg");
//                         mpEntity.addPart("userfile", cbFile);
//
//                         httppost.setEntity(mpEntity);
//                         System.out.println("executing request " + httppost.getRequestLine());
//                         HttpResponse response = httpclient.execute(httppost);
//                         HttpEntity resEntity = response.getEntity();
//
//                         System.out.println(response.getStatusLine());
//                         if (resEntity != null) {
//                           System.out.println(EntityUtils.toString(resEntity));
//                         }
//                         if (resEntity != null) {
//                           resEntity.consumeContent();
//                         }
//
//                         httpclient.getConnectionManager().shutdown();
//                         i++;
////					        File myFile = new File ("/sdcard/"+fileNameOfImage);
////					        i++;
////					        System.out.println((int)myFile.length());
////					        byte[] mybytearray  = new byte[4505600];
////					        
////					        
////					        
////					        FileInputStream fis = new FileInputStream(myFile);
////					        BufferedInputStream bis = new BufferedInputStream(fis);
////					       
////					        
////					        bis.read(mybytearray,0,mybytearray.length);
////					        OutputStream os = client.getOutputStream();
////					        System.out.println("Sending...");
////					        
////					        os.write(mybytearray,0,mybytearray.length);
//////        			            Toast.makeText(getApplicationContext(), mybytearray.toString(), Toast.LENGTH_LONG).show();
////					        os.flush();
////					        System.out.println("Completed");
////
////					        printwriter.flush();
////						     printwriter.close();
////						     client.close();   //closing the connection
////						     os.close();
////					        System.out.println("Done");
//					       
//					    }
//					    catch(Exception e)
//					    {
//					    	Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
//					    	e.printStackTrace();
////        			           
////        			        	Log.v("MERA MSG",e.toString());
//					    }
                 
//                     i++;
                    
                    
                     
//                 	Mail m;
//                     StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//    		         StrictMode.setThreadPolicy(policy);
//    				m = new Mail("abc.testing@gmail.com", "inbotics"); 
//    				String[] toArr = {"abcs.testing@gmail.com"}; // This is an array, you can add more emails, just separate them with a coma
//    				m.setTo(toArr); // load array to setTo function
//    				m.setFrom("abc.testing@gmail.com"); // who is sending the email 
//    				m.setSubject("subject"); 
//    				m.setBody("your message goes here"); 
//    		 
//    				try { 
//    					
//    					m.addAttachment("/sdcard/"+fileNameOfImage);
//    					
////    					m.addAttachment("/sdcard/Video.mp4");
//    					// path to file you want to attach
//    					if(m.send()) { 
//    						// success
//  						Toast.makeText(CameraService.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
//    					} else { 
//    						// failure
////    						Toast.makeText(CameraService.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
//    					} 
    				} catch(Exception e) { 
    					// some other problem
    					e.printStackTrace();
    					Toast.makeText(CameraService1.this, e.toString(), Toast.LENGTH_LONG).show(); 
    				}
    
      }

	

	

   };
	

   private void sendmail(String fileNameOfImage) {
	   Toast.makeText(CameraService1.this, "in Email was sent successfully."+email, Toast.LENGTH_LONG).show(); 
    	Mail m;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		m = new Mail("abc.testing0@gmail.com", "inboticstesting"); 
		String[] toArr = {"abc.testing0@gmail.com"}; // This is an array, you can add more emails, just separate them with a coma
		m.setTo(toArr); // load array to setTo function
		m.setFrom("abc.testing0@gmail.com"); // who is sending the email 
		m.setSubject("Video Survillience"); 
		m.setBody("Your mobile is moved."); 

		try { 
			
//			m.addAttachment("/sdcard/"+fileNameOfImage);
			
//			m.addAttachment("/sdcard/Video.mp4");
			// path to file you want to attach
			if(m.send()) { 
				
				// success
//				Toast.makeText(CameraService1.this, "Email was sent successfully."+i, Toast.LENGTH_LONG).show(); 
//			i++;
			} else { 
				// failure
			Toast.makeText(CameraService1.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
			} 
		} catch(Exception e) { 
			// some other problem
			e.printStackTrace();
			Toast.makeText(CameraService1.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
		}
		
	}

    
      @Override
      public IBinder onBind(Intent intent) {
            // TODO Auto-generated method stub
            return null;
      }
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if(camera!=null)
		{
			camera.release();
		}
		   camera = Camera.open(1);
	        mediaRecorder = new MediaRecorder();
	        camera.unlock();

	        mediaRecorder.setPreviewDisplay(holder.getSurface());
	        mediaRecorder.setCamera(camera);
//	        mediaRecorder.setMaxDuration(10000);
	        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
	        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
	        mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));

	        mediaRecorder.setOutputFile(
	                "/sdcard/"+
	               
	                "Video.mp4"
	        );
	        
	        try { mediaRecorder.prepare(); } catch (Exception e) {}
	        mediaRecorder.start();
	        final Handler mHandler = new Handler();
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                // TODO Auto-generated method stub
	                while (true) {
	                    try {
	                        Thread.sleep(6000);
	                        mHandler.post(new Runnable() {

	                            @Override
	                            public void run() {
	                            	
	                            	  mediaRecorder.stop();
	                      	        mediaRecorder.reset();
	                      	        mediaRecorder.release();

	                      	        camera.lock();
	                      	        camera.release();

	                      	        windowManager.removeView(surfaceView);
	                      	      fileNameOfImage="Video.mp4";
	                     		
	                     	
	                            }
	                        });
	                    } catch (Exception e) {
	                        // TODO: handle exception
	                    }
	                }
	            }
	        }).start();
	        

		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		  mediaRecorder.stop();
	        mediaRecorder.reset();
	        mediaRecorder.release();

	        camera.lock();
	        camera.release();

	        windowManager.removeView(surfaceView);
	}
	
	class updatephotos extends AsyncTask<String, String, String> {

		// Show Progress bar before downloading Music
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Shows Progress Bar Dialog and then call doInBackground method
			
		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			int count;
			try {
				 try
				    {
             	 
             	 HttpClient httpclient = new DefaultHttpClient();
                  httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

                  HttpPost httppost = new HttpPost(Config.urlForServer+"/sockettest?msg="+msg);
                  File file = new File("/sdcard/"+fileNameOfImage);

                  MultipartEntity mpEntity = new MultipartEntity();
                 ContentBody cbFile = new FileBody(file, "image/jpeg");
                  mpEntity.addPart("userfile", cbFile);

                  httppost.setEntity(mpEntity);
                  System.out.println("executing request " + httppost.getRequestLine());
                  HttpResponse response = httpclient.execute(httppost);
                  HttpEntity resEntity = response.getEntity();

                  System.out.println(response.getStatusLine());
                  if (resEntity != null) {
                    System.out.println(EntityUtils.toString(resEntity));
                  }
                  if (resEntity != null) {
                    resEntity.consumeContent();
                  }

                  httpclient.getConnectionManager().shutdown();
                  i++;
//				        File myFile = new File ("/sdcard/"+fileNameOfImage);
//				        i++;
//				        System.out.println((int)myFile.length());
//				        byte[] mybytearray  = new byte[4505600];
//				        
//				        
//				        
//				        FileInputStream fis = new FileInputStream(myFile);
//				        BufferedInputStream bis = new BufferedInputStream(fis);
//				       
//				        
//				        bis.read(mybytearray,0,mybytearray.length);
//				        OutputStream os = client.getOutputStream();
//				        System.out.println("Sending...");
//				        
//				        os.write(mybytearray,0,mybytearray.length);
//// 			            Toast.makeText(getApplicationContext(), mybytearray.toString(), Toast.LENGTH_LONG).show();
//				        os.flush();
//				        System.out.println("Completed");
//
//				        printwriter.flush();
//					     printwriter.close();
//					     client.close();   //closing the connection
//					     os.close();
//				        System.out.println("Done");
				       
				    }
				    catch(Exception e)
				    {
				    	Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
				    	e.printStackTrace();
// 			           
// 			        	Log.v("MERA MSG",e.toString());
				    }	
				
				
				
			} catch (Exception e) {
				Log.e("Error: ", e.getMessage());
			}
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {}
	}
}
