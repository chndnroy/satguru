package Portal.generic;

import java.util.Iterator;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FareChange {
	@FindBy(xpath = "//div[@id='down']//p[@class='modal-title']")
	public static WebElement FaredownPopup;

	@FindBy(xpath = "//div[@id='price-change']//a[text()='Continue']")
	public static WebElement continueDown;

	@FindBy(xpath = "//div[@id='up']")
	public static WebElement FareupPopup;

	@FindBy(xpath = "//div[@id='up']//a[text()='Continue']")
	public static WebElement continueUp;

	public FareChange(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public static void HandleFarechange(WebDriver driver)
	
	{try {
//		 boolean a = driver.findElement(By.id("price-change")).isEnabled();
//		 System.out.println(a);
//		boolean b = driver.findElement(By.xpath("//div[@id='price-change']//a[text()='Continue']")).isEnabled();
//		System.out.println(b);
	  driver.findElement(By.xpath("//div[@id='price-change']//a[text()='Continue']")).click();
		System.out.println("Price changed");
	
		
		}
	
	catch (NoSuchElementException e) {
		System.out.println("price not changed");
	}
		
	}	
		
		
	}
	
	
