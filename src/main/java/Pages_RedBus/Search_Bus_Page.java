package Pages_RedBus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_Bus_Page {

	WebDriver driver;

	public Search_Bus_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "src")
	public WebElement source;

	@FindBy(how = How.XPATH, using = "//*[@id='search']/div/div[1]/div/ul/li")
	public WebElement select_src;

	@FindBy(how = How.ID, using = "dest")
	public WebElement destination;

	@FindBy(how = How.XPATH, using = "//*[@id='search']/div/div[2]/div/ul/li")
	public WebElement select_dest;

	@FindBy(how = How.XPATH, using = "//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")
	public WebElement calender;

	@FindBy(how = How.XPATH, using = "//*[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[7]")
	public WebElement date;

	@FindBy(how = How.XPATH, using = "//*[@id='search_btn']")
	public WebElement search_btn;

	public void sourceLocation(String location) throws InterruptedException {
		Thread.sleep(5000);
		source.sendKeys(location);
		Thread.sleep(2000);
		select_src.click();
		Thread.sleep(2000);
	}

	public void destinationLocation(String location) throws Throwable {
		destination.sendKeys(location);
		Thread.sleep(2000);
		select_dest.click();
		Thread.sleep(2000);
	}

	public void clickCalender() throws Throwable {
		Thread.sleep(2000);
		calender.click();
	}

	public void chooseDate() throws Throwable {
		Thread.sleep(2000);
		date.click();
	}

	public void clickSearchBtn() throws InterruptedException {
		Thread.sleep(2000);
		search_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']")));
	}

}
