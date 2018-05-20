package com.example.mobileasacam;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;



import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint({ "NewApi", "ShowToast" })
public class MainActivity extends Activity implements SurfaceHolder.Callback {
	 private Socket client;
	 private PrintWriter printwriter;
	 private EditText textField;
	 private Button button;
	 private String messsage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 textField = (EditText) findViewById(R.id.editText1); //reference to the text field
		  button = (Button) findViewById(R.id.button1);   //reference to the send button
		
		  //Button press event listener
		 
		  button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				callAsynchronousTask() ;
			   
			
			}
		});
			 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

			  StrictMode.setThreadPolicy(policy); 
		 
	}
	 private void takePicturesAfterInterval(int i) {
		 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);
		    startService(new Intent(this, CameraService1.class));
	 }
	public void callAsynchronousTask() {
		
		
	    final Handler handler = new Handler();
	    Timer timer = new Timer();
	    TimerTask doAsynchronousTask = new TimerTask() {       
	        @Override
	        public void run() {
	            handler.post(new Runnable() {
	                public void run() {       
	                    try {
//	                    	AsyncTaskRunner performBackgroundTask = new AsyncTaskRunner();
//	                        // PerformBackgroundTask this class is the class that extends AsynchTask 
//	                        performBackgroundTask.execute();
	                    
	                    	
		                    	takePicturesAfterInterval(1);
	                    	
	                  
	                    	
	                        		
	                        
	                    
	                    	
	                    } catch (Exception e) {
	                        // TODO Auto-generated catch block
	                    }
	                }
	            });
	            
	        }
	    };
	    timer.schedule(doAsynchronousTask, 0,10000); //execute in every 50000 ms
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
	  
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
