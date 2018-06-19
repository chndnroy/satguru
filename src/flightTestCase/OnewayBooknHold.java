package flightTestCase;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.flights.ConfirmationPage;
import Portal.Pageobjects.flights.CrossSellingPage;
import Portal.Pageobjects.flights.FlightDetailsPage;
import Portal.Pageobjects.flights.FlightPage;
import Portal.Pageobjects.flights.Flightresult;
import Portal.Pageobjects.flights.HoldingconfirmationPage;
import Portal.Pageobjects.flights.PassenegerDetailsPage;
import Portal.Pageobjects.flights.PaymentPage;
import Portal.generic.ExcelUtils;
import Portal.generic.FullpageScreenshot;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class OnewayBooknHold extends Login {
	@Test(priority=1)
	public void OnewatTckt() throws Exception
	{
		
		
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
         fr.book(driver);   
         System.out.println("Book button clicked on Search result page");
         Thread.sleep(10000);
         CrossSellingPage csp=new CrossSellingPage(driver);
         WaitStatementLib.implicitWaitforMinutes(driver, 2);
         csp.noThanks();
         FlightDetailsPage fdp=new FlightDetailsPage(driver);
 		WaitStatementLib.implicitWaitforMinutes(driver, 2);
         fdp.OnewaydetailPage();
         PassenegerDetailsPage pdp=new PassenegerDetailsPage(driver);
  		WaitStatementLib.implicitWaitforMinutes(driver, 2);
        pdp.searchAdultPass(ExcelUtils.readData("Sheet3", 3, 1),driver);
        System.out.println("Passenger selected from Select passenger");
        Thread.sleep(5000);
        pdp.bookNhold();
        Thread.sleep(5000);
        HoldingconfirmationPage hcp=new HoldingconfirmationPage(driver);
        hcp.confirmHolding();
        FullpageScreenshot f=new FullpageScreenshot();
		f.takescreenshot(driver);
        }

}
