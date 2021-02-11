package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;
import Pages_RedBus.My_Profile_Window_Page;
import Pages_RedBus.Sign_In_Page;
import Pages_RedBus.Wallet_Card_Window_Pages;

public class Wallet_Card_Window_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Wallet_Card_Window_Test.class);

	@Test
	public void SavedCardInWallet() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "SavedCardInWallet").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Sign_In_Page obj1 = new Sign_In_Page(driver);
			extentTest = extent.startTest("Displaying saved cards in wallet ");

			obj1.id();
			obj1.signIn();
			obj1.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj1.SwitchWindow(User_name, password);
			My_Profile_Window_Page win = new My_Profile_Window_Page(driver);
			win.ClickOnProfileInfo();
			Wallet_Card_Window_Pages wallet = new Wallet_Card_Window_Pages(driver);
			wallet.ClickOnWalletCardBtN();
			wallet.HelpBtNIsDisplayed();// Applying assertion that help button is displayed

			logger.info("-----------SavedCardInWallet Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("SavedCardInWallet");
			throw new SkipException("SavedCardInWallet Test Case has been Skipped");
		}
	}
}
