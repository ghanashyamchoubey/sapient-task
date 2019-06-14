package com.sapient.weather.model.forecast.response;

import java.util.List;

public class WeatherForecastResponse {

	private List<TempResponse> temps;
	private String message;

	public List<TempResponse> getTemps() {
		return temps;
	}

	public void setTemps(List<TempResponse> temps) {
		this.temps = temps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
