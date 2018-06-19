package Portal.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class presence {
public static boolean elementpresence(String value, WebDriver driver) {
//	if(driver.findElements(By.xpath(value)).size() != 0){
//		System.out.println("Element is Present");
//		return true;
//		}
		

	 if (driver.findElement(By.xpath(value))!= null){
		System.out.println("Element is Present");
		return true;

		

		}

	else if( driver.findElement(By.cssSelector("a > font")).isDisplayed()){
		System.out.println("Element is Visible");
		return true;

		}

		

	else if( driver.findElement(By.cssSelector("a > font")).isEnabled()){
		System.out.println("Element is Enable");
		return true;

		}
		else{
			System.out.println("Element is Absent");
			return false;
			}
	
}
}
