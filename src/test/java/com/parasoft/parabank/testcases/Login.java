package com.parasoft.parabank.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.parasoft.parabank.base.BaseTest;

public class Login extends BaseTest{

	@Test(priority = 1)
	public void validateLoginWithValidData() {
		// Username
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("johndoe348");

		// Password
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("Simple@123");

		// Login
		WebElement loginBtn=driver.findElement(By.cssSelector("input[value='Log In']"));
		loginBtn.click();

		// Logout
		WebElement logout=driver.findElement(By.cssSelector("a[href='logout.htm']"));
		logout.click();
	}

	@Test(priority = 2, dependsOnMethods = "validateLoginWithValidData")
	public void validateLoginWithInvalidData() {
		// Username
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("john");

		// Password
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("Simple");
		
		// Login
		WebElement loginBtn=driver.findElement(By.cssSelector("input[value='Log In']"));
		loginBtn.click();

		WebElement errorMsg=driver.findElement(By.cssSelector(".error"));
		System.out.println(errorMsg.getText());
	}

	@Test(priority = 3, dependsOnMethods = "validateLoginWithValidData")
	public void validateLoginWithBlankFields() {
		// Login
		WebElement loginBtn=driver.findElement(By.cssSelector("input[value='Log In']"));
		loginBtn.click();

		WebElement errorMsg=driver.findElement(By.cssSelector(".error"));
		System.out.println(errorMsg.getText());
	}

}
