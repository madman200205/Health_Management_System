

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mad2
 */
@WebServlet("/mad2")
public class mad2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		
		String upwd = request.getParameter("password");
		PrintWriter o = response.getWriter();
		o.print(uname);
		o.print(upwd);
		
			HttpSession session = request.getSession();
			RequestDispatcher d = null;      
			
			
			try { 
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root"); 



				PreparedStatement ps=con.prepareStatement("select * from user where name =? and pass=?");
				ps.setString(1,uname);
				ps.setString(2,upwd);

				ResultSet rs  = ps.executeQuery();
				
				

				if(rs.next()) {
					session.setAttribute("name",rs.getString("name"));
					d = request.getRequestDispatcher("new.html");
				}
				else {
					request.setAttribute("status", "failed");
					d= request.getRequestDispatcher("login.jsp");
				}
				
				d.forward(request, response);
				con.close();
	
		
		
		
	}
	catch(Exception e) {
		System.out.print(e);
	}

	

	}}

