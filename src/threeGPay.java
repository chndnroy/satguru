import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Portal.generic.DropdownLib;

public class threeGPay {

	@FindBy(xpath="//input[@id='terms-approval']")
	private WebElement Termstick;
	@FindBy(xpath="//a[@id='cerditcarAtag']")
	private WebElement selectCreditcard;	
	@FindBy(xpath="//input[@id='TRANScardholdername']")
	private WebElement cardholderName;
	@FindBy(xpath="//input[@id='TRANSCreditnum']")
	private WebElement cardNum;
	@FindBy(xpath="//select[@id='TRANSexpiryM']")
	private WebElement month;
	@FindBy(xpath="//select[@id='TRANSexpiryY']")
	private WebElement year;
	@FindBy(xpath="//input[@id='TRANScvv']")
	private WebElement cvvfield;
	@FindBy(xpath="//button[@id='creditCardBtn']")
	private WebElement payButton;
	@FindBy(xpath="//title")
	private WebElement title;
	
	public threeGPay() {
		PageFactory.initElements(driver, this);

	}
	
	
	
	
	WebDriver driver;
	public void pay() {
		assertEquals( title.getText(),"Online Payments - Direct Pay Online","3g payment not open");
		System.out.println("3g site open for payment");
		
	Termstick.click();
	selectCreditcard.click();
	cardholderName.sendKeys("chandan");
	cardNum.sendKeys("5424000000000015");
	DropdownLib.Choosebytext(driver, month, "December");
	DropdownLib.Choosebytext(driver, year, "2020");
	cvvfield.sendKeys("111");
	payButton.click();
	
		
	}
	
}
