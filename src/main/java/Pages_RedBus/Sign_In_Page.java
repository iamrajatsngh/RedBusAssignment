package Pages_RedBus;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.Base_Class;

public class Sign_In_Page extends Base_Class {

	WebDriver driver;

	public Sign_In_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "sign-in-icon-down")
	public WebElement Id;

	@FindBy(how = How.ID, using = "hc")
	public WebElement signIn;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.ID, using = "newFbId")
	public WebElement facebookBtn;

	@FindBy(how = How.ID, using = "email")
	public WebElement facebookEmail;

	@FindBy(how = How.ID, using = "pass")
	public WebElement facebookPass;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement LoginBtn;

	@FindBy(how = How.XPATH, using = "//button[@name='__CONFIRM__']")
	public WebElement confirm;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement close;

	public void id() throws InterruptedException {
		Thread.sleep(5000);
		Id.click();
		Thread.sleep(2000);
	}

	public void signIn() throws Throwable {
		signIn.click();
		Thread.sleep(2000);
	}

	public void googlebtn() throws InterruptedException {
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
	}

	public void SwitchWindow(String User_Name , String Password) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				facebookEmail.sendKeys(User_Name);
				facebookPass.sendKeys(Password);
				Thread.sleep(2000);
				LoginBtn.click();
			}

		}
		Thread.sleep(5000);

		driver.switchTo().window(parentwindow);
		Thread.sleep(2000);

	}

	public void SwitchToWindow(String User_Name , String Password) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				facebookEmail.sendKeys(User_Name);
				facebookPass.sendKeys(Password);
				Thread.sleep(2000);
				LoginBtn.click();
				Thread.sleep(2000);

			}

		}

	}
}
