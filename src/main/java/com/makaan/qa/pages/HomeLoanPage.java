package com.makaan.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makaan.qa.testbase.BaseTest;

public class HomeLoanPage extends BaseTest{
	

	WebDriverWait wait= new WebDriverWait(driver, 20);
	private static Logger log= LogManager.getLogger(HomeLoanPage.class);
	
	@FindBy(xpath="(//li[@class='home-loan ']//a/span)[2]")
	WebElement home_loan_buton;
	
	@FindBy(xpath="//span[@data-type='calculate_homeloan']/i/img")
	WebElement home_loan_calc;
	
	@FindBy(id="emi_income")
	WebElement loan_amount;

	@FindBy(id="emi_tenure")
	WebElement emi_tenure;

	@FindBy(id="emi_interest")
	WebElement emi_interest;

	@FindBy(xpath="//span[@class='js-emi val']")
	WebElement emi_value;

	@FindBy(xpath="//input[@id='emi_interest']/../span]")
	WebElement percent;

	public HomeLoanPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void get_home_loan() {
		log.info("Makaan Home Loan");
		
		wait.until(ExpectedConditions.elementToBeClickable(home_loan_buton));		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", home_loan_buton);
		
	}
	
	/*public String get_title() {
		return driver.getTitle();
				
	}
	*/
	
	public void home_loan_calc() {
		
		wait.until(ExpectedConditions.elementToBeClickable(home_loan_calc));		
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", home_loan_calc);

	}
	
	public void loan_amount(String LOAN_AMOUNT, String TENURE, String RATE_OF_INTEREST) {
		
		
		loan_amount.sendKeys(LOAN_AMOUNT);
		System.out.println(LOAN_AMOUNT);
		
		
		WebDriverWait wait1= new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("emi_tenure")));
		//emi_tenure.clear();
		emi_tenure.sendKeys(TENURE);
		System.out.println(TENURE);
		
		
		WebDriverWait wait2= new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("emi_interest")));
		
		//emi_interest.clear();
		emi_interest.sendKeys(RATE_OF_INTEREST);
		System.out.println(RATE_OF_INTEREST);
		percent.click();
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", emi_interest);*/
		
	}
	
	public String monthly_emi_amount()  {
		
		String str= emi_value.getText();
		System.out.println(str);
		
		if (str.equals("43.39"))
		{

			percent.click();
		}
		
		 System.out.println(emi_value.getText());
			return emi_value.getText();
		
	}
	
}

