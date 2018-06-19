package Portal.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import Portal.generic.BaseLib;
import Portal.Pageobjects.PortalLogin;
import Portal.generic.ExcelUtils;

public class Login extends BaseLib {
	//@Test()
	public void ValidLogin() throws InterruptedException{
		PortalLogin pl=new PortalLogin(driver);
		Thread.sleep(5000);
		pl.sendLogin(ExcelUtils.readData("Sheet1", 0, 1), ExcelUtils.readData("Sheet1", 1, 1), ExcelUtils.readData("Sheet1", 2, 1));
//		String a = pl.Exptxt();
		assertEquals("satguruportal",driver.getTitle(),"Login not verified" );
		System.out.println("Valid login verified");
		
	}
//	@Test()
	public void InvalidLogin() throws InterruptedException{
		PortalLogin pl=new PortalLogin(driver);
		Thread.sleep(5000);
		pl.sendLogin(ExcelUtils.readData("Sheet2", 2, 0), 
				ExcelUtils.readData("Sheet2", 2, 1),
				ExcelUtils.readData("Sheet2", 2, 2));
		String a = pl.InvalidTxt();
		assertEquals("Invalid credentials, Please try again.", a,"Invalid message not verified");
		System.out.println("Invalid message verified");
//	}
}
}
