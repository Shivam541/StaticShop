import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");
		try{
			HttpSession sess=req.getSession();
			sess.setAttribute("name",req.getParameter("userId"));
			sess.setAttribute("pass",req.getParameter("pass"));
			req.getRequestDispatcher("/welcome.html").forward(req,res);
		}catch(Exception e){
			out.println(e);
		}
	}
}