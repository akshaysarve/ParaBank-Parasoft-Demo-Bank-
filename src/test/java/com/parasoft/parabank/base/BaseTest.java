package com.parasoft.parabank.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;

	@BeforeTest
	public void setup() {
		// System properties for chrome browser
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		// Create an instance for chrome browser
		driver =new ChromeDriver();
		
		// String to set url
		String url="https://parabank.parasoft.com/";
		
		// Launch Application
		driver.get(url);
		
		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!= null) {
			driver.close();
		}
	}
}
