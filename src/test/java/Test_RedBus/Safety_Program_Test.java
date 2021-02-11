package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Safety_Program_Page;
import Pages_RedBus.Wallet_Card_Window_Pages;

public class Safety_Program_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Safety_Program_Test.class);

	@Test
	public void SafetyProgramFuntionalityCheck() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "SafetyProgramFuntionalityCheck").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							

			Safety_Program_Page safety = new Safety_Program_Page(driver);
			extentTest = extent.startTest("Testing Safety Program Funtionality");
			safety.ClickOnSafetyKnowMore();
			safety.ClickOnViewSafetyBtn();
			Wallet_Card_Window_Pages ab = new Wallet_Card_Window_Pages(driver);
			ab.HelpBtNIsDisplayed();// Applying Assertion that help btn is displayed

			logger.info("-----------SafetyProgramFuntionalityCheck Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("SafetyProgramFuntionalityCheck");
			throw new SkipException("SafetyProgramFuntionalityCheck Test Case has been Skipped");
		}

	}
}
