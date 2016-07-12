package com.techelevator.npgeek.model.park;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParkDataFileStreamProvider implements ParkDataStreamProvider {

	private File parkDataFile;
	
	@Autowired
	public ParkDataFileStreamProvider(@Value("classpath:data_config.properties") InputStream configData) {
		Properties config = loadConfiguration(configData);
		parkDataFile = new File(config.getProperty("parkDataPath"));
	}
	
	@Override
	public InputStream getInputStream() {
		try {
			if(!parkDataFile.exists()) {
				parkDataFile.createNewFile();
			}
			return new FileInputStream(parkDataFile);
		} catch (IOException e) {
			throw new RuntimeException("Could not find or create park data file: " + parkDataFile.getAbsolutePath(), e);
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
