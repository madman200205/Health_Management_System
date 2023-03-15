

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class doc
 */
@WebServlet("/doccc")
public class doccc extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("age");
		String phno = request.getParameter("phno");
		String bdate = request.getParameter("exp");
		String adress1 = request.getParameter("qualification");
		String adress2 = request.getParameter("specialist");
		String country = request.getParameter("intime");
		String city = request.getParameter("outtime");
		
//		PrintWriter o = response.getWriter();
//		o.println(name);
//		o.println(email);
//		o.println(phno);
//		o.println(bdate);
//		o.println(adress1);
//		o.println(adress2);
//		o.println(country);
//		o.println(city);
		
		
		
		
		
		
			
//			RequestDispatcher d = null;      
			
//			
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
				response.sendRedirect("docfetch");



				PreparedStatement ps=con.prepareStatement(" insert into doctor values(?,?,?,?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3,phno);
				ps.setString(4,bdate);
				ps.setString(5,adress1);
				ps.setString(6,adress2);
				ps.setString(7,country);
				ps.setString(8,city);
				
				
				
				
				int rowcount = ps.executeUpdate();
				response.sendRedirect("doc.html");
//			d = request.getRequestDispatcher("doc.html");
			if(rowcount >0)
			    request.setAttribute("status","success");
			else
			     request.setAttribute("status","failed");
//			 d.forward(request,response);
			con.close();

			}
			catch(Exception e)
			{ 
			e.printStackTrace();			}
	}

}
