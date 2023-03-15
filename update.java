

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	
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
		PreparedStatement myStmt= con.prepareStatement(" select * from patient3 where name=?");
		 
		myStmt.setString(1,up);
		ResultSet rs= myStmt.executeQuery();
		String name = "";
		String email = "";
		String date="";
		String phno="";
		String a1="";
		String a2="";
		String country="";
		String city="";
		String region="";
		String postcode="";
		Cookie ck = new Cookie("pname",up);
		response.addCookie(ck);
		
//		session.setAttribute("pname",up);
if (rs.next()) {
	 name=rs.getString("name");
	 email=rs.getString("email");
     date=rs.getString("bdate");
	 phno=rs.getString("phno");
	 a1=rs.getString("adress1");
	 a2=rs.getString("adress2");
	 country=rs.getString("country");
	city=rs.getString("city");
	 region=rs.getString("region");
	postcode=rs.getString("postcode");
	
			
			
		}
		

		
		
        o.print("\r\n"
        		+ "<html lang=\"en\">\r\n"
        		+ "  <head>\r\n"
        		+ "   <link rel=\"stylesheet\" href=\"patient.css\" />\r\n"
        		+ "  </head>");
		
		o.print("  <body>\r\n"
				+ "    <section class=\"container\">\r\n"
				+ "      <header>PATIENT DETAILS</header>\r\n"
				+ "      <form action=\"update2\" method=\"post\"class=\"form\">\r\n"
				+ "        <div class=\"input-box\">\r\n"
				+ "          <label>Full Name</label>");
		o.print("<input type='text' name='name' value='"+name+"' placeholder='Enter full name' required /></div>");
		o.print("        <div class=\"input-box\">\r\n"
				+ "          <label>Email Address</label>\r\n"
				+ "          <input type=\"text\" name=\"email\" value='"+email+"'placeholder=\"Enter email address\" required />\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"column\">\r\n"
				+ "          <div class=\"input-box\">\r\n"
				+ "            <label>Phone Number</label>\r\n"
				+ "            <input type=\"text\" name=\"phno\" value='"+phno+"' placeholder=\"Enter phone number\" required />\r\n"
				+ "          </div>\r\n"
				+ "          <div class=\"input-box\">\r\n"
				+ "            <label>Birth Date</label>\r\n"
				+ "            <input type=\"text\" name=\"bdate\" value='"+date+"' placeholder=\"Enter birth date\" required />\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"input-box address\">\r\n"
				+ "          <label>Address</label>\r\n"
				+ "          <input type=\"text\" name=\"adress1\" value='"+a1+"' placeholder=\"Enter street address\" required />\r\n"
				+ "          <input type=\"text\" name=\"adress2\" value='"+a2+"' placeholder=\"Enter street address line 2\" required />\r\n"
				+ "          <div class=\"column\">\r\n"
				+ "            <input type=\"text\" name=\"country\" value='"+country+"' placeholder=\"Enter your country\" required />\r\n"
				+ "            <input type=\"text\" name=\"country\" value='"+country+"' placeholder=\"Enter your country\" required />\r\n"
				+ "            <input type=\"text\" name=\"city\" value='"+city+"' placeholder=\"Enter your city\" required />\r\n"
				+ "          </div>\r\n"
				+ "          <div class=\"column\">\r\n"
				+ "            <input type=\"text\" name=\"region\" value='"+region+"' placeholder=\"Enter your region\" required />\r\n"
				+ "            <input type=\"text\" name=\"postal\" value='"+postcode+"' placeholder=\"Enter postal code\" required />\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <button>Submit</button>\r\n"
				+ "      </form>\r\n"
				+ "    </section>\r\n"
				+ "  </body>\r\n"
				+ "</html>\r\n"
				+ "");
		con.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}

	

}
}
