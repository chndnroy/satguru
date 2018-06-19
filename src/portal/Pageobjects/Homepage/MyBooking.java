package portal.Pageobjects.Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Portal.generic.DropdownLib;

public class MyBooking {
	@FindBy(id="productType")
	private WebElement ProductDrpDwn;
	@FindBy(id="bookingStatus")
	private WebElement BookingStatusDrpDwn;
	@FindBy(xpath="//input[@value='SEARCH']")
	private WebElement SearchButton;
	@FindBy(xpath="//input[@value='Pay & Book']")
	private WebElement PayNBookButton;
	
	WebDriver driver;
	public MyBooking(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void searchHoldTicket() {
		BookingStatusDrpDwn.click();
		DropdownLib.Choosebytext(driver, BookingStatusDrpDwn, "On Hold");
		SearchButton.click();
		
	}
	public void payBookHoldTicket() {
		PayNBookButton.click();
		
	}
}
