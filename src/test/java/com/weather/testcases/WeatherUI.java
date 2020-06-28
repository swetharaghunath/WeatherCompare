package com.weather.testcases;

import org.testng.annotations.Test;

import com.weather.core.WeatherElements;

public class WeatherUI extends WeatherElements{
	//public WebDriver driver = new ChromeDriver();
	
	public WeatherUI() {
		
	}	
	@Test
	public void gotoWeather() {
		driver.get(config.getProperty("testsiteurl"));

	}
}
