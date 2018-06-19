package portal.Pageobjects.Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="//li[@id='mybooking']")
	private WebElement Mybookingbutton;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public void mybookings() {
		Mybookingbutton.click();
		
	}

}
