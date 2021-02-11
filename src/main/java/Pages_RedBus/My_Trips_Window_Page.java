package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class My_Trips_Window_Page {

	WebDriver driver;

	public My_Trips_Window_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='i-icon-profile']")
	public WebElement User_Icon_Btn;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[1]")
	public WebElement My_Trips_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='Upcoming']")
	public WebElement Upcoming_Trips_Btn;

	public void ClickOnUserIconBtn() throws Throwable {
		User_Icon_Btn.click();
		Thread.sleep(2000);
	}

	public void ClickOnMyTripsBtn() throws InterruptedException {
		My_Trips_BTN.click();
		Thread.sleep(2000);

	}

	public void CompletedBtNIsDisplayed() throws InterruptedException {
		Assert.assertEquals(true, Upcoming_Trips_Btn.isDisplayed());
		Thread.sleep(2000);
	}

	public void CompletedBtNIsNotDisplayed() throws Throwable {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(Upcoming_Trips_Btn.isDisplayed());
		softAssert.assertAll();
		Thread.sleep(2000);
	}

}
