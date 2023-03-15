

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appupdate1
 */
@WebServlet("/appupdate1")
public class appupdate1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{ 
	    response.setContentType("text/html");
		PrintWriter o = response.getWriter();
		String up=request.getParameter("updateid");
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
//		Statement stmt=con.createStatement(); 
//		ResultSet rs=stmt.executeQuery(" select * from patient3 where name='ma'");
		PreparedStatement myStmt= con.prepareStatement(" select * from app where patientname=?");
		 
		myStmt.setString(1,up);
		ResultSet rs= myStmt.executeQuery();
		String name = "";
		String email = "";
		String date="";
		String phno="";
		
		Cookie ck = new Cookie("pname1",up);
		response.addCookie(ck);
		
//		session.setAttribute("pname",up);
if (rs.next()) {
	 name=rs.getString("patientname");
	 email=rs.getString("doctorname");
     date=rs.getString("date");
	 phno=rs.getString("time");
	
	
			
			
		}
		

		
		
        o.print("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"UTF-8\">\r\n"
        		+ "<title>Insert title here</title>\r\n"
        		+ "<link rel=\"stylesheet\" href=\"patient.css\" />\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+ "\r\n"
        		+ "<section class=\"container\">\r\n"
        		+ "      <header>APPOINTMENT</header>\r\n"
        		+ "      <form action=\"appupdate2\" method=\"post\"class=\"form\">\r\n"
        		+ "        <div class=\"input-box\">\r\n"
        		+ "          <label>Patient Name</label>\r\n"
        		+ "          <input type=\"text\" name=\"pname\" value='"+name+"' placeholder=\"Enter patient name\" required />\r\n"
        		+ "        </div>\r\n"
        		+ "\r\n"
        		+ "        <div class=\"input-box\">\r\n"
        		+ "          <label>Doctor Name</label>\r\n"
        		+ "          <input type=\"text\" name=\"dname\" value='"+email+"' placeholder=\"Enter doctor name\" required />\r\n"
        		+ "        </div>\r\n"
        		+ "\r\n"
        		+ "        <div class=\"column\">\r\n"
        		+ "          <div class=\"input-box\">\r\n"
        		+ "            <label>DATE</label>\r\n"
        		+ "            <input type=\"text\" name=\"date\" value='"+date+"' placeholder=\"Date of appointment\" required />\r\n"
        		+ "          </div>\r\n"
        		+ "          <div class=\"input-box\">\r\n"
        		+ "            <label>TIME</label>\r\n"
        		+ "            <input type=\"text\" name=\"time\" value='"+phno+"' placeholder=\"Time of appointment\" required />\r\n"
        		+ "          </div>\r\n"
        		+ "        </div>\r\n"
        		+ "\r\n"
        		+ "        <button>Submit</button>\r\n"
        		+ "      </form>\r\n"
        		+ "    </section>\r\n"
        		+ "  </body>\r\n"
        		+ "</html>");
		con.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}

	

}
}
