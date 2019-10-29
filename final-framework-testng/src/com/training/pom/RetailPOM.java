package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RetailPOM {
	private WebDriver driver;

	
	public RetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement account; 

	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement register; 
	
		
	@FindBy(id="input-firstname")
	private WebElement firstname; 
	

	@FindBy(id="input-lastname")
	private WebElement lastname; 
	
		
	@FindBy(id="input-email")
	private WebElement email; 
	
	
	@FindBy(id="input-telephone")
	private WebElement phonenumber; 
	
	
	@FindBy(id="input-address-1")
	private WebElement addressline1; 	
	
	
	@FindBy(id="input-address-2")
	private WebElement addressline2;
	
	@FindBy(id="input-city")
	private WebElement city;
		
	@FindBy(id="input-postcode")
	private WebElement postalcode;
	
    @FindBy(id="input-country")
    private WebElement country;
	
    @FindBy(id="input-zone")
    private WebElement state;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//label[contains(text(),'No')]")
	private WebElement DoNotSubscribe;
	
	@FindBy(name="agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement selectContinueRegistration;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]")
	private WebElement registrationText;

	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement login; 
	
	
	@FindBy(id="input-email")
	private WebElement loginEmail; 
	
	
	@FindBy(id="input-password")
	private WebElement loginPassword; 
	
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement loginFailureText;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/align[1]/h2[1]")
	private WebElement myAccountTitle;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement loginFailureWarning; 
	
	@FindBy(xpath="//a[contains(text(),'Forgotten Password')]")
	private WebElement forgotPassword; 
	
	@FindBy(id="input-email")
	private WebElement resetPasswordEmail; 

	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement resetPasswordContinue; 
	
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement resetPasswordText; 
	
	
	
	
	//methods	
public void clickAccountButton() {
	this.account.click(); 
	}
	
public void clickRegisterButton() {
	this.register.click(); 
	}		

public void sendFirstName(String firstname) {
	this.firstname.sendKeys(firstname);
	}

public void sendLastName(String lastname) {
	this.lastname.sendKeys(lastname);
	}

public void sendEmail(String email) {
	this.email.sendKeys(email);
	}

public void sendPhoneNumber(String phonenumber) {
	this.phonenumber.sendKeys(phonenumber);
	}

public void sendAddress1(String addressline1) {
	this.addressline1.sendKeys(addressline1);
	}

public void sendAddress2(String addressline2) {
	this.addressline2.sendKeys(addressline2);
	}

public void sendCity(String city) {
	this.city.sendKeys(city);
	}

public void sendPostalCode(String postalcode) {
	this.postalcode.sendKeys(postalcode);
	}

public void selectCountry(String countryVal) {
	
	new Select(country).selectByVisibleText(countryVal);
}

public void selectState(String stateVal) {
	new Select(state).selectByVisibleText(stateVal);
	}

public void sendPassword(String password) {
	this.password.sendKeys(password);
	
}

public void sendConfirmPassword(String confirmPassword) {
	this.confirmPassword.sendKeys(confirmPassword);
	
}

public void selectNotASubscriber() {
	this.DoNotSubscribe.click();
		
}

public void selectPrivacyPolicy() {
	this.privacyPolicy.click();
}

public void continueRegistration() {
	this.selectContinueRegistration.click();
	
}

public String verifyLoginFailureText() {
	return this.loginFailureText.getText();
	}


public void sendLoginEmail(String loginEmail) {
	this.loginEmail.sendKeys(loginEmail);
	}

public void sendLoginPassword(String loginPassword) {
	this.loginPassword.sendKeys(loginPassword);
	}

public void clickLoginButton() {
	this.login.click(); 
	}

public String verifyMyAccountTitle() {
	return this.myAccountTitle.getText();
	
}


public void getLoginFailureText(String loginFailureWarning) {
	this.loginFailureWarning.getText();
}

public void clickForgotPasswordButton() {
	this.forgotPassword.click(); 
	}

public void sendResetPasswordEmail(String resetPasswordEmail) {
	this.resetPasswordEmail.sendKeys(resetPasswordEmail);
	}

public void clickResetPasswordContinue() {
	this.resetPasswordContinue.click();

}

public String verifyRegistrationText() {
	return this.registrationText.getText();
	}

public String verifyResetPasswordText() {
	
	return this.resetPasswordText.getText();
}


}