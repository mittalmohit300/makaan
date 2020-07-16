package com.makaan.qa.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makaan.qa.testbase.BaseTest;

public class ForgetPage extends BaseTest  {
	
	private static Logger log = LogManager.getLogger(ForgetPage.class);
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	WebElement forgotpassword;
	
	@FindBy(xpath="//input[@class='js-email']")
	WebElement email_id;
	
	@FindBy(xpath="//div[text()='Send OTP']")
	WebElement send_otp;
	
	@FindBy(xpath="//span[@id='update-password-email']/../span[4]")
	WebElement otp_verfication;
	
	public ForgetPage() {
		
		PageFactory.initElements(driver, this);

	}
	
	
public void clickonforgot() {
	log.info("This function is to click on forgot password button");
	clickon(driver, forgotpassword, 10);
	
}

public String getemailid() {
	
	log.info("This function is to verify forgot password funcionality");
	email_id.sendKeys(prop.getProperty("email"));
	send_otp.click();
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.textToBePresentInElement(otp_verfication, "An OTP has been sent to your registered email and mobile"));
	String otp_message=otp_verfication.getText();
	return otp_message;
}


public static void clickon(WebDriver driver, WebElement element, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
}

	
	
	
}
