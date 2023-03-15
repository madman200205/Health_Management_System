

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
 * Servlet implementation class op
 */
@WebServlet("/op")


/**
 * Servlet implementation class pat
 */

public class op extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phno = request.getParameter("phno");
//		String bdate = request.getParameter("bdate");
//		String adress1 = request.getParameter("adress1");
//		String adress2 = request.getParameter("adress2");
//		String country = request.getParameter("country");
//		String city = request.getParameter("city");
//		String region = request.getParameter("region");
//		String postal = request.getParameter("postal");
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
				ps.setString(1,"w");
				ps.setString(2,"m");
				ps.setString(3,"n");
				ps.setString(4,"o");
				ps.setString(5,"p");
				ps.setString(6,"q");
				ps.setString(7,"r");
				ps.setString(8,"s");
				ps.setString(9,"t");
				ps.setString(10,"u");
				
				
				
				int rowcount = ps.executeUpdate();
			d = request.getRequestDispatcher("");
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