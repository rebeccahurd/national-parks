package com.techelevator.npgeek.model.weather;

import java.time.LocalDate;

public class WeatherForecast {

	private String parkCode;
	private String forecastDay;
	private int forecastLowInFahrenheit;
	private int forecastHighInFahrenheit;
	private int forecastLowInCelsius;
	private int forecastHighInCelsius;
	private String forecastDescription;
	private String weatherTips;
	private String dayOfWeek;
	private static final String[] DAYS_OF_WEEK = new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	
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
	public int getForecastLowInFahrenheit() {
		return forecastLowInFahrenheit;
	}
	public void setForecastLowInFahrenheit(int forecastLowInFahrenheit) {
		this.forecastLowInFahrenheit = forecastLowInFahrenheit;
	}
	public int getForecastHighInFahrenheit() {
		return forecastHighInFahrenheit;
	}
	public void setForecastHighInFahrenheit(int forecastHighInFahrenheit) {
		this.forecastHighInFahrenheit = forecastHighInFahrenheit;
	}
	public int getForecastLowInCelsius() {
		forecastLowInCelsius = (int)((forecastLowInFahrenheit - 32) / 1.8);
		return forecastLowInCelsius;
	}
	public int getForecastHighInCelsius() {
		forecastHighInCelsius = (int)((forecastHighInFahrenheit - 32) / 1.8);
		return forecastHighInCelsius;
	}
	public void setForecastLowInCelsius(int forecastLowInCelsius) {
		this.forecastLowInCelsius = forecastLowInCelsius;
	}
	public void setForecastHighInCelsius(int forecastHighInCelsius) {
		this.forecastHighInCelsius = forecastHighInCelsius;
	}
	public String getForecastDescription() {
		return forecastDescription;
	}
	public void setForecastDescription(String forecastDescription) {
		this.forecastDescription = forecastDescription;
	}
	public String getWeatherTips() {
		String weatherTips = null;
		if(forecastDescription.equals("snow")) {
			weatherTips = "Make sure to bring snowshoes! ";
		} else if (forecastDescription.equals("rain")) {
			weatherTips = "Make sure to pack rain gear and wear waterproof shoes! ";
		} else if (forecastDescription.equals("thunderstorms")) {
			weatherTips = "WARNING: seek shelter and avoid hiking on exposed ridges or mountaintops. ";
		} else if (forecastDescription.equals("sunny")) {
			weatherTips = "Make sure to pack sunblock to avoid harmful sun rays! ";
		} else {
			weatherTips = "Check with the ranger station before embarking on your trip. ";
		}
		
		if (forecastHighInFahrenheit > 75) {
			weatherTips += "It'll be hot outside! Be sure to bring an extra gallon of water with you. ";
		} 
		if (forecastLowInFahrenheit < 20) {
			weatherTips += "Danger! The temperature will be frigid. Beware of frostbite. ";
		}
		if (forecastHighInFahrenheit - forecastLowInFahrenheit > 20) {
			weatherTips += "Be sure to wear breathable layers.";
		}
		return weatherTips;
	}
	public String getDayOfWeek() {
		LocalDate today = LocalDate.now();
		if (forecastDay.equals("1")) {
			dayOfWeek = DAYS_OF_WEEK[today.getDayOfWeek().getValue()];
		} else if (forecastDay.equals("2")) {
			dayOfWeek = DAYS_OF_WEEK[today.getDayOfWeek().getValue() + 1];
		} else if (forecastDay.equals("3")) {
			dayOfWeek = DAYS_OF_WEEK[today.getDayOfWeek().getValue() + 2];
		} else if (forecastDay.equals("4")) {
			dayOfWeek = DAYS_OF_WEEK[today.getDayOfWeek().getValue() + 3];
		} else if (forecastDay.equals("5")) {
			dayOfWeek = DAYS_OF_WEEK[today.getDayOfWeek().getValue() + 4];
		} else {
			dayOfWeek = null;
		}
		return dayOfWeek;
	}
	
}
