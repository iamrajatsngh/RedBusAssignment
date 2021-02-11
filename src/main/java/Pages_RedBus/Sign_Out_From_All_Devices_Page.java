package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Sign_Out_From_All_Devices_Page {

	WebDriver driver;

	public Sign_Out_From_All_Devices_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='signOutAllLink']")
	public WebElement Sign_Out_From_All_Devices_BUTTON;

	public void ClickOnSignOutFromAllDevices() {
		Sign_Out_From_All_Devices_BUTTON.click();
	}

}
