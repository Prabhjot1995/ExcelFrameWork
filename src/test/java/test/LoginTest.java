package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

@Test
public class LoginTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\BankCash.xlsx");
	String username = exlread.getCellData("Login", "Username", 2);
	String password = exlread.getCellData("Login", "Password", 2);

	public void usershouldbaletologin() {
		driver = BrowserFactory.init();
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.verfiyhomepage();
		page.username(username);
		page.password(password);
		page.signin();

		BrowserFactory.tearDown();
	}
}
