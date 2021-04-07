package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver) {
this.driver=driver;	
}
@FindBy(xpath="//input[@id='username']")
WebElement USER_NAME_FEILD;
@FindBy(xpath="//input[@id='password']")
WebElement PASSWORD_FEILD;
@FindBy(xpath="//button[@name='login']")
WebElement SIGNIN_BUTTON;

public void verfiyhomepage() {
	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "HomePage not found!!");
}
public void username(String name) {
	USER_NAME_FEILD.sendKeys(name);
}
public void password(String pass) {
	PASSWORD_FEILD.sendKeys(pass);
}
public void signin() {
	SIGNIN_BUTTON.click();
}
}
