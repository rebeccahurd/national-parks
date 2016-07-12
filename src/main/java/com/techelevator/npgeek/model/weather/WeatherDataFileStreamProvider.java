package com.techelevator.npgeek.model.weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataFileStreamProvider implements WeatherDataStreamProvider {

	private File weatherDataFile;
	
	@Autowired
	public WeatherDataFileStreamProvider(@Value("classpath:data_config.properties") InputStream configData) {
		Properties config = loadConfiguration(configData);
		weatherDataFile = new File(config.getProperty("weatherDataPath"));
	
	}
	
	@Override
	public InputStream getInputStream() {
		try {
			if(!weatherDataFile.exists()) {
				weatherDataFile.createNewFile();
			}
			return new FileInputStream(weatherDataFile);
 		} catch (IOException e) {
 			throw new RuntimeException("Could not find or create weather data file: " + weatherDataFile.getAbsolutePath(), e);
 		}
	}
	
	private Properties loadConfiguration(InputStream configData) {
		try {
			Properties config = new Properties();
			config.load(configData);
			return config;
		} catch (IOException e) {
			throw new RuntimeException("An error occurred while loading config file", e);
		}
	}
}
