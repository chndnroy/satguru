package FLightSaveQuoteTestCases;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.generic.ExcelUtils;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class OnewayDetailPageSaveQuote extends Login{
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
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fr.book(driver);
		CrossSellingPage csp=new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		csp.noThanks();
		FlightDetailsPage fdp=new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		String b = fdp.DetailPageSaveQuote("chandan");
		ExcelUtils.writeData("Sheet3", 13, 1, b);
}
}
