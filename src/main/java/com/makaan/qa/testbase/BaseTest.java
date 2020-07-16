package com.makaan.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.makaan.qa.utilities.TestUtility;
import com.makaan.qa.utilities.WebEventListener;



public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	ChromeOptions options;
	public static EventFiringWebDriver e_driver;
	public static com.makaan.qa.utilities.WebEventListener eventListener;
	 
	//Map<String, Object> prefs;
	
	/*@BeforeSuite
	public void beforesuite() {
		DOMConfigurator.configure("D:\\D Drive\\Mohit\\WorkSpace_Mohit\\MakaanQaAutomation\\target\\log4j.xml");
		CaptureLogs.log.info("This is before suite");
	}
	
	@AfterSuite
	public void aftersuite() {
		CaptureLogs.log.info("This is after suite");
	}
	*/
	public BaseTest() {
		prop=new Properties();
		
		try {
			FileInputStream file= new FileInputStream("D:\\D Drive\\Mohit\\WorkSpace_Mohit\\MakaanQaAutomation\\"
					+ "src\\main\\java\\com\\makaan\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void initialization() {
		
		//DOMConfigurator.configure("D:\\D Drive\\Mohit\\WorkSpace_Mohit\\MakaanQaAutomation\\target\\log4j.xml");
		String browsername=prop.getProperty("browser");
		options=new ChromeOptions();
		//options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
	
		if (browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","D:/D Drive/Mohit/WorkSpace_Mohit"
					+ "/MakaanQaAutomation/Chrome/chromedriver.exe");		
			 driver = new ChromeDriver(options);
			
		} else if (browsername.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver",
					"D:\\D Drive\\Mohit\\WorkSpace_Mohit\\RedBusIndia\\"
					+ "src\\main\\java\\com\\redbusindia\\qa\\utilities\\Chrome\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;	
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.pageloadwait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.implicitloadwait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		 /*options=new ChromeOptions();
			prefs=new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			options.setExperimentalOption("prefs",prefs);*/
		
		
		
	}
	
	
}
