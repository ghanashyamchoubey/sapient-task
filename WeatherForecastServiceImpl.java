package com.sapient.weather.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sapient.weather.apiclient.OpenWeatherApiClient;
import com.sapient.weather.model.forecast.response.WeatherForecastResponse;
import com.sapient.weather.model.openweather.api.forecast.response.Forecast;
import com.sapient.weather.model.openweather.api.forecast.response.ForecastAtTime;
import com.sapient.weather.model.openweather.api.forecast.response.Weather;
import com.sapient.weather.util.TempUtil;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {
	private static final String RAIN = "Rain";

	@Autowired
	private OpenWeatherApiClient openWeatherApiClient;

	@Value("${rain.message}")
	private String rainMessage;
	
	@Value("${sunny.message}")
	private String sunnyMessage;

	public WeatherForecastResponse getWeatherForecast(String cityName) {
		WeatherForecastResponse weatherForecastResponse = new WeatherForecastResponse();
		Forecast forecast = openWeatherApiClient.getForecast(cityName);
		Date date = new Date();
		Calendar currentCal = Calendar.getInstance();
		currentCal.setTime(date);
		Calendar calAfterThreeDays = Calendar.getInstance();
		calAfterThreeDays.setTime(date);
		calAfterThreeDays.add(Calendar.DATE, 3);

		for (ForecastAtTime forecastAtTime : forecast.getForecastAtTimes()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(forecastAtTime.getDate());
			if (cal.compareTo(currentCal) > 0 && cal.compareTo(calAfterThreeDays) <= 0) {
				if (TempUtil.convertToCelsius(forecastAtTime.getTemperature().getAvg()) > 40) {
                       weatherForecastResponse.setMessage(sunnyMessage);
				}
				for (Weather weather : forecastAtTime.getWeather()) {
					if (weather.getName().equals(RAIN)) {
						weatherForecastResponse.setMessage(rainMessage);
					}
				}
			}
		}

		return weatherForecastResponse;
	}
}
