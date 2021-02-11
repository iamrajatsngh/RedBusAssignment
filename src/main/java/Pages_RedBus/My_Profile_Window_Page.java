package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class My_Profile_Window_Page {

	WebDriver driver;

	public My_Profile_Window_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='i-icon-profile']")
	public WebElement Profile_BTN_Info;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[3]")
	public WebElement My_Profile_Btn;

	@FindBy(how = How.XPATH, using = "//*[@id='rh_header']/div/div/div[2]/div[3]/div/a")
	public WebElement Help_Button;

	public void ClickOnProfileInfo() throws Throwable {
		Profile_BTN_Info.click();
		Thread.sleep(2000);
	}

	public void ClickOnMyProfile() throws Throwable {
		My_Profile_Btn.click();
		Thread.sleep(2000);
	}

	public void EditBtNIsDisplayed() {//Assertion Method
		Assert.assertEquals(true, Help_Button.isDisplayed());
	}
}
