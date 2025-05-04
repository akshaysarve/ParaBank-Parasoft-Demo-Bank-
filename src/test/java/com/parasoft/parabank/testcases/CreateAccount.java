package com.parasoft.parabank.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.parasoft.parabank.base.BaseTest;

public class CreateAccount extends BaseTest {


	@Test(priority = 1)
	public void testCreateAccountWithValidData() {
		// Click Register
		WebElement regLink=driver.findElement(By.xpath("//a[@href='register.htm']"));
		regLink.click();
		System.out.println("User is navigated to Register page.");

		// First Name
		WebElement fName=driver.findElement(By.name("customer.firstName"));
		fName.sendKeys("John");

		// Last Name
		WebElement lName=driver.findElement(By.name("customer.lastName"));
		lName.sendKeys("Doe");

		// Address
		WebElement address=driver.findElement(By.name("customer.address.street"));
		address.sendKeys("Test Address");

		// City
		WebElement city=driver.findElement(By.name("customer.address.city"));
		city.sendKeys("London");

		// State
		WebElement state=driver.findElement(By.name("customer.address.state"));
		state.sendKeys("United Kingdom");

		// Zip Code
		WebElement zipCode=driver.findElement(By.name("customer.address.zipCode"));
		zipCode.sendKeys("120654");

		// Phone
		WebElement phone=driver.findElement(By.name("customer.phoneNumber"));
		phone.sendKeys("8237250691");

		// SSN
		WebElement ssn=driver.findElement(By.name("customer.ssn"));
		ssn.sendKeys("00112");

		// User Name
		WebElement username=driver.findElement(By.name("customer.username"));
		username.sendKeys("johndoe348");

		// Password
		WebElement password=driver.findElement(By.name("customer.password"));
		password.sendKeys("Simple@123");

		// Confirm Password
		WebElement confirmPassword=driver.findElement(By.name("repeatedPassword"));
		confirmPassword.sendKeys("Simple@123");

		// Register button
		WebElement regBtn=driver.findElement(By.cssSelector("input[value='Register']"));
		regBtn.click();
	}

	@Test(priority = 2, dependsOnMethods = "testCreateAccountWithValidData")
	public void validateConfirmationMsg() {
		WebElement welcmMsg=driver.findElement(By.cssSelector("h1[class='title']"));
		System.out.println(welcmMsg.getText());

		WebElement sucessfulMsg=driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
		System.out.println(sucessfulMsg.getText());
	}

	@Test(priority = 3, dependsOnMethods = "testCreateAccountWithValidData")
	public void testLeaveFieldsBlanksSubmit() {
		driver.navigate().back();
		// First Name
		WebElement fName=driver.findElement(By.name("customer.firstName"));
		fName.clear();

		// Last Name
		WebElement lName=driver.findElement(By.name("customer.lastName"));
		lName.clear();

		// Address
		WebElement address=driver.findElement(By.name("customer.address.street"));
		address.clear();

		// City
		WebElement city=driver.findElement(By.name("customer.address.city"));
		city.clear();

		// State
		WebElement state=driver.findElement(By.name("customer.address.state"));
		state.clear();

		// Zip Code
		WebElement zipCode=driver.findElement(By.name("customer.address.zipCode"));
		zipCode.clear();

		// Phone
		WebElement phone=driver.findElement(By.name("customer.phoneNumber"));
		phone.clear();

		// SSN
		WebElement ssn=driver.findElement(By.name("customer.ssn"));
		ssn.clear();

		// User Name
		WebElement username=driver.findElement(By.name("customer.username"));
		username.clear();

		// Password
		WebElement password=driver.findElement(By.name("customer.password"));
		password.clear();

		// Confirm Password
		WebElement confirmPassword=driver.findElement(By.name("repeatedPassword"));
		confirmPassword.clear();
		
		// Register button
		WebElement regBtn=driver.findElement(By.cssSelector("input[value='Register']"));
		regBtn.click();

	}
	
	@Test(priority = 4, dependsOnMethods = "testLeaveFieldsBlanksSubmit")
	public void validateErrorMsg() {
		WebElement fNameError=driver.findElement(By.id("customer.firstName.errors"));
		WebElement lNameError=driver.findElement(By.id("customer.lastName.errors"));
		WebElement addrError=driver.findElement(By.id("customer.address.street.errors"));
		WebElement cityError=driver.findElement(By.id("customer.address.city.errors"));
		WebElement stateError=driver.findElement(By.id("customer.address.state"));
		
		Assert.assertEquals(fNameError.getText(), "First name is required.", "Incorrect error message!");
		Assert.assertEquals(lNameError.getText(), "Last name is required.", "Incorrect error message!");
		Assert.assertEquals(addrError.getText(), "Address is required.", "Incorrect error message!");
		Assert.assertEquals(cityError.getText(), "City is required.", "Incorrect error message!");
		Assert.assertEquals(stateError.getText(), "State is required.", "Incorrect error message!");

		
	}
	

}