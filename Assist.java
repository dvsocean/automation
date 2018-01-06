package environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.ExtentReports;

public class Assist {
	private static WebDriver driver;
	private int SOFT_WAIT = 10;
	private int HARD_WAIT = 5;
	
	public Assist() {
		//
	}
	
	public static ExtentReports getERInstance() {
		ExtentReports extent;
		String path = "/Users/ocean/Desktop/reportRunner.html";
		//Set to false to append to same report without overwriting
		extent = new ExtentReports(path, false);
		return extent;
	}
	
	public void scrollPixels(int x) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + x + ");");
    }
	
	public void selectEnvironment(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ocean/Documents/Selenium/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ocean/Documents/Selenium/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Currently FireFox and Chrome are supported browsers");
		}
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public void softWait() {
		driver.manage().timeouts().implicitlyWait(SOFT_WAIT, TimeUnit.SECONDS);
	}
	
	public void waitForElementPresenceBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, HARD_WAIT);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void fetchElementByTypeAndClick(String uniqeName, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Clicking by id: " + uniqeName);
			driver.findElement(By.id(uniqeName)).click();
		} else if (type.equals("name")) {
			System.out.println("Clicking by name: " + uniqeName);
			driver.findElement(By.name(uniqeName)).click();
		} else if (type.equals("class")) {
			System.out.println("Clicking by class: " + uniqeName);
			driver.findElement(By.className(uniqeName)).click();
		} else if (type.equals("xpath")) {
			System.out.println("Clicking by xPath: " + uniqeName);
			driver.findElement(By.xpath(uniqeName)).click();
		} else if (type.equals("tag")) {
			System.out.println("Clicking by tagName: " + uniqeName);
			driver.findElement(By.tagName(uniqeName)).click();
		} else if (type.equals("linkText")) {
			System.out.println("Clicking by linkText: " + uniqeName);
			driver.findElement(By.linkText(uniqeName)).click();
		} else if (type.equals("partialLinkText")) {
			System.out.println("Clicking by partialLinkText: " + uniqeName);
			driver.findElement(By.partialLinkText(uniqeName)).click();
		} else {
			System.out.println("Clicking by cssSelector: " + uniqeName);
			driver.findElement(By.cssSelector(uniqeName)).click();
		}
	}
	
	public void fetchElementByTypeAndSendKeys(String uniqeName, String type, String data) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Sending data to id: " + uniqeName);
			driver.findElement(By.id(uniqeName)).sendKeys(data);
		} else if (type.equals("name")) {
			System.out.println("Sending data to name: " + uniqeName);
			driver.findElement(By.name(uniqeName)).sendKeys(data);
		} else if (type.equals("class")) {
			System.out.println("Sending data to class: " + uniqeName);
			driver.findElement(By.className(uniqeName)).sendKeys(data);
		} else if (type.equals("xpath")) {
			System.out.println("Sending data to xPath: " + uniqeName);
			driver.findElement(By.xpath(uniqeName)).sendKeys(data);
		} else if (type.equals("tag")) {
			System.out.println("Sending data to tagName: " + uniqeName);
			driver.findElement(By.tagName(uniqeName)).sendKeys(data);
		} else if (type.equals("linkText")) {
			System.out.println("Sending data to linkText: " + uniqeName);
			driver.findElement(By.linkText(uniqeName)).sendKeys(data);
		} else if (type.equals("partialLinkText")) {
			System.out.println("Sending data to partialLinkText: " + uniqeName);
			driver.findElement(By.partialLinkText(uniqeName)).sendKeys(data);
		} else {
			System.out.println("Sending data to cssSelector: " + uniqeName);
			driver.findElement(By.cssSelector(uniqeName)).sendKeys(data);
		}
	}
	
	public static String takeScreenShot() throws Exception {
		String filename = Math.random() + ".png";
		String directory = "/Users/ocean/Desktop/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		String destinationFile = directory + filename;
		return destinationFile;
	}
	
	public void markCheckBox(By locator) {
		WebElement element = driver.findElement(locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
