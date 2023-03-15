

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
 * Servlet implementation class userfetch
 */
@WebServlet("/userfetch")
public class userfetch extends HttpServlet {
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
		ResultSet rs=stmt.executeQuery("select * from user"); 
		o.print("<head><title>PATIENT DETAILS</title><link rel=\"stylesheet\" href=\"table.css\"> </head>");
		o.println("<table aling=\"center\" >\r\n"
				+ "    <h2>USER DETAILS</h2>\r\n"
				+ "        <tr>\r\n"
				+ "            <th>NAME</th>\r\n"
				+ "            <th>EMAIL</th>\r\n"
				+ "            <th>PASSWORD</th>\r\n"
				+ "            <th>PHONE NUMBER</th>\r\n"
				
				+ "            <th>Operation</th>\r\n"
				+ "            \r\n"
				+ "        </tr>");
		while(rs.next()) {
			String name=rs.getString("name");
			String email=rs.getString("email");
			String pass=rs.getString("pass");
			String phno=rs.getString("phno");
			
		
			
			
			
			
			o.print("<tr class='op'>");
			
			o.print("<td>"+name+"</td>");
			o.print("<td>"+email+"</td>");
			o.print("<td>"+pass+"</td>");
			o.print("<td>"+phno+"</td>");

            o.print("<td>");
           
            o.print("<button class='delete'><a href='userdelete?updateid="+name +"'  style='text-decoration: none;'>DELETE</a></button>");
            o.print("</td>\r\n"
            		+ "              \r\n"
            		+ "               </tr>");
		
		
			
			
		}
		
		o.print("<button class=\"adding\"><a href=\"new.html\">DATABASE</a></button>\r\n"
				
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
