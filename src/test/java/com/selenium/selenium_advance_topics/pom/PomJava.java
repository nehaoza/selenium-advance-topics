package com.selenium.selenium_advance_topics.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomJava {

	WebDriver driver;
	Properties propertyobj;

	public PomJava(WebDriver driver, Properties propertyobj) {
		this.driver = driver;
		this.propertyobj = propertyobj;
		
	}
	public void nameTextFieldSendKeys(String keys) {
		driver.findElement(By.xpath(propertyobj.getProperty("name-textField"))).sendKeys(keys);
	}
	public void emailTextFieldSendKeys(String keys) {
		driver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[2]/td[2]/input")).sendKeys(keys);
	}
	public void zipCodeTextSendKeys(String keys) {
		driver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(keys);
	}
	
}
