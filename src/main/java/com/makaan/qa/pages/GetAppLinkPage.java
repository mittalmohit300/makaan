package com.makaan.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makaan.qa.testbase.BaseTest;

public class GetAppLinkPage extends BaseTest{
	
	private static Logger log = LogManager.getLogger(GetAppLinkPage.class);
	
	@FindBy(xpath = "//input[@name='get the app on phone']")
	WebElement mobile_no;

	@FindBy(xpath = "//input[@class='sendbtn']")
	WebElement get_link_in_sms;

	@FindBy(xpath = "//div[@class='link-wrap']/a[1]")
	WebElement play_store_link;

	@FindBy(xpath = "//div[@class='link-wrap']/a[2]")
	WebElement app_store_link;

		
	public GetAppLinkPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getmobile() {
		log.info("enter mobile number");
		mobile_no.sendKeys(prop.getProperty("mobilenumber"));
		get_link_in_sms.click();
	}
	
	public String play_store_link() {
		log.info("Click on play store link");
		play_store_link.click();
		return driver.getTitle();
	}
	
	public String app_store_link() {
		log.info("Click on app store link");
		app_store_link.click();
		return driver.getTitle();
	}
	
	
}
