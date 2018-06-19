package HotelSaveQuoteTestCases;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.hotels.HotelSearchPage;
import Portal.Pageobjects.hotels.Hotelresultspage;
import Portal.generic.ExcelUtils;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class HotelresultsPageSaveQuote extends Login {
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
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		Hotelresultspage hrp=new Hotelresultspage(driver);
		String b = hrp.SaveQuote("chandan");
		ExcelUtils.writeData("Sheet4", 3, 1, b);

}
}
