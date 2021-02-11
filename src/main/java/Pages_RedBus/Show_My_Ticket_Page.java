package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Show_My_Ticket_Page {

	WebDriver driver;

	public Show_My_Ticket_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='hmb']/div[2]/ul/li[4]/span/span")
	public WebElement Show_My_Ticket_BtN;

	@FindBy(how = How.XPATH, using = "//*[@id='searchTicketTIN']")
	public WebElement Ticket_No_Block;

	@FindBy(how = How.XPATH, using = "//*[@id='searchTicketEmail']")
	public WebElement Email_id_Block;

	@FindBy(how = How.XPATH, using = "//*[@id='ticketSearch']")
	public WebElement Search_Btn;

	public void ShowMyTicketBtn() throws Throwable {
		Show_My_Ticket_BtN.click();
		Thread.sleep(2000);
	}

	public void EnterTicketNo(String value) throws InterruptedException {
		Ticket_No_Block.sendKeys(value);
		Thread.sleep(2000);
	}

	public void EnterEmailId(String value) throws Throwable {
		Email_id_Block.sendKeys(value);
		Thread.sleep(2000);
	}

	public void ClickOnSearchBtn() throws InterruptedException {
		Search_Btn.click();
		Thread.sleep(2000);
	}

}