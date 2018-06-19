package flightTestCase;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.flights.ConfirmationPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.HoldingconfirmationPage;
import Portal.Pageobjects.flights.PassenegerDetailsPage;
import Portal.Pageobjects.flights.PaymentPage;
import Portal.generic.ExcelUtils;
import Portal.generic.FullpageScreenshot;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;
import portal.Pageobjects.Homepage.Homepage;
import portal.Pageobjects.Homepage.MyBooking;

public class BookHoldTicket extends Login {
	@Test(priority=2)
	public void HoldTicketbooking() throws Exception {
		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		Homepage h = new Homepage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 20);
		h.mybookings();
		MyBooking mb = new MyBooking(driver);
		mb.searchHoldTicket();
		mb.payBookHoldTicket();
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		
		fdp.OnewaydetailPage();
		
		PaymentPage pp = new PaymentPage(driver);
		Thread.sleep(5000);
		pp.walletPay();
		HoldingconfirmationPage hcp=new HoldingconfirmationPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		hcp.confirmHolding();
		FullpageScreenshot f=new FullpageScreenshot();
		f.takescreenshot(driver);
	}

}
