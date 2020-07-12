package com.weather.core;

import static io.restassured.RestAssured.get;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class WeatherApiResponse {

	String api ="http://api.openweathermap.org/data/2.5/weather?q=Bengaluru&appid=7fe67bf08c80ded756e598d6f8fedaea";

	final String USER_AGENT="Chrome";
	String condition;
	String wind;
	String humidity;
	String TempInDegrees;
	String TempInFaranheit;
	@Test 
	public void testResponseCode() {

		System.out.println("Api:"+api);
		int code = get(api).getStatusCode();
		System.out.println("Code:"+code);
		Assert.assertEquals(code, 200);
	}

	@Test
	public void testbody() {
		Long time = get(api).getTime();
		System.out.println("Response time: "+time);
	}


	@Test
	public void testResponseBody() {
		/*
		 * Map<String, Object> body = get(api).getBody().jsonPath().get();
		 * System.out.println(body); for (String name : body.keySet())
		 * System.out.println("key: " + name); for (Object url : body.values())
		 * System.out.println("value: " + url);
		 */
		Map<String, Object> body = get(api).getBody().jsonPath().get();
		for (Map.Entry<String,Object> entry : body.entrySet())  
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()
					); 
	}


}
