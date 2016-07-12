package com.techelevator.npgeek.model.survey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SurveyDataFileStreamProvider implements SurveyDataStreamProvider {

	private File surveyDataFile;
	
	@Autowired 
	public SurveyDataFileStreamProvider(@Value("classpath:data_config.properties") InputStream configData) {
		Properties config = loadConfiguration(configData);
		surveyDataFile = new File(config.getProperty("surveyDataPath"));
		
	}
	
	@Override
	public InputStream getInputStream() {
		try {
			if(!surveyDataFile.exists()) {
				surveyDataFile.createNewFile();
			}
			return new FileInputStream(surveyDataFile);
		} catch (IOException e) {
			throw new RuntimeException("Could not find or create survey data file: " + surveyDataFile.getAbsolutePath(), e);
		}
	}

	@Override
	public OutputStream getOutputStream() {
		try {
			return new FileOutputStream(surveyDataFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Could not find or create survey data file: " + surveyDataFile.getAbsolutePath(), e);
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
