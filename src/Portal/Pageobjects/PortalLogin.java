package Portal.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalLogin extends Basepage{
	@FindBy(id="Agency Code")
	private WebElement agecyField;
	@FindBy(id="userAlias")
	private WebElement userfield;
	@FindBy(id="password")
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
	
    public void sendLogin(String code,String Username,String password) {
    	userfield.sendKeys(Username);
		
	
    	passField.sendKeys(password);
		
	
    	agecyField.sendKeys(code);
    	
	
    	submitBtn.click();
		
	}
    public String InvalidTxt() {
    	return inavalidMsg.getText();
		
	}
}
