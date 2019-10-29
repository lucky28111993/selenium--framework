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

public class RetailLoginRTTC_002 {
	
	
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
  public void validLoginTest() {
	  retailPOM.clickAccountButton();
	  retailPOM.sendLoginEmail("revasharma5@gmail.com");
	  retailPOM.sendLoginPassword("reva123");
	  retailPOM.clickLoginButton();
	  String pageTitle = retailPOM.verifyMyAccountTitle();
	  Assert.assertEquals(pageTitle, "My Account");
	  screenShot.captureScreenShot("Login");
 }
 
  @AfterMethod
  public void afterMethod() throws Exception {
 
	  Thread.sleep(3000);
	  driver.quit();
  }

}
