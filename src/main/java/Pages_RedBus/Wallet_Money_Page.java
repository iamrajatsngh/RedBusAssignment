package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Wallet_Money_Page {

	WebDriver driver;

	public Wallet_Money_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='i-icon-profile']")
	public WebElement Profile_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[4]")
	public WebElement Wallet_BtN;
	
	@FindBy(how = How.XPATH, using = "//*[@id='userinfo']/div/p[2]/span[1]")
	public WebElement Wallet_verified_Icon;

	public void ClickOnProfileBtn() throws InterruptedException {
		Profile_BTN.click();
		Thread.sleep(2000);
	}

	public void ClickOnWalletBtN() throws Throwable {
		Wallet_BtN.click();
		Thread.sleep(2000);
	}

	
	
}
