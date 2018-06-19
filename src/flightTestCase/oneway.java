package flightTestCase;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.flights.ConfirmationPage;
import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.Pageobjects.flights.PassenegerDetailsPage;
import Portal.Pageobjects.flights.PaymentPage;
import Portal.generic.ExcelUtils;
import Portal.generic.FullpageScreenshot;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class oneway extends Login {
	@Test
	public void OnewatTckt() throws Exception {
		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0,1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2,1));
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pl.Flight();
		FlightPage fp = new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0,1), ExcelUtils.readData("Sheet3", 1, 1));
		Flightresult fr = new Flightresult(driver);
		fr.book(driver);
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 1);
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 255);
		fdp.clickContinue(driver);
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3,1), driver);
		Thread.sleep(3000);
		pdp.ProceedFrBuk();
		PaymentPage pp = new PaymentPage(driver);
		Thread.sleep(3000);
		pp.walletPay();
		ConfirmationPage cp = new ConfirmationPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		cp.ConfirmBooking();
		FullpageScreenshot f=new FullpageScreenshot();
		FullpageScreenshot.takescreenshot(driver);

	}
}
