

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
 * Servlet implementation class appupdate2
 */
@WebServlet("/appupdate2")
public class appupdate2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("pname");
		String email = request.getParameter("dname");
		String phno = request.getParameter("date");
		String bdate = request.getParameter("time");
		
		String value = "";
		
		PrintWriter o = response.getWriter();
		Cookie c[] = request.getCookies();
		 
		for(int i=0;i<c.length;i++)
		{
		   String mm=c[i].getName();
		  if(mm.equals("pname1")) {
			 
		  value = c[i].getValue();
		  o.print(value);}
		  
		}
	

		
//        o.print(name);
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
	
	 
	 PreparedStatement ps=con.prepareStatement ("update app set patientname=? ,doctorname=?,date=?,time=? where patientname=?"); 
	    ps.setString(1,name);
		ps.setString(2,email);
		ps.setString(3,phno);
		ps.setString(4,bdate);
		
		ps.setString(5,value);
	int i=ps.executeUpdate(); 
	o.println("sudeep");

	response.sendRedirect("afetch");
	con.close();
//		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}

}
