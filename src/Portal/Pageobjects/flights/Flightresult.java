package Portal.Pageobjects.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.util.List;
import java.util.Set;

import Portal.generic.ElementCheck;
import Portal.generic.ExcelUtils;
import Portal.generic.FareChange;
import Portal.generic.WaitStatementLib;

public class Flightresult {

	public Flightresult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-ng-disabled='searchflightName']")
	private WebElement airlinesearchBox;
	@FindBy(xpath = "(//a[contains(text(),'Book Now')])[1]")
	private WebElement Bookbtn;
	@FindBy(xpath = "//div[@data-name='OFFER']//img/../../..//a[contains(text(),'Book Now')]")
	private WebElement LccSpecialBookBtn;
	@FindBy(xpath = "//p[text()='Basic']/../..//a[contains(text(),'Book Now')]")
	private WebElement BasicBook;
	// @FindBy(xpath = "//div[@id='price-change']//div")
	// private WebElement FareChangePopup;
	@FindBy(xpath = "//a[@class='btn orange-btn'][contains(text(),'Continue')]")
	public static WebElement ContinueBtn;
	@FindBy(xpath = "//p[@class='new-price green']//strong")
	public static WebElement downfare;
	@FindBy(xpath = "//p[@strong='new-price red']//strong")
	public static WebElement upFare;
	
	@FindBy(xpath = "//img[@data-ng-show='whiteMarkup']")
	private WebElement OntheFlyMarkupBtn;
	@FindBy(xpath = "//div[@id='up']//div[@class='modal-body")
	private static WebElement FareUp;
	@FindBy(xpath = "//div[@id='down']")
	private static WebElement Faredown;
	@FindBy(xpath = "//div[@class='flight-details']//input")
	private WebElement SelectFlight;
	@FindBy(id = "send-quote")
	private WebElement sendquote;
	@FindBy(xpath = "//input[@id='save-quote']")
	private WebElement savequote;
	@FindBy(xpath = "//h4[text()='SAVE QUOTE']")
	private WebElement SaveQuotePopup;
	@FindBy(xpath = "//h4[text()='SEND QUOTE']")
	private WebElement SendQuotePopup;
	@FindBy(id = "nameQuote1")
	private WebElement NameQuote;
	@FindBy(xpath = "//button[@data-ng-if='!isSendQuote']")
	private WebElement saveQuoteButton;
	@FindBy(id = "add-email")
	private WebElement AddemailButtonQuote;
	@FindBy(id = "emailQuote1")
	private WebElement email1;
	@FindBy(xpath = "//div[@data-ng-bind-html='resultMessageQuotation']//b")
	private WebElement QuotationNumber;
	@FindBy(xpath = "//button[contains(text(),'SEND QUOTATION')]")
	private WebElement SendQuotaionPopupBtn;
	@FindBy(xpath = "//a[text()='All Airlines']")
	private WebElement AllAirline;

	@FindBy(xpath="//div[@data-name='OFFER']//p[contains(text(),'Pay To Change')]")
	private WebElement FLydubaiBukbtn;
	WebDriver driver;
	@FindBy(xpath = "//div[@id='down']//p[@class='modal-title']")
	private WebElement FaredownPopup;

	@FindBy(xpath = "//div[@id='down']//a[text()='Continue']")
	private WebElement continueDown;

	@FindBy(xpath = "//div[@id='up']")
	private WebElement FareupPopup;

	@FindBy(xpath = "//div[@id='up']//a[text()='Continue']")
	private WebElement continueUp;

	public void book(WebDriver driver) {
		WaitStatementLib.explicitWaitForClickable(driver, 2, Bookbtn);
		Bookbtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		FareChange.HandleFarechange(driver);
		System.out.println("Book Button clicked");

	}
	

	public void BasicBook(WebDriver driver) {
		WaitStatementLib.explicitWaitForClickable(driver, 2, BasicBook);
		BasicBook.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FareChange.HandleFarechange(driver);


	}

	

	public void BookLCCSpecial(WebDriver driver) {
		LccSpecialBookBtn.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FareChange.HandleFarechange(driver);

		

	}

	

	public void BookFlydubaiBtn(WebDriver driver) {
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		FLydubaiBukbtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FareChange.HandleFarechange(driver);

	}

	public String resultsPagesSavequote(String passenger) throws InterruptedException {
		if (AllAirline.hashCode() != 0)

			// WaitStatementLib.implicitWaitforSeconds(driver, 60);
			System.out.println(AllAirline.getText());
		SelectFlight.click();
		savequote.click();
		Thread.sleep(5000);
		if (SaveQuotePopup.hashCode() != 0)
			System.out.println("Save Quote Popup is displaying");
		NameQuote.click();

		NameQuote.sendKeys(passenger);
		Thread.sleep(2000);
		NameQuote.sendKeys(Keys.ENTER);
		// AddemailButtonQuote.click();
		// email1.sendKeys("mukta.g@techtreeit.com");
		// System.out.println("Extra email id added");
		saveQuoteButton.click();
		Thread.sleep(5000);

		System.out.println("Quotation number appearing");

		String a = QuotationNumber.getText();
		return a;
	}

	public void resultsPagesSendquote(String passenger) {
		if (savequote.hashCode() != 0)
			SelectFlight.click();
		sendquote.click();
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		if (SendQuotePopup.isDisplayed()) {
			NameQuote.sendKeys(passenger);
			NameQuote.sendKeys(Keys.ENTER);
			AddemailButtonQuote.click();
			email1.sendKeys("mukta.g@techtreeit.com");
			saveQuoteButton.click();
			WaitStatementLib.implicitWaitforSeconds(driver, 10);
			SendQuotaionPopupBtn.click();

		}
	}

	public String multicityQuote(String passenger) throws InterruptedException {
		if (Bookbtn.hashCode() != 0)
			SelectFlight.click();
		savequote.click();
		Thread.sleep(5000);
		if (SaveQuotePopup.hashCode() != 0)
			System.out.println("Save Quote Popup is displaying");
		NameQuote.click();

		NameQuote.sendKeys(passenger);
		Thread.sleep(2000);
		NameQuote.sendKeys(Keys.ENTER);
		// AddemailButtonQuote.click();
		// email1.sendKeys("mukta.g@techtreeit.com");
		// System.out.println("Extra email id added");
		saveQuoteButton.click();
		Thread.sleep(5000);

		System.out.println("Quotation number appearing");

		String a = QuotationNumber.getText();
		return a;
	}
}
