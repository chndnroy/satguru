package Portal.Pageobjects.flights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Portal.Pageobjects.Basepage;
import Portal.generic.DropdownLib;
import Portal.generic.ElementCheck;
import Portal.generic.WaitStatementLib;

public class PaymentPage extends Basepage {
	
	@FindBy(xpath = "//input[@value='Pay']")
	private WebElement WalletPayBtn;

	@FindBy(xpath = "//input[@name='cardHolderName']")
	private WebElement CardholderName;
	@FindBy(xpath = "//input[@name='l_name']")
	private WebElement LastNamefield;
	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement CardNum;
	@FindBy(xpath = "//select[@name='expMonth']")
	private WebElement ExpMnthDrpdwn;
	@FindBy(xpath = "//select[@name='expYear']")
	private WebElement ExpYrDrpdwn;
	@FindBy(xpath = "//input[@name='cvvNumber']")
	private WebElement CvvField;
	@FindBy(xpath = "//input[@value='Pay']")
	private WebElement PayBtn;
	@FindBy(xpath = "//input[@name='address']")
	private WebElement Addressfield;
	@FindBy(xpath = "//input[@name='street']")
	private WebElement street;
	@FindBy(xpath = "//input[@name='city']")
	private WebElement Cityfield;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement Emailfield;
	@FindBy(xpath = "//input[@name='state']")
	private WebElement Statefield;
	@FindBy(xpath = "//input[@name='country']")
	private WebElement Countryfield;
	@FindBy(xpath = "//input[@name='zip']")
	private WebElement Zipfield;
	@FindBy(xpath = "//p[text()='Credit Card']")
	private WebElement CreditCardBtn;
	@FindBy (xpath="//input[@name='phoneNumber']")
	private WebElement phoneNum;
	@FindBy (xpath="//select[@id='country']")
	private WebElement countryfield;
	@FindBy(xpath="//div[contains(text(),'Billing')]")
	private WebElement threeGpayText;
	

	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
WebDriver driver;

	public void walletPay() {
		
		if (WalletPayBtn.isEnabled())
			WalletPayBtn.click();

	}

	public void CreditCardPay(WebDriver driver) throws InterruptedException {
		WaitStatementLib.implicitWaitforSeconds(driver, 20);
		CreditCardBtn.isEnabled();
		CreditCardBtn.click();
		System.out.println("Credit card payment page is open");
	boolean a = ElementCheck.textPresence("street", driver);
		if (a)
		{
			System.out.println("cybersource page is open");
			CardholderName.sendKeys("John");
			LastNamefield.sendKeys("Doe");
			CardNum.sendKeys("400000000000051");
			DropdownLib.Choosebyvalue(driver, ExpMnthDrpdwn, "12");
			DropdownLib.Choosebyvalue(driver, ExpYrDrpdwn, "2020");
			CvvField.sendKeys("111");
			Addressfield.sendKeys("hfghfvhgv");
			street.sendKeys("1295 Charleston Road");
			Cityfield.sendKeys("Mountain View");
			Emailfield.sendKeys("c@gmail.com");
			Statefield.sendKeys("CA");
			Countryfield.sendKeys("US");
			Zipfield.sendKeys("94043");
			PayBtn.click();
		}
         else {
			System.out.println("3g page is open");
	        threeGpayText.isDisplayed();


			CardholderName.sendKeys("chandan");
			LastNamefield.sendKeys("roy");
			Emailfield.sendKeys("c@gmail.com");

			phoneNum.sendKeys("9999999999");
			Addressfield.sendKeys("wqdddsSFDS");
			Cityfield.sendKeys("sadsda");
			DropdownLib.Choosebytext(driver, countryfield, "India");
			Zipfield.sendKeys("94043");
			System.out.println("Billing Deails ebtered.");
			Thread.sleep(5000);
			PayBtn.click();
			WaitStatementLib.implicitWaitforMinutes(driver, 2);
			
		}

	}

}
