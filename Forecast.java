package com.sapient.weather.model.openweather.api.forecast.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Forecast {
	@JsonProperty("list")
	private List<ForecastAtTime> forecastAtTimes;

	public List<ForecastAtTime> getForecastAtTimes() {
		return forecastAtTimes;
	}

	public void setForecastAtTimes(List<ForecastAtTime> forecastAtTimes) {
		this.forecastAtTimes = forecastAtTimes;
	}

}
