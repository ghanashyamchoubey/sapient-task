package com.sapient.weather.apiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather.model.openweather.api.forecast.response.Forecast;

@Repository
public class OpenWeatherApiClientImpl implements OpenWeatherApiClient{

	@Value("${openweather.forecast.api}")
	private String openWeatherForecastApiURL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Forecast getForecast(String cityName) {
		ResponseEntity<Forecast> forecast = restTemplate.exchange(openWeatherForecastApiURL, HttpMethod.GET, null, Forecast.class, cityName);
	    return forecast.getBody();
	}
	
}
