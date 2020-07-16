package com.makaan.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaan.qa.pages.LoginPage;
import com.makaan.qa.testbase.BaseTest;

public class LoginTestPage extends BaseTest {
	
	LoginPage login_page_obj;
	
	public LoginTestPage() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login_page_obj = new LoginPage();
		
	}

	@Test(priority=1)
	public void verifytitle() {
	String expectedtitle="Property in India | Indian Real Estate | Property Website";
	String actualtitle=login_page_obj.gettitle();
	Assert.assertEquals(actualtitle, expectedtitle);
			
	}
	

	@Test(priority=2)
	public void verifylogin() {
		login_page_obj.clickonlogin();
		login_page_obj.clickon_login_with_email();
		login_page_obj.clickon_login_button();
	
				
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
