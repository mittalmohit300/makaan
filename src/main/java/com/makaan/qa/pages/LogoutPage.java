package com.makaan.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makaan.qa.testbase.BaseTest;

public class LogoutPage extends BaseTest {

	WebDriverWait wait;
	
	@FindBy(xpath = "//ul[@class='hamburger-icon']")
	WebElement hamburger_menu;

	@FindBy(xpath = "//li[@id='loginchecker']")
	WebElement logout;

	public LogoutPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickon_hamburger_menu() {
		
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(hamburger_menu));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hamburger_menu);
		
	}

	public void clickon_logout() {
		
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}

}
