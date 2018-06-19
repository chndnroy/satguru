package Portal.generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HandleFarePopup {
	@FindBy(xpath = "//div[@id='price-change']//div[@class='modal-wrap ng-scope']")
	public static WebElement FarePopUp;
	@FindBy(xpath = "//div[@id='price-change']//div[@class='modal-wrap ng-scope']//p[contains(text(),'the price for your Flight')]")
	public static WebElement farechangestatement;
	@FindBy(xpath = "//div//p[contains(text(),'the price for your Flight')]/..//strong")
	public static WebElement NewPrice;
	@FindBy(xpath = "//a[text()='Continue']")
	public static WebElement continueBtn;

	public static void ClickContinue(WebDriver driver) {

		try {
			ElementCheck.textPresence("Continue", driver);
			String MainWindow = driver.getWindowHandle();

			Iterator<String> a = driver.getWindowHandles().iterator();
			while (a.hasNext()) {
				String child = a.next();
				if (!MainWindow.equalsIgnoreCase(child)) {
					driver.switchTo().window(child);
					System.out.println(farechangestatement.getText() + "" + NewPrice.getText());
					continueBtn.click();
				}
			}

//			System.out.println(driver.getTitle());

			// System.out.println(farechangestatement.getText()+""+NewPrice.getText());
//			driver.findElement(By.name("Continue")).submit();
			// continueBtn.click();

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
