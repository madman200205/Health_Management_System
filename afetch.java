

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class apppfetch
 */
@WebServlet("/afetch")
public class afetch extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{ 
			response.setContentType("text/html");
			PrintWriter o = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select * from app"); 
//		o.print("op madan");
		o.print("<head><title>PATIENT DETAILS</title><link rel=\"stylesheet\" href=\"table.css\"> </head>");
		o.println("<table aling=\"center\" >\r\n"
				+ "    <h2>APPOINTMENT DETAILS</h2>\r\n"
				+ "        <tr>\r\n"
				+ "            <th>PATIENT NAME</th>\r\n"
				+ "            <th>DOCTOR NAME</th>\r\n"
				
				+ "            <th>APPOINTMENT DATE</th>\r\n"
				+ "            <th>APPOINTMENT TIME</th>\r\n"
				
				
				+ "            <th>Operation</th>\r\n"
				+ "            \r\n"
				+ "        </tr>");
		while(rs.next()) {
			String name=rs.getString("patientname");
			String email=rs.getString("doctorname");
			
			String phno=rs.getString("date");
			String a1=rs.getString("time");
			
			
			
			
			
			
			o.print("<tr class='op'>");
			
			o.print("<td>"+name+"</td>");
			o.print("<td>"+email+"</td>");
			
			o.print("<td>"+phno+"</td>");
			o.print("<td>"+a1+"</td>");
			
			
            o.print("<td>");
            o.print("<button class='update'><a href='appupdate1?updateid="+name +"'  style='text-decoration: none;'>UPDATE</a></button>");
            o.print("<button class='delete'><a href='appdelete?updateid="+name +"'  style='text-decoration: none;'>DELETE</a></button>");
            o.print("</td>\r\n"
            		+ "              \r\n"
            		+ "               </tr>");
		
		
			
			
		}
		
		o.print("<button class=\"adding\"><a href=\"appointment.html\">ADD APPOINTMENT</a></button>\r\n"
				+ " <button class=\"adding\" id=\"database\" style=\"left:280px\"><a href=\"new.html\">DATABASE</a></button>\r\n"
				+ " </table>\r\n"
				+ " </body>\r\n"
				+ "   </html>");
		
//		while(rs.next()) 
//		o.println(rs.getString("pname"));
////		
		con.close(); 
		}
		catch(Exception e)
		{ 
		System.out.println(e); 
		}
	}

}
