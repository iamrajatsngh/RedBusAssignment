package Test_RedBus;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.Modify_Date_Page;
import Pages_RedBus.Search_Bus_Page;

public class Modify_Date_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Modify_Date_Test.class);

	@Test
	public void modifyPage() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "modifyPage").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Search_Bus_Page obj = new Search_Bus_Page(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			extentTest = extent.startTest("modifyPage");
			String SourceLocations = reader.getRowTestData("Sheet1", "modifyPage").get("Source");
			obj.sourceLocation(SourceLocations);
			String DestinationLocations = reader.getRowTestData("Sheet1", "modifyPage").get("Destination");
			obj.destinationLocation(DestinationLocations);
			obj.clickCalender();
			obj.chooseDate();
			obj.clickSearchBtn();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Modify_Date_Page page = new Modify_Date_Page(driver);
			page.modify();
			page.switchButton();
			page.searchBtn();
			Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));// Applying Assertion that title Search
																				// Bus Tickets is present

			logger.info("-----------modifyPage Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("modifyPage");
			throw new SkipException("modifyPage Test Case has been Skipped");
		}
	}
}
