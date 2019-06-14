package com.sapient.weather.model.openweather.api.forecast.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastAtTime {
	@JsonProperty("dt_txt")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;

	@JsonProperty("main")
	private Temperature temperature;

	@JsonProperty("weather")
	private List<Weather> weather;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

}
