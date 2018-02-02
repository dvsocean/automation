package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Launching instance of Chrome driver");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Launching instance of Firefox driver");
		} else {
			System.out.println("Only FireFox and Chrome are supported browsers");
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static void destroyDriver() {
		driver.quit();
		System.out.println("Instance of webdriver has been destroyed!!");
	}
}
