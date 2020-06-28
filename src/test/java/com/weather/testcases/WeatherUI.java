package com.weather.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.weather.core.WeatherElements;

public class WeatherUI extends WeatherElements{
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void gotoWeather() {
		driver.get(config.getProperty("testsiteurl"));
	}
}
