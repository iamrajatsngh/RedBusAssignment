package Test_RedBus;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtils.Base_Class;

import Pages_RedBus.Sign_In_Page;

import Pages_RedBus.Update_Profile_Page;

public class Update_Profile_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Update_Profile_Test.class);

	@Test(priority = 1)
	public void ValidUpdate() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "ValidUpdate").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Sign_In_Page obj = new Sign_In_Page(driver);
			extentTest = extent.startTest("Update Profile Test ");

			obj.id();
			obj.signIn();
			obj.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj.SwitchWindow(User_name, password);
			obj.id();
			Update_Profile_Page upd = new Update_Profile_Page(driver);
			upd.editProfile();
			String updatedName = reader.getRowTestData("Sheet1", "ValidUpdate").get("Rename");
			upd.editValidName(updatedName);
			upd.finalSelect();
			Assert.assertTrue(driver.findElement(By.id("nf_success")).isDisplayed());// Applying Assertion

			logger.info("-----------ValidUpdate Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ValidUpdate");
			throw new SkipException("ValidUpdate Test Case has been Skipped");
		}
	}

	@Test(priority = 2)
	public void InvalidUpdate() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "InvalidUpdate").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));

			Sign_In_Page obj = new Sign_In_Page(driver);
			extentTest = extent.startTest("Update Profile Test ");

			obj.id();
			obj.signIn();
			obj.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj.SwitchWindow(User_name, password);
			obj.id();
			Update_Profile_Page upd = new Update_Profile_Page(driver);
			upd.editProfile();
			upd.editInvalidName();
			upd.finalSelect();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(driver.findElement(By.id("nf_success")).isDisplayed());// Applying Aseertion
			softAssert.assertAll();
			logger.info("-----------InValidUpdate Scenario Failed-------------------");

		} else {
			extentTest = extent.startTest("InvalidUpdate");
			throw new SkipException("InvalidUpdate Test Case has been Skipped");
		}
	}
}
