package com.techelevator.npgeek.model.weather;

public class WeatherForecastRecord {
	
	private String parkCode;
	private String forecastDay;
	private int forecastLow;
	private int forecastHigh;
	private String forecastDescription;
	
	public WeatherForecastRecord(String record) {
		String[] recordParts = record.split("\\t");
		this.parkCode = recordParts[0];
		this.forecastDay = recordParts[1];
		this.forecastLow = Integer.parseInt(recordParts[2]);
		this.forecastHigh = Integer.parseInt(recordParts[3]);
		this.forecastDescription = recordParts[4];
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getForecastDay() {
		return forecastDay;
	}
	public void setForecastDay(String forecastDay) {
		this.forecastDay = forecastDay;
	}
	public int getForecastLow() {
		return forecastLow;
	}
	public void setForecastLow(int forecastLow) {
		this.forecastLow = forecastLow;
	}
	public int getForecastHigh() {
		return forecastHigh;
	}
	public void setForecastHigh(int forecastHigh) {
		this.forecastHigh = forecastHigh;
	}
	public String getForecastDescription() {
		return forecastDescription;
	}
	public void setForecastDescription(String forecastDescription) {
		this.forecastDescription = forecastDescription;
	}

}
