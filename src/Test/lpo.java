package Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class lpo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("G:\\Student data\\");
		String[] names = file.list();
		
		
		for(String name : names)
		{
		    if (new File("G:\\Student data\\" + name).isDirectory())
		    {
		    	String[] names1 =new File("G:\\Student data\\" + name).list();
		    	for(String name1 : names1){
		    	if(new File("G:\\Student data\\" + name+"\\"+name1).isDirectory())
		    	{
		    		
		    		File directory = new File("G:\\Student data\\" + name+"\\"+name1);

		    	    // get all the files from a directory
		    	    File[] fList = directory.listFiles();
		    		
		    	    for (File files1 : fList) {
		    	    	System.out.println(files1);
		    	    
//		    	    	 File image=new File(files1);
			    		  FileInputStream fis;
			    		     
			    		            fis = new FileInputStream(files1);
			    		             ByteArrayOutputStream bos=new ByteArrayOutputStream();
			    		  byte[] buf=new byte[1024];
			    		            
			    		                for(int readnum;(readnum=fis.read(buf))!=-1;)
			    		                {
			    		          //9987340874      	
			    		                    
			    		                    bos.write(buf,0,readnum);
			    		                }
//			    		                
		    	    	
		    	    }
		    	    
		    		
		    		
		    		 
		    	
		    	}
		    	}
		    	
		      
		    }
		}

	}

}
