package Portal.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Basepage {
	
@FindBy(xpath="//img[@alt='home-icon']")
private WebElement Homepage_Button;

@FindBy(xpath="//img[@alt='flight-icon']")
private WebElement Flight_Page;

@FindBy(xpath="//img[@alt='hotel-icon']")
private WebElement Hotel_Page;

@FindBy(xpath="//img[@alt='hand_heart_icon-icon']")
private WebElement Insurance_Page;

public Basepage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}


public void Homepage() {
	Homepage_Button.click();
	
}
public void Flight() {
	Flight_Page.click();
	
}
public void Hotel() {
	Hotel_Page.click();
	
}
public void Insurance() {
	Insurance_Page.click();
	


}
}
