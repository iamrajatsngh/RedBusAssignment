package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Sign_In_Page;
import Pages_RedBus.Wallet_Card_Window_Pages;
import Pages_RedBus.Wallet_Money_Page;

public class Wallet_Money_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Wallet_Money_Test.class);

	@Test
	public void WalletBalanceCheck() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "WalletBalanceCheck").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							
			Sign_In_Page obj2 = new Sign_In_Page(driver);
			Wallet_Money_Page obj = new Wallet_Money_Page(driver);
			extentTest = extent.startTest(" Wallet Money Checking Funtionality");

			obj2.id();
			obj2.signIn();
			obj2.googlebtn();
			String User_name = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			obj2.SwitchWindow(User_name, password);
			obj.ClickOnProfileBtn();
			obj.ClickOnWalletBtN();
			Wallet_Card_Window_Pages obj1 = new Wallet_Card_Window_Pages(driver);
			obj1.HelpBtNIsDisplayed();// Applying Assertion that help button is diplayed

			logger.info("-----------SavedCardInWallet Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("WalletBalanceCheck");
			throw new SkipException("WalletBalanceCheck Test Case has been Skipped");
		}
	}
}
