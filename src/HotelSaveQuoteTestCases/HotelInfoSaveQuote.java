package HotelSaveQuoteTestCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.hotels.HotelInfoPage;
import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import Portal.generic.ExcelUtils;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class HotelInfoSaveQuote extends Login {
	@Test
	public void HotelBook() throws Exception {
		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		pl.Hotel();
		System.out.println("Portal login is successful");
		HotelSearchPage hsp = new HotelSearchPage(driver);
		hsp.Hotelsearch(ExcelUtils.readData("Sheet4", 0, 1), ExcelUtils.readData("Sheet4", 1, 1));
		System.out.println("Hotel input is successful");
		Hotelresultspage hrp = new Hotelresultspage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 10);
		hrp.ClickOnBukBtn();
		System.out.println("Book button clicked on results page");
		String parent = driver.getWindowHandle();
		System.out.println("control is on page " + driver.getTitle());
		Set<String> a = driver.getWindowHandles();
		Iterator<String> child = a.iterator();
		String c1 = child.next();
		String c2 = child.next();
		driver.switchTo().window(c2);

		System.out.println("Info page is open");
		HotelInfoPage hip = new HotelInfoPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		String b = hip.SaveQuote("c");
		ExcelUtils.writeData("Sheet4", 4, 1, b);
}
}
