package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtils.Base_Class;

import Pages_RedBus.Know_more_Page;
import Pages_RedBus.Sign_In_Page;

public class Sign_In_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Sign_In_Test.class);

	@Test
	public void ValidSignIn() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "ValidSignIn").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			extentTest = extent.startTest("Valid Login with Facebook Test ");
			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			Know_more_Page nm = new Know_more_Page(driver);
			nm.RedBusLogoIsPresent();// Applying Assertion that RedBus logo is present

			logger.info("-----------ValidSignIn Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ValidSignIn");
			throw new SkipException("ValidSignIn Test Case has been Skipped");
		}
	}

	@Test
	public void InValidSignIn() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "InValidSignIn").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));

			Sign_In_Page obj2 = new Sign_In_Page(driver);
			extentTest = extent.startTest("Invalid Login with Facebook Test ");
			obj2.id();
			obj2.signIn();
			obj2.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "InValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "InValidSignIn").get("Password");
			obj2.SwitchToWindow(User_name, password);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
			softAssert.assertAll();
			logger.info("-----------InValidSignIn Scenario failed-------------------");

		} else {
			extentTest = extent.startTest("InValidSignIn");
			throw new SkipException("InValidSignIn Test Case has been Skipped");
		}
	}
}
