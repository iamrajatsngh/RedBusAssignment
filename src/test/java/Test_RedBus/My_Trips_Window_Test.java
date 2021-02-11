
package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.My_Trips_Window_Page;
import Pages_RedBus.Sign_In_Page;

public class My_Trips_Window_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(My_Trips_Window_Test.class);

	@Test
	public void MyTripsWindow() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "MyTripsWindow").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			My_Trips_Window_Page win = new My_Trips_Window_Page(driver);
			extentTest = extent.startTest("Testing My Trips Button Funtionnality with passed assertion ");

			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			win.ClickOnUserIconBtn();
			win.ClickOnMyTripsBtn();
			win.CompletedBtNIsDisplayed();// Appling Assertion That Completed trips button is displayed

			logger.info("-----------MyTripsWindow Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("MyTripsWindow");
			throw new SkipException("MyTripsWindow Test Case has been Skipped");
		}
	}

	@Test
	public void MyTripsWindowFailed() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "MyTripsWindowFailed").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			My_Trips_Window_Page win = new My_Trips_Window_Page(driver);
			extentTest = extent.startTest("Testing My Trips Button Funtionnality with failed assertion ");

			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			win.ClickOnUserIconBtn();
			win.ClickOnMyTripsBtn();
			win.CompletedBtNIsNotDisplayed();// Appling Assertion(Failed) that completed trips button is not displayed

			logger.info("-----------MyTripsWindow Scenario failed-------------------");
		} else {
			extentTest = extent.startTest("MyTripsWindow");
			throw new SkipException("MyTripsWindow Test Case has been Skipped");
		}
	}
}
