package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.My_Profile_Window_Page;
import Pages_RedBus.Sign_In_Page;
import Pages_RedBus.Sign_Out_From_All_Devices_Page;
import Pages_RedBus.Wallet_Card_Window_Pages;

public class Sign_Out_From_All_Devices_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Sign_Out_From_All_Devices_Test.class);

	@Test
	public void ValidSignOutFromAllDevices() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "ValidSignOutFromAllDevices").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			extentTest = extent.startTest("Testing Sign Out Funtionality From All Devices with passed Assertion");
			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			My_Profile_Window_Page win = new My_Profile_Window_Page(driver);
			win.ClickOnProfileInfo();
			Sign_Out_From_All_Devices_Page sign = new Sign_Out_From_All_Devices_Page(driver);
			sign.ClickOnSignOutFromAllDevices();
			Wallet_Card_Window_Pages wallet1 = new Wallet_Card_Window_Pages(driver);
			wallet1.HelpBtNIsDisplayed();// Applying assertion

			logger.info("-----------ValidSignOutFromAllDevices Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ValidSignOutFromAllDevices");
			throw new SkipException("ValidSignOutFromAllDevices Test Case has been Skipped");
		}
	}

	@Test
	public void InValidSignOutFromAllDevices() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "InValidSignOutFromAllDevices").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with
																							// browser type

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			extentTest = extent.startTest("Testing SignOut From All Devices With Failed Assertion");
			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			My_Profile_Window_Page win = new My_Profile_Window_Page(driver);
			win.ClickOnProfileInfo();
			Sign_Out_From_All_Devices_Page sign = new Sign_Out_From_All_Devices_Page(driver);
			sign.ClickOnSignOutFromAllDevices();
			Wallet_Card_Window_Pages wallet1 = new Wallet_Card_Window_Pages(driver);
			wallet1.HelpBtNIsNotDisplayed();// // Applying Assertion that help button is not diplayed

			logger.info("-----------InValidSignOutFromAllDevices Scenario failed-------------------");
		} else {
			extentTest = extent.startTest("InValidSignOutFromAllDevices");
			throw new SkipException("InValidSignOutFromAllDevices Test Case has been Skipped");
		}

	}
}
