package Pages_RedBus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Update_Profile_Page {

	WebDriver driver;

	public Update_Profile_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[3]")
	public WebElement MyProfile;

	@FindBy(how = How.ID, using = "Editbtn")
	public WebElement editBtn;

	@FindBy(how = How.ID, using = "profile-displayName")
	public WebElement EditName;

	@FindBy(how = How.ID, using = "male")
	public WebElement Gender;

	@FindBy(how = How.ID, using = "Savebtn")
	public WebElement saveBtn;

//    nf_success

	public void editProfile() {

		MyProfile.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		editBtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void editValidName(String Name) {

		EditName.clear();
		EditName.sendKeys(Name);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void editInvalidName() {

		EditName.clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void finalSelect() throws Throwable {

		Gender.click();
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);

	}

}