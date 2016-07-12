package com.techelevator.npgeek.model.weather;

import java.util.List;

public interface WeatherForecastDAO {
	
	public List<WeatherForecast> getAllForecastsByParkCode(String parkCode);

	WeatherForecast getCurrentWeather(String parkCode);
	
 
}
