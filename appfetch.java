

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appfetch
 */
@WebServlet("/appfetch")
public class appfetch extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("pname");
		String email = request.getParameter("dname");
		String phno = request.getParameter("date");
		String bdate = request.getParameter("time");

//		PrintWriter o = response.getWriter();
//		o.println(name);
//		o.println(email);
//		o.println(phno);
//		o.println(bdate);
//		o.println(adress1);
//		o.println(adress2);
//		o.println(country);
//		o.println(city);
		
		
		
		
		
		
			
			RequestDispatcher d = null;      
			
//			
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 



				PreparedStatement ps=con.prepareStatement(" insert into app values(?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3,phno);
				ps.setString(4,bdate);
			
				
				
				
				
				int rowcount = ps.executeUpdate();
			d = request.getRequestDispatcher("appointment.html");
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
