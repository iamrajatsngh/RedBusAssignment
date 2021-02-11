package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.My_Profile_Window_Page;
import Pages_RedBus.Sign_In_Page;

public class My_Profile_Window_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(My_Profile_Window_Test.class);

	@Test
	public void ProfileWindowCheck() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "ProfileWindowCheck").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			My_Profile_Window_Page win = new My_Profile_Window_Page(driver);
			Sign_In_Page obj3 = new Sign_In_Page(driver);

			extentTest = extent.startTest("Testing My Profile Info Button");
			obj3.id();
			obj3.signIn();
			obj3.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj3.SwitchWindow(User_name, password);
			win.ClickOnProfileInfo();
			win.ClickOnMyProfile();
			win.EditBtNIsDisplayed();// assertion applied that edit button is displayed

			logger.info("-----------ProfileWindowCheck Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ProfileWindowCheck");
			throw new SkipException("ProfileWindowCheck Test Case has been Skipped");
		}

	}
}
