package com.techelevator.npgeek.model.survey;

import java.util.List;
import java.util.Map;

public interface SurveyDAO {

	public void saveAnswer(String answer);
	public Map<String, Integer> getAllVotes();
}
