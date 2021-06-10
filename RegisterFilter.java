import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class RegisterFilter implements Filter{
	FilterConfig fcon;
	public void init(FilterConfig fcon){
		this.fcon=fcon;
	}

	public void doFilter(ServletRequest req,ServletResponse res,
	FilterChain chain) throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("userId");
		String pass=req.getParameter("pass");
		String repass=req.getParameter("repass");
		if(pass.equals(repass)){
			try{
				Connection con=ConnectionProvider.getConnect();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from cust "+
					"where name='"+uname+"' and pass='"+pass+"'");
				if(rs.next())
					out.println("<html><body> User Already Exit"+
					" ,You can login <br><br>Loading...</body></html>");
				else chain.doFilter(req,res);
				((HttpServletResponse)res).setHeader("Refresh",
					"3;index.html");
			}catch(Exception e){System.out.println(e);}
		}
		else{
			out.println("<html><body>both passwords"+
				" does not match, try again<br><br>Reloading...</body></html>");
			((HttpServletResponse)res).setHeader("Refresh","2;register.html");
		}
	}

	public void destroy(){}
}