import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MenServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String[] mens=req.getParameterValues("men");
		try{
			HttpSession s=req.getSession(false);
			if(s!=null){
				s.setAttribute("mens",mens);
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