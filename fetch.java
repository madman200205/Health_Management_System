

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fetch
 */
@WebServlet("/fetch")
public class fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
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
		ResultSet rs=stmt.executeQuery("select * from patient3"); 
		o.print("<head><title>PATIENT DETAILS</title><link rel=\"stylesheet\" href=\"table.css\"> </head>");
		o.println("<table aling=\"center\" >\r\n"
				+ "    <h2>PATIENT DETAILS</h2>\r\n"
				+ "        <tr>\r\n"
				+ "            <th>NAME</th>\r\n"
				+ "            <th>EMAIL</th>\r\n"
				+ "            <th>BDATE</th>\r\n"
				+ "            <th>PHONE NUMBER</th>\r\n"
				+ "            <th>ADRESS1</th>\r\n"
				+ "            <th>ADRESS2</th>\r\n"
				+ "            <th>COUNTRY</th>\r\n"
				+ "            <th>CITY</th>\r\n"
				+ "            <th>REGION</th>\r\n"
				+ "            <th>POSTCODE</th>\r\n"
				+ "            <th>Operation</th>\r\n"
				+ "            \r\n"
				+ "        </tr>");
		while(rs.next()) {
			String name=rs.getString("name");
			String email=rs.getString("email");
			String date=rs.getString("bdate");
			String phno=rs.getString("phno");
			String a1=rs.getString("adress1");
			String a2=rs.getString("adress2");
			String country=rs.getString("country");
			String city=rs.getString("city");
			String region=rs.getString("region");
			String postcode=rs.getString("postcode");
			
			
			
			
			o.print("<tr class='op'>");
			
			o.print("<td>"+name+"</td>");
			o.print("<td>"+email+"</td>");
			o.print("<td>"+date+"</td>");
			o.print("<td>"+phno+"</td>");
			o.print("<td>"+a1+"</td>");
			o.print("<td>"+a2+"</td>");
			o.print("<td>"+country+"</td>");
			o.print("<td>"+city+"</td>");
			o.print("<td>"+region+"</td>");
			o.print("<td>"+postcode+"</td>");
            o.print("<td>");
            o.print("<button class='update'><a href='update?updateid="+name +"'  style='text-decoration: none;'>UPDATE</a></button>");
            o.print("<button class='delete'><a href='delete?updateid="+name +"'  style='text-decoration: none;'>DELETE</a></button>");
            o.print("</td>\r\n"
            		+ "              \r\n"
            		+ "               </tr>");
		
		
			
			
		}
		
		o.print("<button class=\"adding\"><a href=\"patient.html\">ADD PATIENT</a></button>\r\n"
				+ " <button class=\"adding\" id=\"database\" style=\"left:220px\"><a href=\"new.html\">DATABASE</a></button>\r\n"
				+ " </table>\r\n"
				+ " </body>\r\n"
				+ "   </html>");
		
//		while(rs.next()) 
//		o.println(rs.getString("name"));
//		
		con.close(); 
		}
		catch(Exception e)
		{ 
		System.out.println(e); 
		}
	}

}
