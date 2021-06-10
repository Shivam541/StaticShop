import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LaptopServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String[] laptops=req.getParameterValues("laptop");
		try{
			HttpSession s=req.getSession(false);
			if(s!=null){
				s.setAttribute("laptops",laptops);
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