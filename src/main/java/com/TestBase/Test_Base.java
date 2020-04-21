package com.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Util.ExtentManager;
import com.Util.Util;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_Base {
	
	
	public static Properties Repository = new Properties();
	public FileInputStream ip;
	public static WebDriver driver;
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public ExtentReports rep = ExtentManager.getinstance();
	public static ExtentTest test;
	Util util = new Util();
	
	public void init() throws IOException {
		CONFIG = new Properties();
		OR = new Properties();

		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));

	}
	
		
	public void loadPropertiesFile() throws IOException {
		
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Config\\config.properties");
			CONFIG.load(ip);
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Config\\OR.properties");
			OR.load(ip);
		} catch (Exception  e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @return browser driver
	 */
	public void selectBrowser(String browser) {
		if (CONFIG.getProperty("browserType").equals("firefox") || CONFIG.getProperty("browserType").equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		} else if (CONFIG.getProperty("browserType").equals("chrome") || CONFIG.getProperty("browserType").equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Libraries\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
		} else if (CONFIG.getProperty("browserType").equals("ie") || CONFIG.getProperty("browserType").equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		
	}
	
	
	public void temp(){
		
		System.out.println(OR.getProperty("EmailtxtByCss"));
		System.out.println(CONFIG.getProperty("browserType"));
		
	}
	
	public void navigatetoTestUrl(){
		
		driver.navigate().to(CONFIG.getProperty("testSiteName"));
		test.log(LogStatus.INFO, "navigating to : " + CONFIG.getProperty("testSiteName"));
		util.wait_elementClickable("//a[@title='Contact Us']", driver, 20);
		
	}
	

}
