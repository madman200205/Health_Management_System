

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
 * Servlet implementation class docupdate2
 */
@WebServlet("/docupdate2")
public class docupdate2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("age");
		String phno = request.getParameter("phno");
		String bdate = request.getParameter("exp");
		String adress1 = request.getParameter("qualification");
		String adress2 = request.getParameter("specialist");
		String country = request.getParameter("intime");
		String city = request.getParameter("outtime");
		String value = "";
		RequestDispatcher d = null;
		PrintWriter o = response.getWriter();
		Cookie c[] = request.getCookies();
		 
		for(int i=0;i<c.length;i++)
		{
		   String mm=c[i].getName();
		  if(mm.equals("dname")) {
			 
		  value = c[i].getValue();
		 
		  }
		  
		}
	

		
//		o.println(value);
//		o.println(email);
//		o.println(phno);
//		o.println(bdate);
//		o.println(adress1);
//		o.println(adress2);
//		o.println(country);
//		o.println(city);
//		
		
		try
		{ 
	    response.setContentType("text/html");
	    Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	 
	 PreparedStatement ps=con.prepareStatement ("update doctor set name=?,age=?,phno=?,exp=?,qualification=?,specialist=?,intime=?,outtime=? where name=?"); 
	    ps.setString(1,name);
		ps.setString(2,email);
		ps.setString(3,phno);
		ps.setString(4,bdate);
		ps.setString(5,adress1);
		ps.setString(6,adress2);
		ps.setString(7,country);
		ps.setString(8,city);
		
		ps.setString(9,value);
	int i=ps.executeUpdate(); 
	
	o.print(i);
	
	response.sendRedirect("docfetch");
	con.close();
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}
}
