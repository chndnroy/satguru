package portal.Pageobjects.Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchQuotesPage {
	@FindBy(xpath="//input[@id='quotationId']")
	private WebElement QuotationNumField;
	@FindBy(xpath="//input[@id='clientName']")
	private WebElement Namefield;
	@FindBy(xpath="//input[@id='clientEmailId']")
	private WebElement Emailfield;
	@FindBy(xpath="//input[@id='searchQuoteBtn']")
	private WebElement searchButton;
	@FindBy(xpath="//table[@id='quoteResult']//a")
	private WebElement Quoteresult;
	
	public SearchQuotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void SearchQuote(String QuoteNumber) {
		QuotationNumField.sendKeys(QuoteNumber);
		Quoteresult.click();
		
	}
	

}
