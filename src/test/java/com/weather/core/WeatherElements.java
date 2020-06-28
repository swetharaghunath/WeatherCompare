package com.weather.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;


public class WeatherElements {

	public static WebDriver driver;
	public static FileInputStream fis  ;
	public static Properties config=new Properties();
	@FindBy(id="h_sub_menu")
    WebElement weatherDots;
	@FindBy (linkText = "WEATHER")
	WebElement weatherLink;
	@FindBy (id="searchBox")
	WebElement searchCity;
	@FindBy (className = "cityText")
	WebElement cityToSelect;
	@FindBy (className = "leaflet-popup-content-wrapper")
	WebElement cityPopup;
	@FindBy (xpath = "/html/body/div[6]/div[1]/div[6]/div/div[1]/div/div/div/span[2]")
	WebElement cityPopupText;
	
	
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
	}
}