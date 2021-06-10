import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ApplicationInitializer extends HttpServlet{
	public void init(ServletConfig con) throws ServletException{
		ServletContext ctx=con.getServletContext();
		String orachk=ctx.getInitParameter("oracletab");
		String oracle=ctx.getRealPath(
			"WEB-INF//dbtable//oracletable.txt");
		String prop=ctx.getRealPath(
			"WEB-INF//db//db.properties.txt");
		PropLoad.load(prop);
		if(orachk.equals("yes")) {
			TableCreate.create(oracle);
			System.out.println("Table creted successfully");
		}
	}
}