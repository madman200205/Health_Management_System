

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userdelete
 */
@WebServlet("/userdelete")
public class userdelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{ 
	   response.setContentType("text/html");
		PrintWriter o = response.getWriter();
		String up=request.getParameter("updateid");
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 

		PreparedStatement myStmt= con.prepareStatement("delete from user where name=?");
		 
		myStmt.setString(1,up);
		int i= myStmt.executeUpdate();
		o.print("op madan");
		response.sendRedirect("userfetch");
		con.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
