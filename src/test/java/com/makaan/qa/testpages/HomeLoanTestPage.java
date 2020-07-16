package com.makaan.qa.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.makaan.qa.pages.HomeLoanPage;
import com.makaan.qa.pages.LoginPage;
import com.makaan.qa.testbase.BaseTest;
import com.makaan.qa.utilities.TestData;


public class HomeLoanTestPage extends BaseTest {

	LoginPage login_page_obj;
	HomeLoanPage home_loan_page_obj;

	public HomeLoanTestPage() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		login_page_obj = new LoginPage();
		home_loan_page_obj = new HomeLoanPage();
	}

	/*@Test(priority = 1)
	public void clickon_home_loan() {
		login_page_obj.clickonlogin();
		login_page_obj.clickon_login_with_email();
		login_page_obj.clickon_login_button();
		
		home_loan_page_obj.get_home_loan();
		
		String actualtitle = home_loan_page_obj.get_title();
		System.out.println(actualtitle);
		String expectedtitle = "Makaan Home Loan";
		Assert.assertEquals(actualtitle, expectedtitle);
		      
   	}
*/
 
	@DataProvider
	public Object[][] testdata() {
		Object data[][] = TestData.getTestData("EMI");
		return data;
	}

	@Test(priority = 2, dataProvider = "testdata")
	public void get_monthly_emi_calc(String LOAN_AMOUNT, String TENURE, String RATE_OF_INTEREST) {
		login_page_obj.clickonlogin();
		login_page_obj.clickon_login_with_email();
		login_page_obj.clickon_login_button();
		
		home_loan_page_obj.get_home_loan();
		home_loan_page_obj.home_loan_calc();
		home_loan_page_obj.loan_amount(LOAN_AMOUNT, TENURE, RATE_OF_INTEREST);
		String emi_amount=home_loan_page_obj.monthly_emi_amount();
		System.out.println(emi_amount);
			}
	
    @AfterMethod
	public void teardown() {
		driver.quit();
		}
	
}
