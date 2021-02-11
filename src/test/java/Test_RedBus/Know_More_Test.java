package Test_RedBus;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Know_more_Page;

public class Know_More_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Know_More_Test.class);

	@Test(priority = 1)
	public void KnowMoreFuntionalityCheck() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "KnowMoreFuntionalityCheck").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) // Taking Action Yes/No From Excel File
		{

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Know_more_Page more = new Know_more_Page(driver);
			extentTest = extent.startTest("Testing Know More Funtionality ");

			more.clickSignin();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String TicketNo = reader.getRowTestData("Sheet1", "KnowMoreFuntionalityCheck").get("TicketNO");
			more.EnterTicketNumber(TicketNo);
			String Email_Id = reader.getRowTestData("Sheet1", "KnowMoreFuntionalityCheck").get("Email_id");
			more.enterEmail(Email_Id);
			more.clickSubmitBtm();
			more.RedBusLogoIsPresent();// Applying Assertion that RedBus Logo is Present

			logger.info("-----------KnowMoreFuntionality Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("KnowMoreFuntionalityCheck");
			throw new SkipException("KnowMoreFuntionalityCheck Test Case has been Skipped");
		}
	}
}
