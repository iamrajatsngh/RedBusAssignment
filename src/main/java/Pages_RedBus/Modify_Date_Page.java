package Pages_RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Modify_Date_Page {
	WebDriver driver;

	public Modify_Date_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='onward-modify-btn g-button clearfix fl']")
	public WebElement modify;
	@FindBy(how = How.XPATH, using = "//*[@id='switchButton']")
	public WebElement switchBtn;
	@FindBy(how = How.XPATH, using = "//*[@id='fixer']/section/div/div[4]/button")
	public WebElement search;

	public void modify() {
		modify.click();
	}

	public void switchButton() throws Throwable {
		switchBtn.click();
		Thread.sleep(2000);
	}

	public void searchBtn() throws InterruptedException {
		search.click();
		Thread.sleep(2000);
		
	}

}