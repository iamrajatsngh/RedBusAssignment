package Test_RedBus;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.rPool_Page;

public class rPool_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(rPool_Test.class);

	@Test
	public void carPool() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "carPool").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							
			rPool_Page obj = new rPool_Page(driver);
			extentTest = extent.startTest("rPool Test ");
			obj.findRide();
			obj.offerRide();
			Assert.assertTrue(driver
					.findElement(
							By.xpath("//*[@id='howItWorks']/div/div/div[2]/div[5]/div/div/div[1]/ul/li[1]/span[2]"))
					.isDisplayed());// Applying Assertion

			logger.info("-----------carPool Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("carPool");
			throw new SkipException("carPool Test Case has been Skipped");
		}

	}
}
