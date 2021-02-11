package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Know_more_Page {

	WebDriver driver;

	public Know_more_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='know_more']")
	public WebElement Know_More_BTN;

	@FindBy(how = How.XPATH, using = "//*[@name='tin']")
	public WebElement Ticket_Number;

	@FindBy(how = How.XPATH, using = "//*[@name='EmailId']")
	public WebElement EmaiIdValue;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	public WebElement Submit_Btn;

	@FindBy(how = How.XPATH, using = "//*[@id='rh_header']/div/div/a")
	public WebElement RedBus_Logo;

	public void clickSignin() {
		Know_More_BTN.click();
	}

	public void EnterTicketNumber(String name) throws Throwable {
		Ticket_Number.sendKeys(name);
		Thread.sleep(2000);
	}

	public void enterEmail(String name) throws Throwable {
		EmaiIdValue.sendKeys(name);
		Thread.sleep(2000);
	}

	public void clickSubmitBtm() throws Throwable {
		Submit_Btn.click();
		Thread.sleep(2000);
	}

	public void RedBusLogoIsPresent() {// Method for assertion
		Assert.assertEquals(true, RedBus_Logo.isDisplayed());// Assertion
	}

}
