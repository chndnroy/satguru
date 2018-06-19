package Portal.scripts.creditcard;

import org.testng.annotations.Test;

import Portal.Pageobjects.PortalLogin;
import Portal.Pageobjects.Insurance.INSSearchresultPage;
import Portal.Pageobjects.Insurance.InsuranceConfirmationPage;
import Portal.Pageobjects.Insurance.InsuranceDetailsPage;
import Portal.Pageobjects.Insurance.InsuranceSearchPage;
import Portal.Pageobjects.Insurance.PassengerDetailsPage;
import Portal.Pageobjects.flights.PaymentPage;
import Portal.generic.ExcelUtils;
import Portal.generic.WaitStatementLib;
import Portal.scripts.Login;

public class InsuranceCreditCard extends Login{
	@Test
	public void bookInsurance() throws InterruptedException {
		PortalLogin pl = new PortalLogin(driver);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1),
				ExcelUtils.readData("Sheet1", 2, 1));

		pl.Insurance();
		System.out.println("Portaln login is successful");
		System.out.println("Insurance page is open");
		InsuranceSearchPage isp = new InsuranceSearchPage(driver);
		System.out.println("Insurance page is open");
		WaitStatementLib.implicitWaitforMinutes(driver, 2);
		isp.Insuranceinput(ExcelUtils.readData("Sheet2", 0, 1), ExcelUtils.readData("Sheet2", 1, 1),
				ExcelUtils.readData("Sheet2", 2, 1));
		INSSearchresultPage isrp=new INSSearchresultPage(driver);
		isrp.GadgetInsurance(driver);
		InsuranceDetailsPage id=new InsuranceDetailsPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		id.clickContinue();
		PassengerDetailsPage pdp=new PassengerDetailsPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		pdp.selectPassenger(ExcelUtils.readData("Sheet3", 3, 1));
		pdp.ProceedFrBuk();
		PaymentPage pp=new PaymentPage(driver);
		pp.walletPay();
		InsuranceConfirmationPage icp=new InsuranceConfirmationPage(driver);
		WaitStatementLib.implicitWaitforSeconds(driver, 10);
		icp.ConfirmBooking();

	}


}
