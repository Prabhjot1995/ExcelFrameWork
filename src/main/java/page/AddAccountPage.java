package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAccountPage extends BasePage {
	WebDriver driver;

	public AddAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='account']")
	WebElement ACCOUNT_TITLE_FEILD;
	@FindBy(xpath = "//input[@id='description']")
	WebElement DESCPRTION_FEILD;
	@FindBy(xpath = "//input[@id='balance']")
	WebElement BALANCE_FEILD;
	@FindBy(xpath = "//input[@id='account_number']")
	WebElement ACCOUNT_FEILD;
	@FindBy(xpath = "//input[@id='contact_person']")
	WebElement CONTACT_PERSON;
	@FindBy(xpath = "//input[@id='contact_phone']")
	WebElement PHONE_NUMBER_FEILD;
	@FindBy(xpath = "//input[@id='ib_url']")
	WebElement URL_FEILD;
	@FindBy(xpath = "//button[text()=' Submit']")
	WebElement SUMBIT_BUTTON;

	public void title(String account) {
		int num = RandomNums(999);
		ACCOUNT_TITLE_FEILD.sendKeys(account + num);
	}

	public void desc(String desc) {
		int num = RandomNums(999);
		DESCPRTION_FEILD.sendKeys(desc + num);
	}

	public void balance(String bal) {
		int num = RandomNums(999);
		BALANCE_FEILD.sendKeys(bal + num);
	}

	public void account(String acco) {
		int num = RandomNums(999);
		ACCOUNT_FEILD.sendKeys(acco + num);
	}

	public void contact(String tact) {
		CONTACT_PERSON.sendKeys(tact);
	}

	public void phone(String phone) {
		int num = RandomNums(999);
		PHONE_NUMBER_FEILD.sendKeys(phone + num);
	}

	public void url(String url) {
		URL_FEILD.sendKeys(url);
	}

	public void save() {
		SUMBIT_BUTTON.click();
		
	}
}
