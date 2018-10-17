package RetrieveQuote;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.generic.ExcelUtils;
import Portal.scripts.Login;
import portal.Pageobjects.Homepage.Homepage;
import portal.Pageobjects.Homepage.SearchQuotesPage;

public class flightRetrieveQuote extends Login {
	@Test
	private void FlightQuoteBooking() {

		PortalLogin pl=new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));
		Homepage h=new Homepage(driver);
		h.MyQuotes();
		SearchQuotesPage sqp=new SearchQuotesPage(driver);
		sqp.SearchQuote(ExcelUtils.readData("Sheet3", 12, 1));
		
	}

}
