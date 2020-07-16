package com.makaan.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaan.qa.pages.ForgetPage;
import com.makaan.qa.pages.LoginPage;
import com.makaan.qa.testbase.BaseTest;



public class ForgotTestPage extends BaseTest{
	 ForgetPage forgot_password_obj;
	 LoginPage login_page_obj;
	 
	 
	public ForgotTestPage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		forgot_password_obj=new ForgetPage();
		login_page_obj = new LoginPage();
	}

	
	@Test(priority=1)
	public void verifyforgotpasswrod() {
		login_page_obj.clickonlogin();
		login_page_obj.clickon_login_with_email();
		forgot_password_obj.clickonforgot();
		
	}
	
	@Test(priority=2)
	public void verify_send_otp() {
		verifyforgotpasswrod();
		String actual_otp_message=forgot_password_obj.getemailid();
		System.out.println(actual_otp_message);
		Assert.assertEquals(actual_otp_message, "An OTP has been sent to your registered email and mobile");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
