package Portal.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReadData {
	public static String textFileread() throws Exception {
		
		File file = new File("/home/ttuser10/Desktop/RegressionLogs");
		 
		  BufferedReader br = new BufferedReader(new FileReader(file));
		 
		  
		  String st = br.readLine();
		    return st;
	}
}
