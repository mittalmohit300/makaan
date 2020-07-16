package com.makaan.qa.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makaan.qa.testbase.BaseTest;

public class HomePage extends BaseTest {

	private static Logger log = LogManager.getLogger(HomePage.class);

	@FindBy(xpath = "//img[@itemprop='image']")
	WebElement logo;

	@FindBy(xpath = "//span[@class='js-repeat-user-title']/strong")
	WebElement welcome_back;

	@FindBy(xpath = "//span[text()='Buy']/../../li/span")
	List<WebElement> list;

	@FindBy(xpath = "(//input[@class='js-input thinput'])[2]")
	WebElement buy_option;

	@FindBy(xpath = "//span[text()='Rent']")
	WebElement rent_option;

	@FindBy(xpath = "(//input[@class='js-input thinput'])[2]")
	WebElement rent_text;

	@FindBy(xpath = "//span[text()='Agents']")
	WebElement agents_option;

	@FindBy(xpath = "(//input[@class='js-input thinput'])[2]")
	WebElement agents_text;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public Boolean getlogo() {
		log.info("This function is for logo verification");
		Boolean makaanlogo = logo.isDisplayed();
		return makaanlogo;
	}

	public void clickonlist() {

		log.info("This function is to verify buy rent and agents options");
		int count = list.size();
		for (int i = 0; i < count; i++) {
			list.get(i).click();
		}

	}

	public String getext() {

		log.info("This function is to verify buy option");
		return buy_option.getAttribute("placeholder");
	}

	public String rentgetext() {
		log.info("This function is to verify rent option");
		rent_option.click();
		return rent_text.getAttribute("placeholder");
	}

	public String agentsgetext() {
		log.info("This function is to verify agents option");
		agents_option.click();
		return agents_text.getAttribute("placeholder");
	}

}
