package com.selenium.selenium_advance_topics;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class ObjectRepositoryExample {

	WebDriver driver;
	Properties propertyobj;
	TakesScreenshot scrShot;
	


	@BeforeClass
	public void setProperty () throws IOException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:\\software\\chromedriver83.exe");
		 propertyobj = new Properties(); 
		FileInputStream fileObject = new FileInputStream("src/test/resources/registration-locators.properties");
		propertyobj.load(fileObject);
		scrShot  =((TakesScreenshot)driver);
		

	
	}
	
	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();

		driver.navigate().to("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html");

		driver.manage().window().maximize();
		
		WebElement okButtun = driver.findElement(By.id("cookieChoiceDismiss"));
		boolean isOkAvaileble = okButtun.isDisplayed();
		if (isOkAvaileble == true) {
			okButtun.click();
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,23/00)");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// u can use TimeUnit.SECONDS method for giving time in seconds
	}

	//@Test
	public void nameLableTest() {

		String expectedTitle = "Name";
		WebElement name = driver
				.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[1]/td[1]"));

	}

	//@Test
	public void textField() {
		driver.findElement(By.xpath(propertyobj.getProperty("name-textField"))).sendKeys("Neha Oza");
		driver.findElement(By.xpath(propertyobj.getProperty("email-textField"))).sendKeys("nehaoza1307@123456");
		driver.findElement(By.xpath(propertyobj.getProperty("zipCode-textField"))).sendKeys("123456");
				
	}
	//@Test
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")));			
		//driver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")).click();
		//example of explicit wait that the select button is visible or not.
	}
	@Test
	public void nameErrorVerify() throws IOException {
		driver.findElement(By.xpath(propertyobj.getProperty("name-textField"))).sendKeys("   ");
		driver.findElement(By.xpath(propertyobj.getProperty("submit"))).click();
		String actualError = driver.findElement(By.xpath(propertyobj.getProperty("name-Error"))).getText();this.takeSnapShot(driver, "/home/saurabh/Desktop/takescreenShot.jpeg") ;
		assertEquals(actualError,	"Please provide your name");
		     
		
	}

	private void takeSnapShot(WebDriver driver2, String filename) throws IOException {
		Date oDate = new Date();
        SimpleDateFormat oSDF = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss");
        String sDate = oSDF.format(oDate);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            // If you want to store the image please uncomment the below code
             String destination ="target/error-screenshots/"+"Screenshot_" + sDate + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination); 
        }catch (IOException e){
            e.printStackTrace();
        }
	}

	@AfterMethod
	public void closeWebPage() {
		driver.close();

	}

}
