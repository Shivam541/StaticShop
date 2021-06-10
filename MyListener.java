import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent ev){
		HttpSession sess= ev.getSession();
		//sess.setMaxInactiveInterval(20);
	}
	public void sessionDestroyed(HttpSessionEvent ev){
		System.out.println("destroying session");
		HttpSession sess= ev.getSession();
		String name=(String)sess.getAttribute("name");
		String pass=(String)sess.getAttribute("pass");
		System.out.println(name+" = "+pass);
		try{
			Connection con=ConnectionProvider.getConnect();
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update cust set loginStatus='F'"+
				" where name='"+name+"'and pass='"+pass+"'");
			con.commit();
		}catch(Exception e){System.out.println(e);}
	}
}