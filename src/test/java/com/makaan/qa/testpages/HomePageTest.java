package com.makaan.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaan.qa.pages.HomePage;

import com.makaan.qa.testbase.BaseTest;

public class HomePageTest extends BaseTest {

	HomePage homepage_obj;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage_obj = new HomePage();
	}

	@Test(priority = 1)
	public void verifylogo() {

		homepage_obj.getlogo();
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void verifylist() {
		homepage_obj.clickonlist();
	}

	@Test(priority = 3)
	public void verify_buy_gettext() {
		String actualtext = homepage_obj.getext();
		System.out.println(actualtext);
		String expectedtext = "pick location, builder or project";
		Assert.assertEquals(actualtext, expectedtext);
		

	}

	@Test(priority = 4)
	public void verify_rent_gettext() {
		String actualtext1 = homepage_obj.rentgetext();
		System.out.println(actualtext1);
		String expectedtext1 = "pick location or project";
		Assert.assertEquals(actualtext1, expectedtext1);
		
	}
 
	@Test(priority = 5)
	public void verify_agents_gettext() {
		String actualtext2 = homepage_obj.agentsgetext();
		System.out.println(actualtext2);
		String expectedtext2 = "search by location, project or landmark";
		Assert.assertEquals(actualtext2, expectedtext2);
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
