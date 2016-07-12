package com.techelevator.npgeek.model.survey;

public class SurveyRecord {

	private String answer;
	private int voteCount;
			
	public SurveyRecord(String record) {
		String[] tally = record.split("\\|");
		answer = tally[0];
		voteCount = Integer.parseInt(tally[1]);
	}
	
	public SurveyRecord(Survey survey) {
		answer = survey.getAnswer();
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getVoteCount() {
		return voteCount;
	}
}
