package Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ANdroidCommandExecuter
 */
@WebServlet("/ANdroidCommandExecuter")
public class ANdroidCommandExecuter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ANdroidCommandExecuter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int j=0;
		int k=0;
		Process p=Runtime.getRuntime().exec("rundll32.exe user32.dll, LockWorkStation");
		 Gson gson = new Gson();
		 try {
	            StringBuilder sb = new StringBuilder();
	            String s;
	            while ((s = request.getReader().readLine()) != null) {
	                sb.append(s);
	            }
	 
	            Student student = (Student) gson.fromJson(sb.toString(), Student.class);
	 
	            Status status = new Status();
	          
	                status.setSuccess(true);
	                status.setDescription("success");
	           
	                
	            response.getOutputStream().print(gson.toJson(status));
	            response.getOutputStream().flush();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            Status status = new Status();
	            status.setSuccess(false);
	            status.setDescription(ex.getMessage());
	            response.getOutputStream().print(gson.toJson(status));
	            response.getOutputStream().flush();
	        }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int j=0;
		int k=0;
		Process p=Runtime.getRuntime().exec("rundll32.exe user32.dll, LockWorkStation");
		 Gson gson = new Gson();
		 try {
	            StringBuilder sb = new StringBuilder();
	            String s;
	            while ((s = request.getReader().readLine()) != null) {
	                sb.append(s);
	            }
	 
	            Student student = (Student) gson.fromJson(sb.toString(), Student.class);
	 
	            Status status = new Status();
	          
	                status.setSuccess(true);
	                status.setDescription("success");
	           
	                
	            response.getOutputStream().print(gson.toJson(status));
	            response.getOutputStream().flush();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            Status status = new Status();
	            status.setSuccess(false);
	            status.setDescription(ex.getMessage());
	            response.getOutputStream().print(gson.toJson(status));
	            response.getOutputStream().flush();
	        }
	    }
	}


