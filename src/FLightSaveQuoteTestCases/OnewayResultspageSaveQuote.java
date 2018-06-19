package FLightSaveQuoteTestCases;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.generic.ExcelUtils;
import Portal.generic.FullpageScreenshot;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class OnewayResultspageSaveQuote extends Login{
	@Test
	public void OnewatTckt() throws Exception {
		PortalLogin pl=new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1), 
				ExcelUtils.readData("Sheet1", 2, 1));
		pl.Flight();
		System.out.println("Portal login is successful");
		FlightPage fp=new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		
		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0, 1), ExcelUtils.readData("Sheet3", 1, 1));
		System.out.println("Oneway input is successful");
		Flightresult fr=new Flightresult(driver);
//        owr.airlineSearch(ExcelUtils.readData("Sheet3", 1, 2));
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		String b = fr.resultsPagesSavequote("chandan");
		ExcelUtils.writeData("Sheet3", 12, 1, b);
		

}
}
