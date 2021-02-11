package Pages_RedBus;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Wallet_Card_Window_Pages {

	WebDriver driver;

	public Wallet_Card_Window_Pages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[2]")
	public WebElement Wallet_Card_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='rh_header']/div/div/div[2]/div[3]/div/a")
	public WebElement Help_BTN;

	public void ClickOnWalletCardBtN() throws Throwable {
		Wallet_Card_BTN.click();
		Thread.sleep(2000);
	}

	public void HelpBtNIsDisplayed() {
		Assert.assertEquals(true, Help_BTN.isDisplayed());// Assertion Method
	}

	public void HelpBtNIsNotDisplayed() throws IOException {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(Help_BTN.isDisplayed());
		softAssert.assertAll();

	}
}