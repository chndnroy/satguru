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

public class FlightPlusInsuranceTest extends Login {
	@Test
	public void RoundtripTckt() throws Exception {
		PortalLogin pl = new PortalLogin(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		System.out.println("Portal login is successful");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		FlightPage fp = new FlightPage(driver);
		fp.Flight();
		System.out.println("Flight page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		fp.RoundtripPage();
		System.out.println("Roundtrip Page is open");
		fp.RoundTripInput(ExcelUtils.readData("Sheet3", 5, 1), ExcelUtils.readData("Sheet3", 6, 1));
		Flightresult fr = new Flightresult(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 4);
		fr.book(driver);
		System.out.println("FLight Result page is open");
		CrossSellingPage csp = new CrossSellingPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		csp.noThanks();
		System.out.println("Cross selling page is open");
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		Thread.sleep(10000);

		fdp.FLightNInsurance(driver);
		System.out.println("Flight + Insurance details page is open");
		PassenegerDetailsPage pdp = new PassenegerDetailsPage(driver);
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1), driver);
		System.out.println("Passenger selected from Select passenger");
		Thread.sleep(5000);
        pdp.ProceedFrBuk();
        PaymentPage pp=new PaymentPage(driver);
        pp.walletPay();
        ConfirmationPage cp=new ConfirmationPage(driver);
        WaitStatementLib.implicitWaitforSeconds(driver, 30);
        cp.ConfirmBooking();
        FullpageScreenshot f=new FullpageScreenshot();
		f.takescreenshot(driver);
	}
}
