package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RetailRegistrationRTTC_001 {
	
	
	private WebDriver driver;
	private String baseUrl;
	private RetailPOM retailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	 @BeforeClass
	 public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

	 @BeforeMethod
	  public void setUp() throws Exception {
		 driver = DriverFactory.getDriver(DriverNames.CHROME);
		 retailPOM = new RetailPOM(driver); 
		 baseUrl = properties.getProperty("baseURL");
		 screenShot = new ScreenShot(driver); 
		 driver.get(baseUrl); 
	 }

  @Test
  public void validRegisterationTest() {
	  retailPOM.clickAccountButton();
	  retailPOM.clickRegisterButton();
	  retailPOM.sendFirstName("reva");
	  retailPOM.sendLastName("sharma");
	  retailPOM.sendEmail("revasharma222@gmail.com");
	  retailPOM.sendPhoneNumber("9345677833");
	  retailPOM.sendAddress1("Jayanagar");
	  retailPOM.sendAddress2("bangalore");
	  retailPOM.sendCity("bangalore");
	  retailPOM.sendPostalCode("560018");
	 retailPOM.selectCountry("India");
	 retailPOM.selectState("Karnataka");
	  retailPOM.sendPassword("reva123");
	  retailPOM.sendConfirmPassword("reva123");
	  retailPOM.selectNotASubscriber();
	  retailPOM.selectPrivacyPolicy();
	  retailPOM.continueRegistration();
	  String actualtext = retailPOM.verifyRegistrationText();
	  Assert.assertEquals(actualtext, "Congratulations! Your new account has been successfully created!");
	  screenShot.captureScreenShot("Registration");
	  
  }
 
  @AfterMethod
  public void afterMethod() throws Exception {

	Thread.sleep(3000);
	 driver.quit();
  }

 
  @AfterClass
  public void afterClass() {
  }

}
