package Test_RedBus;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.Operator_Bus_Page;

public class Operator_Bus_Test extends Base_Class {
	public final static Logger logger = Logger.getLogger(Operator_Bus_Test.class);

	@Test
	public void searchBusesWithTopOperator() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "searchBusesWithTopOperator").get("ExecutionRequired");
		if (status.toLowerCase().trim().equals("yes")) { // Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Operator_Bus_Page obj = new Operator_Bus_Page(driver);
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			obj.clickOneTopOperator();
			obj.selectBusRoute();
			obj.clickCloseIcon();
			Assert.assertTrue(driver.getTitle().contains("Pune to Bangalore"));// Applying Assertion that title contains
																				// Pune to Bangalore
		} else {
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			throw new SkipException("Search Buses With Top Operator, Test Case has been Skipped");
		}
		logger.info("Buses found successfully");
	}

	@Test
	public void findAllBusOperators() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "findAllBusOperators").get("ExecutionRequired");
		if (status.toLowerCase().trim().equals("yes")) { // Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with
																							// browser type

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Operator_Bus_Page obj = new Operator_Bus_Page(driver);
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			obj.clickAllOperators();
			obj.switchWindow();
			Assert.assertTrue(driver.getTitle().contains("Abhimanyu"));// Applying Assertion that title contains
																		// Abhimanyu
		} else {
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			throw new SkipException("FIND ALL BUS OPERATOR, Test Case has been Skipped");//
		}
		logger.info("Bus operators found successfully");
	}
}