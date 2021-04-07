package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddAccountPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddAccountTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\BankCash.xlsx");
	String username = exlread.getCellData("Login", "Username", 2);
	String password = exlread.getCellData("Login", "Password", 2);
	String account = exlread.getCellData("Bank", "Account", 2);
	String description = exlread.getCellData("Bank", "Description", 2);
	String balnace = exlread.getCellData("Bank", "Balance", 2);
	String accountnum = exlread.getCellData("Bank", "Account num", 2);
	String contact = exlread.getCellData("Bank", "Contact", 2);
	String phone = exlread.getCellData("Bank", "Phone", 2);
	String url = exlread.getCellData("Bank", "Url", 2);

	@Test
	public void usershouldabletoaddcustomer() {
		driver = BrowserFactory.init();
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.verfiyhomepage();
		page.username(username);
		page.password(password);
		page.signin();

		DashBoardPage dash = PageFactory.initElements(driver, DashBoardPage.class);
		dash.dashboardheader();
		dash.bankandcash();
		dash.add();

		AddAccountPage add = PageFactory.initElements(driver, AddAccountPage.class);
		add.title(account);
		add.desc(description);
		add.balance(balnace);
		add.account(accountnum);
		add.contact(contact);
		add.phone(phone);
		add.url(url);

		BrowserFactory.tearDown();

	}
}
