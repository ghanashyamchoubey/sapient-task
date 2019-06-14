package com.sapient.weather.model.forecast.response;

import java.util.Date;

public class TempResponse {

	private Date date;
	private double high;
	private double low;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}
	
	

}
