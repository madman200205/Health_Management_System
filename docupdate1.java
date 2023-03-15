

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
 * Servlet implementation class docupdate1
 */
@WebServlet("/docupdate1")
public class docupdate1 extends HttpServlet {
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
		PreparedStatement myStmt= con.prepareStatement(" select * from doctor where name=?");
		 
		myStmt.setString(1,up);
		ResultSet rs= myStmt.executeQuery();
		String name = "";
		String age = "";
		String phno="";
		
		String exp="";
		String qualification="";
		String specialist="";
		String intime="";
		String outtime="";
		
		Cookie ck = new Cookie("dname",up);
		response.addCookie(ck);
		
//		session.setAttribute("pname",up);
if (rs.next()) {
	 name=rs.getString("name");
	 age=rs.getString("age");
     phno=rs.getString("phno");
	 
	 exp=rs.getString("exp");
	 qualification=rs.getString("qualification");
	 specialist=rs.getString("specialist");
	intime=rs.getString("intime");
	 outtime=rs.getString("outtime");
	
	
			
			
		}
		

		
		
o.print("\r\n"
		+ "<html lang=\"en\">\r\n"
		+ "  <head>\r\n"
		+ "   <link rel=\"stylesheet\" href=\"patient.css\" />\r\n"
		+ "  </head>");

o.print("  <body>\r\n"
		+ "    <section class=\"container\">\r\n"
		+ "      <header>DOCTOR DETAILS</header>\r\n"
		+ "      <form action=\"docupdate2\" method=\"post\" class=\"form\">\r\n"
		+ "        <div class=\"input-box\">\r\n"
		+ "          <label>Full Name</label>\r\n"
		+ "          <input type=\"text\" name=\"name\"value='"+name+"' placeholder=\"Enter full name\" required />\r\n"
		+ "        </div>\r\n"
		+ "\r\n"
		+ "        <div class=\"input-box\">\r\n"
		+ "          <label>Age</label>\r\n"
		+ "          <input type=\"text\" name=\"age\" value='"+age+"'placeholder=\"Enter your age\" required />\r\n"
		+ "        </div>\r\n"
		+ "\r\n"
		+ "        <div class=\"column\">\r\n"
		+ "          <div class=\"input-box\">\r\n"
		+ "            <label>Phone Number</label>\r\n"
		+ "            <input type=\"text\" name=\"phno\" value='"+phno+"'placeholder=\"Enter phone number\" required />\r\n"
		+ "          </div>\r\n"
		+ "          <div class=\"input-box\">\r\n"
		+ "            <label>Experience</label>\r\n"
		+ "            <input type=\"text\" name=\"exp\" value='"+exp+"'placeholder=\"Enter your experience\" required />\r\n"
		+ "          </div>\r\n"
		+ "        </div>\r\n"
		+ "\r\n"
		+ "        <div class=\"input-box address\">\r\n"
		+ "\r\n"
		+ "          <input type=\"text\" name=\"qualification\" value='"+qualification+"'placeholder=\"Qualification\" required />\r\n"
		+ "          <input type=\"text\" name=\"specialist\" value='"+specialist+"'placeholder=\"Specialist\" required />\r\n"
		+ "          <div class=\"column\">\r\n"
		+ "            <input type=\"text\" name=\"intime\" value='"+intime+"'placeholder=\"IN TIME\" required />\r\n"
		+ "            <input type=\"text\" name=\"outtime\"value='"+outtime+"' placeholder=\"OUT TIME\" required />\r\n"
		+ "          </div>\r\n"
		+ "          <!-- <div class=\"column\">\r\n"
		+ "            <input type=\"text\" name=\"region\" placeholder=\"Enter your region\" required />\r\n"
		+ "            <input type=\"number\" name=\"postal\" placeholder=\"Enter postal code\" required />\r\n"
		+ "          </div>\r\n"
		+ "        </div> -->\r\n"
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
