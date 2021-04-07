package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashBoardPage extends BasePage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h2[text()=' Dashboard ']")
	WebElement DASHBOARD_HEADER;
	@FindBy(xpath = "//span[text()='Bank & Cash']")
	WebElement BANK_CASH_BUTTON;
	@FindBy(xpath = "//a[text()='New Account']")
	WebElement ADD_CUSTOMER_BUTTON;

	public void dashboardheader() {
		Assert.assertEquals(DASHBOARD_HEADER.getText(), "Dashboard", "DashBoard page not Found!!");
	}

	public void bankandcash() {
		WaitForElement(driver,5,BANK_CASH_BUTTON);
		BANK_CASH_BUTTON.click();
	}

	public void add() {
		WaitForElement(driver,5,ADD_CUSTOMER_BUTTON);
		ADD_CUSTOMER_BUTTON.click();
	}
}
