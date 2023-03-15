

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update2
 */
@WebServlet("/update2")
public class update2 extends HttpServlet {
	
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
		String value = "";
		
		PrintWriter o = response.getWriter();
		Cookie c[] = request.getCookies();
		 
		for(int i=0;i<c.length;i++)
		{
		   String mm=c[i].getName();
		  if(mm.equals("pname")) {
			 
		  value = c[i].getValue();
		  o.print(value);}
		  
		}
	

		
		o.println(value);
//		o.println(email);
//		o.println(phno);
//		o.println(bdate);
//		o.println(adress1);
//		o.println();
//		o.println(country);
//		o.println(city);
//		o.println(region);
//		o.println(postal);
		
		try
		{ 
	    response.setContentType("text/html");
	    Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	 
	 PreparedStatement ps=con.prepareStatement ("update patient3 set name=? ,email=?,phno=?,bdate=?,adress1=?,adress2=?,country=?,city=?,region=?,postcode=? where name=?"); 
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
		ps.setString(11,value);
	int i=ps.executeUpdate(); 
//	PrintWriter o = response.getWriter();
//	o.print(i);
	response.sendRedirect("fetch");
	con.close();
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}
}
