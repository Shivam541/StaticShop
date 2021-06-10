import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		try{
			HttpSession s=req.getSession(false);
			if(s!=null){
				String[] car=(String[])s.getAttribute("cars");
				String[] men=(String[])s.getAttribute("mens");
				String[] women=(String[])s.getAttribute("womens");
				String[] watch=(String[])s.getAttribute("watches");
				String[] laptop=(String[])s.getAttribute("laptops");
				String[] mobile=(String[])s.getAttribute("mobiles");
				out.println("<html><body>");
				out.println("<table bgcolor='green' border=1 width=400>");
				if(mobile!=null){
					out.println("<tr>");
					for (int i=0;i<mobile.length ;i++)
						out.println("<td>"+mobile[i]+"</td>");
					out.println("</tr>");
				}
				if(laptop!=null){
					out.println("<tr>");
					for (int i=0;i<laptop.length ;i++)
						out.println("<td>"+laptop[i]+"</td>");
					out.println("</tr>");
				}
				if(men!=null){
					out.println("<tr>");
					for (int i=0;i<men.length ;i++)
						out.println("<td>"+men[i]+"</td>");
					out.println("</tr>");
				}
				if(women!=null){
					out.println("<tr>");
					for (int i=0;i<women.length ;i++)
						out.println("<td>"+women[i]+"</td>");
					out.println("</tr>");
				}
				if(car!=null){
					out.println("<tr>");
					for (int i=0;i<car.length ;i++)
						out.println("<td>"+car[i]+"</td>");
					out.println("</tr>");
				}
				if(watch!=null){
					out.println("<tr>");
					for (int i=0;i<watch.length ;i++)
						out.println("<td>"+watch[i]+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<br><br><a href='netbank.html'>"+
					"<input type='submit' value='Buy Now'></a>");
				out.println("<br><br><a href='welcome.html'>"+
					"<input type='submit' value='back'></a>");
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("/index.html");
				rd.forward(req,res);
			}
		}catch(Exception e){System.out.println(e);}
	}
}