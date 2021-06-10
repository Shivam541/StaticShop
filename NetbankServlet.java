import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class NetbankServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");
		String cardno=req.getParameter("cardno");
		String bname=req.getParameter("bankname");
		Connection con=ConnectionProvider.getConnect();
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bank where name='"
				+bname+"' and cardno='"+cardno+"'");
			if(rs.next()){
				out.println("Happy Shopping!!! thanks");
				res.setHeader("Refresh","4;welcome.html");
			}else{
				out.println("Invalid bankname or password");
				res.setHeader("Refresh","2;netbank.html");
			}
			out.println("</body></html>");
		}catch(Exception e){System.out.println(e);}
	}
}