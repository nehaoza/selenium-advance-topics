package com.selenium.selenium_advance_topics.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PomSelenium {
	// you can use pom in 2 ways 
	// find webelement  by @findBy annotetion and store in veriable and use that veriable in actual testing class OR
	// find webelement  by @findBy annotetion and store in veriable and define method in this class and call in testing class.
	

	WebDriver driver;
	Properties propertyobj;
	
	@FindBy(xpath="//*[@id=\"name-text-field-id\"]")
	WebElement nameTextField;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[2]/td[2]/input")
	 WebElement emailTextField;
	
	@FindBy(xpath ="//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[3]/td[2]/input")
	 WebElement zipTextField;	
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[4]/td[2]/input")
	WebElement mobTextField;
	
	@FindBy(xpath ="//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[8]/td[2]/textarea")
	WebElement abtYourselfTextField;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")
	 WebElement submit;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[5]/td[2]/label[1]")
	 WebElement redioMale;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[5]/td[2]/label[2]")
	WebElement redioFemale;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[5]/td[2]/label[3]")
	 WebElement redioOthers;
	
	@FindBy(xpath = "//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[7]/td[2]/label[1]")
	WebElement hobbies1;
	
	@FindBy(xpath ="//*[@id=\"hobby2\"]")
	WebElement hobbies2;
	
	@FindBy(xpath = "//*[@id=\"hobby3\"]")
	WebElement hobbies3;
	
	@FindBy(xpath ="//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[6]/td[2]/select")
	WebElement Countrydropdown;
	

	
	

	public PomSelenium(WebDriver driver, Properties propertyobj) {
		this.driver = driver;
		this.propertyobj = propertyobj;
		PageFactory.initElements(driver, this);

	}
	public void nameTextFieldSendKeys(String keys) {
		nameTextField.sendKeys(keys);
	}
	public void ZipTextFieldsendKeys(String keys) {
		zipTextField.sendKeys(keys);
	}
	public void mobTextFieldSendKeys(String keys) {
		mobTextField.sendKeys(keys);
	}
	public void aboutYourSelfTextField(String keys ) {
		abtYourselfTextField.sendKeys(keys);
	}
	public void clickSubmitButton() {
		submit.click();
	}
	public void SelectMaleRedioButton() {
		redioMale.isDisplayed();
	}
	public void selectFemaleredioButton() {
		redioFemale.click();
	}
	public void selectOthersRedioButton() {
		redioOthers.isEnabled();
	}
	public void selectDropdown(String text) {
		Select dropCountry = new Select(Countrydropdown);
		dropCountry.deselectByVisibleText(text);
		//dropCountry.deselectByVisibleText(text);
		//dropCountry.deselectByVisibleText(text);
		
	}
	public void selectHobbies() {
		hobbies1.click();
	}
	public void aboutYourSelf() {
		
	}
}
