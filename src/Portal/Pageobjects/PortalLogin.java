package Portal.Pageobjects;

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalLogin extends Basepage{
	@FindBy(id="agencyCodeMain")
	private WebElement agecyField;
	@FindBy(id="userAlias")
	private WebElement userfield;
	@FindBy(id="password_password")
	private WebElement passField;

	@FindBy(xpath="//title[text()='satguruportal']")
	private WebElement validLoginTitle;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement submitBtn;
	@FindBy(xpath="//div[contains(text(),'Invalid credentials')]")
	private WebElement inavalidMsg;

	public PortalLogin(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
    public void sendLogin(String code,String Username,String pass) {
    	agecyField.sendKeys(code);
    	userfield.sendKeys(pass);
    	userfield.sendKeys(Keys.CONTROL+"a");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	userfield.sendKeys(Keys.CONTROL+"x");

    	userfield.sendKeys(Username);
//    	
    	
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('agencyCodeMain').value("+code+";");
//		js.executeScript("document.getElementById('password_password').value("+Username+";");
//		js.executeScript("document.getElementById('password_password').value("+pass+";");
		
	
    	passField.click();
    	passField.sendKeys(Keys.CONTROL+"v");
//		
	
    	
	
    	submitBtn.click();
		
	}
    public String InvalidTxt() {
    	return inavalidMsg.getText();
		
	}
}
