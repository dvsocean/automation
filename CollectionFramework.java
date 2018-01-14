public void selectWebDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/danielocean/Documents/Selenium/webdrivers/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Launching instance of Chrome driver");
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/danielocean/Documents/Selenium/webdrivers/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Launching instance of Firefox driver");
		} else {
			System.out.println("Only FireFox and Chrome are supported browsers");
		}
	}
	
	public static String takeScreenShot() throws Exception {
		String filename = Math.random() + ".png";
		String directory = "/Users/danielocean/Desktop/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));
		String destinationFile = directory + filename;
		System.out.println("Screenshot created: " + destinationFile);
		return destinationFile;
	}
	
	private void softWait() {
		driver.manage().timeouts().implicitlyWait(SOFT_WAIT, TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
	}
	
	public void destroyDriver() {
		driver.quit();
		System.out.println("Instance of webdriver has been destroyed!");
	}
	
	private static void uploadFile(String pathToFile) {
		WebElement element = driver.findElement(By.xpath(SELECT_IMAGES));
		element.sendKeys(pathToFile);
	}
	
	private static String benefitNameGenerator() {
        String[] namesArray = new String[]{"Smith made me do it", "Jonesy got a gun", "Hall or maybe Tall", "Soo is referentially translucent", "Miller me this just make it cold",
                                            "Zerkel will take care of it", "Hart, close to a human heart", "default name in China is Lee", "Gibson the actor not the guitar", "Meeting a Tom while on a Cruise",
                                            "Fox could be a car", "Spears lucked out in life", "Milton shouldve been the president", "My desicion, set in Stone", "A small Hart is worse than a big Johnson",
                                            "Heart black as the lambo West got", "get Green or die tryin", "Love me or hate me", "Hogan is the that guy who likes to stare", "broken and bruised on White water rapids", "never fear deep Waters",
                                            "The truck with Rogers written on the side", "Big Thomas Dean will make me rich", "Willis or will not", "Gilbert Brown is one tough ninja", "You shouldve been ready for UC Davis",
                                            "Talking to Wilson made me crazy", "Martin-ov lets just hope I dont see him again", "What does Harris do for gaming", "Walker is the eyes of a ranger", "Robinson has no idea what came to mind",
                                            "Wright is always ready for flight", "Baker is conformity and laziness", "In your mind you should be Young" , "I see fire burning Stewarts hair" , "Rhonda Rhoads could be a black girls name" ,
                                            "A girl named Tate I wouldve guessed" , "Like Ocean waves play games with beaches" , "Senor Redderick, where is your battle-axe" , "Su, but my dad tried naming me Suwandi" , "Adams sounds like cheap beer" ,
                                            "Stone cold Steve Austin" , "Beyonce Noles, yeah I spelled it wrong" , "West like the East knows the sun" , "A guy named Ramirez" , "Amber Brown, not a name for gamers" , "Great White sharks are the devil",
                                            "Graves are what shes seen", "Henningson is our mediator", "While Antonius listens he does not laugh", "Lakewood is my home but its your ride", "Shots to the chest McClain"};
        int index = (int) (Math.random() * namesArray.length);
        return namesArray[index];
    }
	
	private static String keyValues() {
        String[] namesArray = new String[]{"John", "Mike", "Juan", "Matt", "Tate",
                                            "Aaron", "Vinson", "Dan", "Adam", "Scott",
                                            "Bill", "Tom", "Sean", "Paula", "Taylor",
                                            "Peter", "Lance", "Joel", "Ben", "Sara",
                                            "Sam", "Terry", "Harry", "Jennifer", "Tim",
                                            "Bob", "Jack", "Edwin", "Chuck", "Nicky",
                                            "Alex", "Gary", "Helen" , "Alice" , "Tasha" ,
                                            "Mary" , "Lucy" , "Derek" , "Alan" , "Jose" ,
                                            "Oscar" , "Harold" , "Alexander" , "Tammy"};
        int index = (int) (Math.random() * namesArray.length);
        return namesArray[index];
    }
	
	private String todaysDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); 
		return sdf.format(cal.getTime());	
	}
	
	private String todaysDatePlusFive() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); 
		cal.add(Calendar.DATE, 5); // Adding 5 days
		return sdf.format(cal.getTime());	
	}

	public static ExtentReports getERInstance(String browser) {
		ExtentReports extent;
		String path = "/Users/danielocean/Desktop/reportRunner.html";
		//Set to false to append to same report without overwriting
		extent = new ExtentReports(path, false);
		extent.addSystemInfo("Browser", browser);
		return extent;
	}
	
	public void scrollPixels(int x) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + x + ");");
        System.out.println("Scrolled down " + x + " pixels");
    }
	
	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1000);");
		System.out.println("Scrolled down 1000 pixels");
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
		System.out.println("Navigate to: " + url);
	}
	
	public void softWait() {
		driver.manage().timeouts().implicitlyWait(SOFT_WAIT, TimeUnit.SECONDS);
		System.out.println("Implicit wait applied to test");
	}
	
	public void waitForElementPresenceBy(By by) {
		WebDriverWait wait = new WebDriverWait(driver, HARD_WAIT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		System.out.println("Waiting for presence of element");
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
	
	public void markCheckBox(By by) {
		WebElement element = driver.findElement(by);
		if(!element.isSelected()) {
			element.click();
		}
		System.out.println("Checked checkbox targeted with a By object");
	}
	
	public void submitForm(By by) {
        WebElement element = driver.findElement(by);
        element.submit();
        System.out.println("Form submitted");
    }
	
	public boolean isExists(By by) {
        boolean displayed = false;
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            displayed = true;
            System.out.println("Element isExists evaluated to: true");
        }
        return displayed;
    }
	
	public boolean confirmTitle(String expected) {
        boolean result = false;
        String actual = driver.getTitle();
        if (expected.equals(actual)) {
            result = true;
            System.out.println("Title confirmed true: " + expected);
        } else {
        		System.out.println("Titles don't match!");
        }
        return result;
    }
	
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser has quit!");
	}
	
	public String todaysDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); 
		return sdf.format(cal.getTime());	
	}
	
	public String todaysDatePlusFive() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); 
		cal.add(Calendar.DATE, 5); // Adding 5 days
		return sdf.format(cal.getTime());	
	}