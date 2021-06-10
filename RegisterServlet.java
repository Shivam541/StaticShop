import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class RegisterServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("userId");
		String pass=req.getParameter("pass");
		try{
			Connection con=ConnectionProvider.getConnect();
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into cust values('"
				+uname+"','"+pass+"','F')");
				out.println("<html><body> Registration Successful"+
					" You can login <br><br>Loading...</body></html>");
		}catch(Exception e){System.out.println(e);}
	}
}