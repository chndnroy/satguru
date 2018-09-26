package ScenarioBasedRoundTrip;

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
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class AirIndiaExpRoundtrip extends Login {
	@Test
	public void RoundConnectingFlight() throws InterruptedException {
		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		pl.Flight();
		System.out.println("Portal login is successful");
		FlightPage fp = new FlightPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		System.out.println("Flight page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.RoundtripPage();
		System.out.println("Roundtrip Page is open");
		fp.RoundTripLCCInput(ExcelUtils.readData("Sheet3", 0, 7), ExcelUtils.readData("Sheet3", 1, 7));
		fp.preferredAirlineRoundtripselect("Air India Express");
		fp.PassengerRoundCombination1(driver);
		
		System.out.println("ROundtrip input is successful");
		Flightresult fr=new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		fr.BookLCCSpecial(driver);
		System.out.println("Book button clicked on Search result page");
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fdp.clickContinue(driver);
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.selectPassenger(driver);
		Thread.sleep(5000);
		pdp.selectAdultPassenger2(driver);
		Thread.sleep(5000);
		pdp.selectChildPassenger1(driver);
		Thread.sleep(5000);
//		pdp.SelectBaggageMealAdult1();
//		pdp.SelectBaggageMealAdult2();
//		pdp.SelectBaggageMealchild1();
		pdp.ProceedFrBuk();
		PaymentPage pp = new PaymentPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pp.walletPay();
		System.out.println("Wallet payment is done");
		ConfirmationPage cp = new ConfirmationPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 1);
		cp.ConfirmBooking();

}
}
