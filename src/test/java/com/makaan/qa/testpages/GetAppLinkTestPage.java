package com.makaan.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaan.qa.pages.GetAppLinkPage;
import com.makaan.qa.testbase.BaseTest;

public class GetAppLinkTestPage extends BaseTest {

	GetAppLinkPage getlinkobj;

	public GetAppLinkTestPage() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		getlinkobj = new GetAppLinkPage();
	}

	@Test(priority=1)
	public void verifymobilenumber() {
		getlinkobj.getmobile();
	}

	@Test(priority=2)
	public void verify_play_store_link() {
		String play_store_title = getlinkobj.play_store_link();
		System.out.println(play_store_title);
		String expectedtittle = "Property in India | Indian Real Estate | Property Website";
		Assert.assertEquals(play_store_title, expectedtittle);

	}

	@Test(priority=3)
	public void verify_app_store_link() {
		getlinkobj.app_store_link();
		//String app_store_title = getlinkobj.app_store_link();
		/*System.out.println(app_store_title);
		Assert.assertEquals(app_store_title, "?makaan.com on the App Store");*/
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
