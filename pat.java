

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pat
 */
@WebServlet("/pat")
public class pat extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String bdate = request.getParameter("bdate");
		String adress1 = request.getParameter("adress1");
		String adress2 = request.getParameter("adress2");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String postal = request.getParameter("postal");
//		PrintWriter o = response.getWriter();
//		o.println(name);
//		o.println(email);
//		o.println(phno);
//		o.println(bdate);
//		o.println(adress1);
//		o.println();
//		o.println(country);
//		o.println(city);
//		o.println(region);
//		o.println(postal);
		
		
		
		
		
			
			RequestDispatcher d = null;      
			
			
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 



				PreparedStatement ps=con.prepareStatement(" insert into patient3 values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3,phno);
				ps.setString(4,bdate);
				ps.setString(5,adress1);
				ps.setString(6,adress2);
				ps.setString(7,country);
				ps.setString(8,city);
				ps.setString(9,region);
				ps.setString(10,postal);
				
				
				
				int rowcount = ps.executeUpdate();
			d = request.getRequestDispatcher("patient.html");
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
