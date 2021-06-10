import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LogoutServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");
		HttpSession sess=req.getSession(false);
		try{
			if(sess!=null){
				sess.invalidate();
				out.println("logged out successfully<br><br>"+
					"Loading Main Page.....");
				res.setHeader("Refresh","2;index.html");
			}
			out.println("</body><html>");
		}catch(Exception e){System.out.println(e);}
	}
}