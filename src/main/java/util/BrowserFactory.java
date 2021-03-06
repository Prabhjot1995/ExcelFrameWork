package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser = null;
	static String url = null;

	public static void ReadConfig() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\congif.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Used Browser" + browser);
			url = prop.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static WebDriver init() {
		ReadConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
