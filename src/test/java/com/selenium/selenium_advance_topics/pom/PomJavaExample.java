package com.selenium.selenium_advance_topics.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class PomJavaExample {

	WebDriver driver;
	Properties propertyobj;
	PomJava pom1 ;	
	PomSelenium pom;
	 WebDriverWait wait;


	@BeforeClass
	public void setProperty () throws IOException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:\\software\\chromedriver83.exe");
	     

		 propertyobj = new Properties(); 
		//FileInputStream fileObject = new FileInputStream("/home/saurabh/eclipse-workspace/selenium-advance-topics/registration-locators");
		//propertyobj.load(fileObject);
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();

		driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/" );
			

		driver.manage().window().maximize();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,23/00)");
		wait = new WebDriverWait(driver,10);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// u can use TimeUnit.SECONDS method for giving time in seconds
		pom1 = new PomJava(driver,propertyobj);
		pom = new PomSelenium(driver, propertyobj);
		
	}

	//@Test
	public void nameLableTest() {

		String expectedTitle = "Name";
		WebElement name = driver
				.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[1]/td[1]"));

	}

	//@Test
	public void nametextFieldFailureSenarios() {// here we call method which is define in pomSelenium class.
		pom.nameTextFieldSendKeys("neha oza");
		//pom.nameTextFieldSendKeys("123456 123456");
		//pom.nameTextFieldSendKeys("@@@@    @@");		
		//pom.nameTextFieldSendKeys("   ");
     //   pom.nameTextFieldSendKeys("ne   ha  o za");	
	//	pom.nameTextFieldSendKeys("ne   ha  o za");	
				
	}
	
	//@Test
	public void emailTextFieldFailurSenarios() {  //Here we call the variable in which we store the xpath of webelement.
		pom.emailTextField.sendKeys("j.nnehajoshi@gmail.com");
		//pom.emailTextField.sendKeys("123456789");
		//pom.emailTextField.sendKeys("######");
	}
	//@Test
	public void zipTextFieldSuccessSenario() {
		pom.ZipTextFieldsendKeys("41250");
	}
	//@Test
	public void mobTextFieldSuccessField() {
		pom.mobTextFieldSendKeys("9730548123");
	}
	//@Test
	public void SelectRediobutton() {
		pom.selectFemaleredioButton();
		
	}
	
	//@Test
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")));			
		//driver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")).click();
		//example of explicit wait that the select button is visible or not.
	}
	//@Test
	public void selectdropdown() {
		pom.selectDropdown("UK");
	}
	//@Test
	public void abtYourSelf() {
		pom.aboutYourSelfTextField("my name is neha oza");
		
	}
	@Test
	public void robotClassFileupload() throws AWTException {
		String filePath = System.getProperty("user.dir") + "\\images\\sw-test-academy.png";
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".btn.btn-success.fileinput-button")));
	        driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
	        uploadFileWithRobot(filePath );
		
	}

	

	@AfterMethod
	public void closeWebPage() {
		driver.close();

	}
	public void uploadFileWithRobot (String file) throws AWTException {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(file );		
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		//Getting clipBoard as file upload window
		Clipboard clipBoard = toolKit.getSystemClipboard();
		//Copying string file name to the file upload window
		clipBoard.setContents(stringSelection, null);
		
		Robot robot = null;
		 try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	 
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
		
		
		
		
		
		
	}


