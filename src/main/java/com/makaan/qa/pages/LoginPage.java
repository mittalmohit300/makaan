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

public class LoginPage extends BaseTest {
	
	private static Logger log= LogManager.getLogger(LoginPage.class);

	@FindBy(xpath = "//div[text()='Log In']")
	WebElement login_option;

	@FindBy(xpath = "//div[text()='Login with email']")
	WebElement login_with_email;

	@FindBy(id = "username")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement login_button;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String gettitle() {
		
		String title = driver.getTitle();
       log.info("This is Login Page Title");
		return title;
	}

	public void clickonlogin() {

		log.info("Click on login button");
		
		clickon(driver, login_option, 10);
		
		
	}

	public void clickon_login_with_email() {

		log.info("Click on email button");
		clickon(driver, login_with_email, 10);
		

	}

	public HomeLoanPage clickon_login_button() {

		log.info("Enter test data in email and password fields");
		sendkeys(driver, email, 5, prop.getProperty("email"));
		sendkeys(driver, password, 5, prop.getProperty("password"));
		clickon(driver, login_button, 2);
		return new HomeLoanPage();
		
	}

	public static void clickon(WebDriver driver, WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void sendkeys(WebDriver driver, WebElement element, int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);

	}

}
