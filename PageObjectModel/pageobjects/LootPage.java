package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LootPage {
	
	//So the page uses the same instances
//	private WebDriver driver;
	private int SOFT_WAIT = 10;
	
	private static String SELECT_IMAGES = "//input[contains(@name, 'qqfile') and contains(@type, 'file')]";
	private String image = "/Users/ocean/Pictures/code2.jpg";
	private String DESCRIPTION_DETAILS = "TEST DESCRIPTION DETAILS IF ANYONE CARES, TEST DESCRIPTION DETAILS IF ANYONE CARES";
	private String KEY_USES = "1500";
	
	
	@FindBy(id="login") 
	//Use this annotation for elements that don't change and are constantly used
	@CacheLookup
	WebElement form;
	
	@FindBy(how=How.ID,using="email")
	WebElement emailInput;
	
	@FindBy(how=How.ID,using="password-input")
	WebElement passwordInput;
	
	@FindBy(how=How.XPATH,using="//div[@class='ts-list ts-list--admin-nav']/div[text()='Benefits']")
	WebElement BENEFITS_DROPDOWN;

	@FindBy(how=How.XPATH,using="//a[contains(@href, '/admin/benefits') and contains(@class, 'ts-dropdown-item')]")
	WebElement BENEFITS_ITEM;
	
	@FindBy(how=How.XPATH,using="//button[text()='ADD']")
	WebElement ADD_BUTTON;
	
	@FindBy(how=How.XPATH,using="//button[text()='ADD COVER PHOTO']")
	WebElement ADD_COVER_PHOTO;
	
	@FindBy(how=How.XPATH,using="//button[@id='save-image-upload']")
	WebElement SAVE_IMAGE_BUTTON;
	
	@FindBy(how=How.XPATH,using="//input[@id='name']")
	WebElement BENEFIT_NAME_XPATH;
	
	@FindBy(how=How.XPATH,using="//iframe[@title='Rich Text Editor, benefit-description']")
	WebElement DESC;
	
	@FindBy(how=How.XPATH,using="//div[@class='ts-input-container ts-input-container__spacing--bottom']/input[@id='start_date']")
	WebElement START_DATE;
	
	@FindBy(how=How.XPATH,using="//input[@id='expiration']")
	WebElement END_DATE;
	
	@FindBy(how=How.XPATH,using="//input[@id='single-key']")
	WebElement KEY_TYPE;
	
	@FindBy(how=How.XPATH,using="//input[@id='single-key-value']")
	WebElement KEY_VALUE_XPATH;
	
	@FindBy(how=How.XPATH,using="//input[@id='single-quantity']")
	WebElement KEY_USES_XPATH;
	
	@FindBy(how=How.XPATH,using="//button[@id='update-benefit']")
	WebElement SAVE_BUTTON;
	
//	public LootPage() {
////		this.driver = driver;
//	}
	
	public void logIn(String username, String password) {
		emailInput.sendKeys(username);
		passwordInput.sendKeys(password);
		form.submit();
	}
}
