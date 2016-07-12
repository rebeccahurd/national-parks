package com.techelevator.npgeek.model.survey;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IOStreamSurveyDAO implements SurveyDAO {

	private SurveyDataStreamProvider dataStreamProvider;
	
	@Autowired
	public IOStreamSurveyDAO(SurveyDataStreamProvider dataStreamProvider) {
		this.dataStreamProvider = dataStreamProvider;
	}
	
	@Override
	public void saveAnswer(String answer) {
		Map<String, Integer> records = getAllVotes();
		try (PrintWriter writer = new PrintWriter(dataStreamProvider.getOutputStream())) {
			if (records.containsKey(answer)) {
				int count = records.get(answer);
				records.put(answer, count + 1);
			} else {
				records.put(answer, 1);
			}
			for(String key : records.keySet()) {
				writer.println(key + "|" + records.get(key));
			}
		}
	}

	@Override
	public Map<String, Integer> getAllVotes() {
		Map<String, Integer> results = new HashMap<>();
		try(Scanner scanner = new Scanner(dataStreamProvider.getInputStream())) {
			while(scanner.hasNextLine()) {
				SurveyRecord record = new SurveyRecord(scanner.nextLine());
				results.put(record.getAnswer(), record.getVoteCount());
			}
		}
		
		return results;
	}
	
	

}
