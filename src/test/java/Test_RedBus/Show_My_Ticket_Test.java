package Test_RedBus;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.Base_Class;

import Pages_RedBus.Cancel_Ticket_Page;
import Pages_RedBus.Know_more_Page;
import Pages_RedBus.Show_My_Ticket_Page;

public class Show_My_Ticket_Test extends Base_Class {

	public final static Logger logger = Logger.getLogger(Show_My_Ticket_Test.class);

	@Test
	public void ShowMyTicket() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "ShowMyTicket").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {// Taking Action Yes/No From Excel File
			driverInitialize(prop.getProperty("Browser"), prop.getProperty("BrowserType"));// starting Browser with browser type
																							
			Cancel_Ticket_Page can = new Cancel_Ticket_Page(driver);
			extentTest = extent.startTest("ShowMyTicket");
			can.ClickOnManageIcon();
			Show_My_Ticket_Page show = new Show_My_Ticket_Page(driver);
			show.ShowMyTicketBtn();
			String NoTicket = reader.getRowTestData("Sheet1", "ShowMyTicket").get("TicketNO");
			show.EnterTicketNo(NoTicket);
			String id_Email = reader.getRowTestData("Sheet1", "ShowMyTicket").get("Email_id");
			show.EnterEmailId(id_Email);
			show.ClickOnSearchBtn();
			Know_more_Page obj1 = new Know_more_Page(driver);
			obj1.RedBusLogoIsPresent();// Applying Assertion that redbus logo is present

			logger.info("-----------Show_My_Ticket_Test Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ShowMyTicket");
			throw new SkipException("ShowMyTicket Test Case has been Skipped");
		}
	}
}
