import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mad1
 */
@WebServlet("/mad1")
public class mad1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		
			
			RequestDispatcher d = null;      
			
			
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 



				PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?)");
				ps.setString(1,uname);
				ps.setString(2,upwd);
				ps.setString(3,uemail);
				ps.setString(4,umobile);
				int rowcount = ps.executeUpdate();
			d = request.getRequestDispatcher("registration.jsp");
			if(rowcount >0)
			    request.setAttribute("status","success");
			else
			     request.setAttribute("status","failed");
			 d.forward(request,response);
			con.close();

			}
			catch(Exception e)
			{ 
			e.printStackTrace();			}
	
		
		
	}

}
