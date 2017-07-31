package assist;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {
	WebDriver driver;
	
	public Helper(WebDriver driver){
		this.driver= driver;
	}
	
	public void close() {
		driver.quit();
		System.out.println("Browser has been closed");
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Window has been maximized");
	}
	
	public String getElementTextById(String id) {
		WebElement element= driver.findElement(By.id(id));
		String display= element.getText();
		System.out.println("Retrieved text from element: " + id);
		return display;
	}
	
	public WebElement fetchElementByType(String uniqeName, String type) {
		type= type.toLowerCase();
		if(type.equals("id")){
			System.out.println("Found element by id: " + uniqeName);
			return this.driver.findElement(By.id(uniqeName));
		} else if (type.equals("name")){
			System.out.println("Found element by name: " + uniqeName);
			return this.driver.findElement(By.name(uniqeName));
		} else if(type.equals("class")){
			System.out.println("Found element by class: " + uniqeName);
			return this.driver.findElement(By.className(uniqeName));
		} else if(type.equals("xpath")){
			System.out.println("Found element by xPath: " + uniqeName);
			return this.driver.findElement(By.xpath(uniqeName));
		} else if(type.equals("tag")) {
			System.out.println("Found element by tagName: " + uniqeName);
			return this.driver.findElement(By.tagName(uniqeName));
		} else if(type.equals("linkText")){
			System.out.println("Found element by linkText: " + uniqeName);
			return this.driver.findElement(By.linkText(uniqeName));
		} else if(type.equals("partialLinkText")){
			System.out.println("Found element by partialLinkText: " + uniqeName);
			return this.driver.findElement(By.partialLinkText(uniqeName));
		} else {
			System.out.println("Found element by cssSelector: " + uniqeName);
			return this.driver.findElement(By.cssSelector(uniqeName));
		}
	}
	
	public List<WebElement> fetchListOfElements(String uniqeName, String type) {
		type= type.toLowerCase();
		if(type.equals("id")){
			System.out.println("Found elements by id: " + uniqeName);
			return this.driver.findElements(By.id(uniqeName));
		} else if (type.equals("name")){
			System.out.println("Found elements by name: " + uniqeName);
			return this.driver.findElements(By.name(uniqeName));
		} else if(type.equals("class")){
			System.out.println("Found elements by class: " + uniqeName);
			return this.driver.findElements(By.className(uniqeName));
		} else if(type.equals("xpath")){
			System.out.println("Found elements by xPath: " + uniqeName);
			return this.driver.findElements(By.xpath(uniqeName));
		} else if(type.equals("tag")) {
			System.out.println("Found elements by tag: " + uniqeName);
			return this.driver.findElements(By.tagName(uniqeName));
		} else if(type.equals("linktext")){
			System.out.println("Found elements by linkText: " + uniqeName);
			return this.driver.findElements(By.linkText(uniqeName));
		} else if(type.equals("partiallinktext")){
			System.out.println("Found elements by partialLinkText: " + uniqeName);
			return this.driver.findElements(By.partialLinkText(uniqeName));
		} else {
			System.out.println("Found elements by cssSelector: " + uniqeName);
			return this.driver.findElements(By.cssSelector(uniqeName));
		}
	}
	
	public boolean isElementPresent(String uniqeName, String type) {
		List<WebElement> elements= fetchListOfElements(uniqeName, type);
		int size= elements.size();
		if(size > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sendDataById(String id, String sendKey){
		driver.findElement(By.id(id)).sendKeys(sendKey);
		System.out.println("Data sent to field: " + sendKey);
	}
	
	public void sendDataByxPath(String xPath, String sendKey){
		driver.findElement(By.xpath(xPath)).sendKeys(sendKey);
		System.out.println("Data sent to field: " + sendKey);
	}
	
	public void sendDataByName(String name, String sendKey){
		driver.findElement(By.name(name)).sendKeys(sendKey);
		System.out.println("Data sent to field: " + sendKey);
	}
	
	public void sendDataByClass(String className, String sendKey){
		driver.findElement(By.className(className)).sendKeys(sendKey);
		System.out.println("Data sent to field: " + sendKey);
	}
	
	public void dropDownById(String locator, String visibleText){
		WebElement element= driver.findElement(By.id(locator));
		Select sel= new Select(element);
		sel.selectByVisibleText(visibleText);
		//GET LIST OF ALL OPTIONS
		List<WebElement> allSelected= sel.getAllSelectedOptions();
		for(WebElement option : allSelected) {
			System.out.println("Selected item: " + option.getText());
		}
	}
	
	public void selectMultipleDropDownElementsById(String locator, String visibleText) {
		WebElement element= driver.findElement(By.id(locator));
		Select sel= new Select(element);
		sel.selectByVisibleText(visibleText);
		System.out.println("Selected item (Multiples): " + visibleText);
	}
	
	public void deselectAllItems(String locator) {
		WebElement element= driver.findElement(By.id(locator));
		Select sel= new Select(element);
		sel.deselectAll();
		System.out.println("Everything de-selected");
	}
	
	public void printAllSelectedItemsById(String locator) {
		WebElement element= driver.findElement(By.id(locator));
		Select sel= new Select(element);
		List<WebElement> selected= sel.getAllSelectedOptions();
		for(WebElement option : selected) {
			System.out.println("From multiple select: " + option.getText());
		}
	}
	
	public void uploadFileByName(String locateByName, String file){
		WebElement upload= driver.findElement(By.name(locateByName));
		upload.sendKeys(file);
	}
	
	public void clickButtonById(String id){
		WebElement button= driver.findElement(By.id(id));
		button.click();
		System.out.println("Clicked by id: " + id);
	}
	
	public void clickButtonByXpath(String xPath){
		driver.findElement(By.xpath(xPath)).click();
		System.out.println("Clicked by xPath: " + xPath);
	}
	
	public void clickButtonByName(String className){
		WebElement button= driver.findElement(By.className(className));
		button.click();
		System.out.println("Clicked by className: " + className);
	}
	
	public void getURL(String url){
		driver.get(url);
		System.out.println("activate URL address: " + url);
	}
	
	public void screenCapture() throws Exception{
		String filename= Math.random() + ".png";
		String directory= "/Users/Ocean/Desktop/";
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		System.out.println("Screen Capture sent to desktop");
	}
}