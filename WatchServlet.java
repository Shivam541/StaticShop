import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class WatchServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String[] watches=req.getParameterValues("watch");
		try{
			HttpSession s=req.getSession(false);
			if(s!=null){
				s.setAttribute("watches",watches);
				RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
				rd.forward(req,res);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.forward(req,res);
			}
		}catch(Exception e){System.out.println(e);}
	}
}