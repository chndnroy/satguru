package Portal.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

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
import Portal.generic.HandleFarePopup;
import Portal.generic.WaitStatementLib;

public class OnewayFlightTest extends Login {
	@Test()
	public void OnewatTckt() throws Exception {

		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		pl.Flight();
		System.out.println("Portal login is successful");
		FlightPage fp = new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);

		fp.Onewayinput(ExcelUtils.readData("Sheet3", 0, 1), ExcelUtils.readData("Sheet3", 1, 1));
		System.out.println("Oneway input is successful");
		Flightresult fr = new Flightresult(driver);
		// owr.airlineSearch(ExcelUtils.readData("Sheet3", 1, 2));
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fr.book(driver);
//		Thread.sleep(7000);
//		fr.farechange(driver);


		System.out.println("Book button clicked on Search result page");
		CrossSellingPage csp = new CrossSellingPage(driver);

		csp.noThanks();
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		Thread.sleep(5000);
		fdp.OnewaydetailPage();
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		System.out.println("Passenger selected from Select passenger");
		Thread.sleep(5000);
		pdp.ProceedFrBuk();
		PaymentPage pp = new PaymentPage(driver);
		pp.walletPay();
		ConfirmationPage cp = new ConfirmationPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 30);
		cp.ConfirmBooking();
		FullpageScreenshot fps = new FullpageScreenshot();
		fps.takescreenshot(driver);
	}
	// @Test(priority=0)
	// public void OnewayTcktUsingCreditCard() throws InterruptedException
	// {
	// PortalLogin pl=new PortalLogin(driver);
	// pl.sendLogin(ExcelUtils.readData("Sheet2", 1, 0),
	// ExcelUtils.readData("Sheet2", 1, 1),ExcelUtils.readData("Sheet2", 1, 2));
	// pl.Flight();
	// System.out.println("Portal login is successful");
	// FlightPage fp=new FlightPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fp.Onewayinput(ExcelUtils.readData("Sheet3", 1, 0),
	// ExcelUtils.readData("Sheet3", 1, 1));
	// System.out.println("Oneway input is successful");
	// Flightresult fr=new Flightresult(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fr.book();
	// System.out.println("Book button clicked on Search result page");
	//
	// CrossSellingPage csp=new CrossSellingPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// csp.noThanks();
	// FlightDetailsPage fdp=new FlightDetailsPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// fdp.clickContinue();
	// PassenegerDetailsPage pdp=new PassenegerDetailsPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 1, 3));
	// System.out.println("Passenger selected from Select passenger");
	// Thread.sleep(5000);
	// pdp.ProceedFrBuk();
	// PaymentPage pp=new PaymentPage(driver);
	// WaitStatementLib.implicitWaitforMinutes(driver, 2);
	// pp.CreditCardPay(driver, ExcelUtils.readData("Sheet3", 1, 13),
	// ExcelUtils.readData("Sheet3", 1, 14),
	// ExcelUtils.readData("Sheet3", 1, 15),
	// ExcelUtils.readData("Sheet3", 1, 16),
	// ExcelUtils.readData("Sheet3", 1, 17));
	// System.out.println("Credit card payment has been done");
	// ConfirmationPage cp=new ConfirmationPage(driver);
	//
	// }

}
