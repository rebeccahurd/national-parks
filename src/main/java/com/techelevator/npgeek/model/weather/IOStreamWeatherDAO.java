package com.techelevator.npgeek.model.weather;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IOStreamWeatherDAO implements WeatherForecastDAO{

	private WeatherDataStreamProvider dataStreamProvider;
	
	@Autowired
	public IOStreamWeatherDAO(WeatherDataStreamProvider dataStreamProvider) {
		this.dataStreamProvider = dataStreamProvider;
	}
	
	@Override
	public List<WeatherForecast> getAllForecastsByParkCode(String parkCode) {
		ArrayList<WeatherForecast> forecasts = new ArrayList<>();
		try(Scanner scanner = new Scanner(dataStreamProvider.getInputStream())) {
			while(scanner.hasNextLine()) {
				WeatherForecastRecord record = new WeatherForecastRecord(scanner.nextLine());
				WeatherForecast forecast = new WeatherForecast();
				if(record.getParkCode().equals(parkCode)){	
					forecast.setParkCode(record.getParkCode());
					forecast.setForecastDay(record.getForecastDay());
					forecast.setForecastLowInFahrenheit(record.getForecastLow());
					forecast.setForecastHighInFahrenheit(record.getForecastHigh());
					forecast.setForecastDescription(record.getForecastDescription());
					forecasts.add(forecast);
				}
			}
			return forecasts;
		}
	}
	
	@Override
	public WeatherForecast getCurrentWeather(String parkCode) {
		List<WeatherForecast> forecasts = getAllForecastsByParkCode(parkCode);
		return forecasts.get(0);
	}
}
