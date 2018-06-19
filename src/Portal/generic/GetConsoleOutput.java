package Portal.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetConsoleOutput {
	public static String getdata()  {
		File file = new File("/home/ttuser10/Desktop/RegressionLogs");
		 
		  
	
		try{BufferedReader br = new BufferedReader(new FileReader(file));
			String a = br.readLine();
			return a;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		}
		  
		
		 
//		  String st;
//		  while ((st = br.readLine()) != null)
//		    return st;
	}


