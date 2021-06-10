import java.io.*;
import java.util.*;

public class PropLoad{
	public static void load(String url) {
		try{
			FileInputStream file=new FileInputStream(url);
			Properties prop=new Properties();
			prop.load(file);
			Enumeration en=prop.propertyNames();
			while(en.hasMoreElements()){
				String key=(String)en.nextElement();
				System.setProperty(key,prop.getProperty(key));
				System.out.println(key+" "+prop.getProperty(key));
			}
	}catch(Exception e){System.out.println(e);}
}
}