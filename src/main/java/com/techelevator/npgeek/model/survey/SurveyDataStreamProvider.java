package com.techelevator.npgeek.model.survey;

import java.io.InputStream;
import java.io.OutputStream;

public interface SurveyDataStreamProvider {

	public InputStream getInputStream();
	public OutputStream getOutputStream();
}
