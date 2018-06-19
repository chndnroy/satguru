package Portal.Hotelscenarios;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import Portal.generic.ExcelUtils;
import Portal.generic.FullpageScreenshot;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class modifychangeRoom extends Login {
	@Test
	public void modifyroom() throws Exception {
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
		hrp.ModifyChangeRoom();
		WaitStatementLib.implicitWaitforMinutes(driver, 10);
        hrp.ClickOnBukBtn();
		System.out.println("modified room search results appeared on page");
		FullpageScreenshot fps=new FullpageScreenshot();
		fps.takescreenshot(driver);
	}
	
}
