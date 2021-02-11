package Test_RedBus;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Search_Bus_Page;

public class Search_Bus_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Search_Bus_Test.class);

	@Test
	public void searchBuses() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "searchBuses").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Search_Bus_Page obj = new Search_Bus_Page(driver);
			extentTest = extent.startTest("Testing Search Bus Funtionality ");

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String SourceLocation = reader.getRowTestData("Sheet1", "searchBuses").get("Source");
			obj.sourceLocation(SourceLocation);
			String DestinationLocation = reader.getRowTestData("Sheet1", "searchBuses").get("Destination");
			obj.destinationLocation(DestinationLocation);
			obj.clickCalender();
			obj.chooseDate();
			obj.clickSearchBtn();
			Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));// Applying Assertion that title Search
																				// Bus Tickets is present

			logger.info("-----------searchBuses Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("searchBuses");
			throw new SkipException("searchBuses Test Case has been Skipped");
		}
	}
}