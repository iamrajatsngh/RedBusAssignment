package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Cancel_Ticket_Page;

public class Cancel_Ticket_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Cancel_Ticket_Test.class);

	@Test
	public void CancelTicketFuntion() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes"))// Taking Action Yes/No From Excel File
		{

			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							
			Cancel_Ticket_Page can = new Cancel_Ticket_Page(driver);
			extentTest = extent.startTest("Cancel Ticket Funtionality ");
			Thread.sleep(5000);
			can.ClickOnManageIcon();
			Thread.sleep(2000);
			can.ClickOnCancelIcon();
			Thread.sleep(2000);

			String TicketNo = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("TicketNO");
			can.EnterTicketNumber(TicketNo);
			Thread.sleep(2000);
			String Email_Id = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("Email_id");
			can.EnterEmailId(Email_Id);
			Thread.sleep(2000);
			can.ClickOnSelectPassenger();
			Thread.sleep(2000);
			can.WarningMsgIsDisplayed();// Applying Assertion Warning Message is displayed
			logger.info("-----------CancelTicket Scenario passed Succesfully-------------------");

		}

		else {
			extentTest = extent.startTest("Cancel Ticket Funtionality  ");
			throw new SkipException("Cancel Ticket Funtionality  Test Case has been Skipped");

		}
	}
}
