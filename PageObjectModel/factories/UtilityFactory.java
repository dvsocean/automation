package factories;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class UtilityFactory {
	
	private WebDriver driver;
	
	public UtilityFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public String takeScreenShot(String fileName, String machinePath) throws Exception {
		String filename =  fileName + appendUniqueId() + ".png";
		File screenshotFile = new File(filename);
		if (screenshotFile.exists()) {
			Thread.sleep(1500);
			filename =  fileName + appendUniqueId() + ".png";
		}
		String imageDirectory = machinePath + "/RegressionForTespa/src/extent-reports/screenshots/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(imageDirectory + filename));
		String destinationFile = imageDirectory + filename;
		System.out.println("Failure detected, screenshot sent to: " + destinationFile);
		return destinationFile;
	}
	
	public static ExtentReports getERInstance(String browser, String reportName) {
		ExtentReports extent;
		String output = "src/extent-reports/" + reportName + fetchDate() + ".html";
		//Set to false to append to same report without overwriting
		extent = new ExtentReports(output, false);
		extent.addSystemInfo("Browser", browser);
		return extent;
	}
	
	private String appendUniqueId() {
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat("HH.mm.ss");
        return simple.format(calendar.getTime());
	}
	
	private static String fetchDate() {
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat("-MM-dd-yyyy");
        return simple.format(calendar.getTime());
	}
}
