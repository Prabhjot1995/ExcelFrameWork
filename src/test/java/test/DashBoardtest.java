package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class DashBoardtest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\BankCash.xlsx");
	String username = exlread.getCellData("Login", "Username", 2);
	String password = exlread.getCellData("Login", "Password", 2);

	public void Dashboardheader() {
		driver = BrowserFactory.init();
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.verfiyhomepage();
		page.username(username);
		page.password(password);

		DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);
		dash.dashboardheader();
		dash.bankandcash();
		dash.add();

		BrowserFactory.tearDown();

	}
}
