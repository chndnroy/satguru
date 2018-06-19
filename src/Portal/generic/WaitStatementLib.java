package Portal.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	static WebDriver driver;

	public static void implicitWaitforSeconds(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	public static void implicitWaitforMinutes(WebDriver driver,int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
		
	}
public static void explicitWaitForClickable(WebDriver driver,int time,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
public static void explicitWaitForVisibility(WebDriver driver,int time,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public static void explicitWaitForpresence(WebDriver driver,int time,String xpath) {
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	
}
public static void explicitWaitForInvisibility(WebDriver driver,int time,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.invisibilityOf(element));
}


}

