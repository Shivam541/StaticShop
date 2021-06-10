import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class LoginFilter implements Filter{
	FilterConfig fcon;
	public void init(FilterConfig fcon){
		this.fcon=fcon;
	}

	public void doFilter(ServletRequest req,ServletResponse res,
		FilterChain chain) throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("userId");
		String pass=req.getParameter("pass");
		try{
			Connection con=ConnectionProvider.getConnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from cust "+
				"where name='"+uname+"' and pass='"+pass+"'");
			if(rs.next()){
				if(rs.getString("loginStatus").equals("T")){
					out.println("<html><body> User Already"+
						" Logged In<br><br>Reloading...</body></html>");
					((HttpServletResponse)res).setHeader("Refresh","2;index.html");
				}
				else{
					stmt.executeUpdate("update cust set "
						+"loginStatus='T' where name='"+uname+
						"' and pass='"+pass+"'");
					chain.doFilter(req,res);
				}
			}
			else{
				out.println("<html><body> Invalid username or password"+
					", try again<br><br>Reloading...</body></html>");
				((HttpServletResponse)res).setHeader("Refresh","3;index.html");
			}
		}catch(Exception e){System.out.println(e);}
		
	}

	public void destroy(){}
}