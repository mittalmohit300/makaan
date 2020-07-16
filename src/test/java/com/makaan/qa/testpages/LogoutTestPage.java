package com.makaan.qa.testpages;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaan.qa.pages.LoginPage;
import com.makaan.qa.pages.LogoutPage;
import com.makaan.qa.testbase.BaseTest;

public class LogoutTestPage extends BaseTest {
	
	LogoutPage logoutpage_obj;
	LoginPage  login_page_obj;
	public LogoutTestPage() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	logoutpage_obj= new LogoutPage();
	login_page_obj = new LoginPage();
	
	}
	
	@Test(priority=1)
	public void verifylogout() {
		login_page_obj.clickonlogin();
		login_page_obj.clickon_login_with_email();
		login_page_obj.clickon_login_button();
		logoutpage_obj.clickon_hamburger_menu();
		logoutpage_obj.clickon_logout();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
