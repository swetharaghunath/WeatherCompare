package com.weather.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis  ;
	public static Properties config=new Properties();
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() {
		if(driver == null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver");
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.debug("Chrome launched");
		}
		else if(config.getProperty("browser").equals("IE")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer");
			driver = new ChromeDriver();
		}
		/*
		 * driver.get(config.getProperty("testsiteurl"));
		 * log.debug("navigated to site"); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty
		 * ("implicit.wait")), TimeUnit.SECONDS);
		 */	}
	
	@AfterSuite
	public void tearDown() {
	//	driver.close();
		//.quit();
	}
}

