package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cancel_Ticket_Page {

	WebDriver driver;

	public Cancel_Ticket_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='manageHeaderdd']/div[2]")
	public WebElement Manage_Booking_Icon;

	@FindBy(how = How.XPATH, using = "//*[@id='hmb']/div[2]/ul/li[2]/span")
	public WebElement Cancel_Icon;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div[1]/div[1]/div/input")
	public WebElement Ticket_NO;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement Email;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[2]/div[2]/div")
	public WebElement Select_Passenger_Icon;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div[3]/div")
	public WebElement WarningIcon;

	public void ClickOnManageIcon() throws Throwable {
		Thread.sleep(5000);
		Manage_Booking_Icon.click();
	}

	public void ClickOnCancelIcon() throws InterruptedException {
		Thread.sleep(2000);
		Cancel_Icon.click();
	}

	public void EnterTicketNumber(String value) throws Throwable {
		Ticket_NO.sendKeys(value);
		Thread.sleep(2000);
	}

	public void EnterEmailId(String value) throws Throwable {
		Email.sendKeys(value);
		Thread.sleep(2000);
	}

	public void ClickOnSelectPassenger() throws InterruptedException {
		Select_Passenger_Icon.click();
		Thread.sleep(2000);
	}

	public void WarningMsgIsDisplayed() {
		Assert.assertEquals(true, WarningIcon.isDisplayed());
		;
	}
}
