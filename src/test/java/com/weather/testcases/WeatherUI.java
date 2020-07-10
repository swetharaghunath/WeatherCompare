package com.weather.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weather.core.BaseTest;
import com.weather.core.WeatherElements;

public class WeatherUI extends BaseTest{
	WeatherElements weatherElements = new WeatherElements();
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
	@FindBy (className = "notnow")
	WebElement notNow;
	String condition ;
	String wind;
	String Humidity;
	String TempINdegress;
	String TempInFaranheit;
	public void gotoUrl(String url) {
		driver.get(config.getProperty(url));
		log.debug("specified url "+url+"opened");
	}

	public void gotoCity() {
		weatherDots.click();
		weatherLink.click();
		searchCity.sendKeys("Jammu");

	}
	public void checkForPopups() {
		if(notNow.isDisplayed()) {
			notNow.click();
		}
	}
	public WeatherUI() {
		PageFactory.initElements(driver,this);

	}	
	@Test
	public void gotoWeather() throws InterruptedException {
		gotoUrl("testsiteurl");
		//weather ="Bengaluru";
		//checkForPopups();
		//gotoCity();
		/*
		 * if(driver.findElement(By.className("notnow")).is()) {
		 * driver.findElement(By.className("notnow")).click(); }
		 */
		driver.findElement(By.id("h_sub_menu")).click();
		driver.findElement(By.linkText("WEATHER")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("Bengaluru");
		if(driver.findElement(By.id("Bengaluru")) != null) {
			log.debug("weather found ");
			driver.findElement(By.id("Bengaluru")).click();
			driver.findElement(By.id("Bengaluru")).click();
		};
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();;
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Bengaluru, Karnataka')]"))!=null) {
			
			 
			 


		}

	}
}
