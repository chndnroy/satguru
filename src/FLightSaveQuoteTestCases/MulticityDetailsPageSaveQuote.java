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

public class MulticityDetailsPageSaveQuote extends Login{
	@Test
	private void MulticityTckt() throws Exception {
		PortalLogin pl = new PortalLogin(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2,1));
		System.out.println("Portal login is successful");
		FlightPage fp = new FlightPage(driver);
		fp.Flight();
		System.out.println("Flight page is open");
		fp.MulticityPage();
		System.out.println("Multicity page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.multicityinput(ExcelUtils.readData("Sheet3", 7,1), ExcelUtils.readData("Sheet3", 8,1),
				ExcelUtils.readData("Sheet3", 9,1), ExcelUtils.readData("Sheet3", 10,1));
		Flightresult fr = new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		fr.book(driver);
		System.out.println("Multicity search results is open");
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		System.out.println("Cross selling page is open");
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		String b = fdp.DetailPageSaveQuote("chandan");
		ExcelUtils.writeData("Sheet3", 14, 2, b);

}
}
