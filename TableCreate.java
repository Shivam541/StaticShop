import java.io.*;
import java.sql.*;
import java.util.*;

public class TableCreate{
	public static void create(String url) {
		try{
			Connection c=ConnectionProvider.getConnect();
			Statement stmt=c.createStatement();
			FileInputStream file=new FileInputStream(url);
			byte[] data=new byte[file.available()];
			file.read(data);
			String s=new String(data);
			StringTokenizer tokens=new StringTokenizer(s,"/");
			while(tokens.hasMoreTokens()){
				String query=tokens.nextToken();
				if(query.equals("stop")) break;
				stmt.executeUpdate(query);
			}
		}catch(Exception e){e.printStackTrace(System.out);}
	}
}