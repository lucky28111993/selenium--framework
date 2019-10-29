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

public class RetailResetPasswordRTTC_003 {
	
	
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
  public void validResetPasswordTest() {
	  retailPOM.clickAccountButton();
	  retailPOM.sendLoginEmail("revasharma@gmail.com");
	  retailPOM.sendLoginPassword("reva124");
	  retailPOM.clickLoginButton();
	  String actualLoginFailureText = retailPOM.verifyLoginFailureText();
	  Assert.assertEquals(actualLoginFailureText, "Warning: No match for E-Mail Address and/or Password.");
	  screenShot.captureScreenShot("LoginFailure");
	  retailPOM.clickForgotPasswordButton();
	  retailPOM.sendResetPasswordEmail("revasharma@gmail.com");
	  retailPOM.clickResetPasswordContinue();
	  String actualResetPasswordText = retailPOM.verifyResetPasswordText();
	  Assert.assertEquals(actualResetPasswordText, "An email with a confirmation link has been sent your email address.");
	  screenShot.captureScreenShot("ResetPassword");
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
