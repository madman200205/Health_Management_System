

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{ 
	   response.setContentType("text/html");
		PrintWriter o = response.getWriter();
		String up=request.getParameter("updateid");
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 

		PreparedStatement myStmt= con.prepareStatement("delete from patient3 where name=?");
		 
		myStmt.setString(1,up);
		int i= myStmt.executeUpdate();
		o.print("op madan");
		response.sendRedirect("fetch");
		con.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
