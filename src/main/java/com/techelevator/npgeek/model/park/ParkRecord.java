package com.techelevator.npgeek.model.park;

public class ParkRecord {

	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private String yearFounded;
	private int annualVisitorCount;
	private String quote;
	private String quoteSource;
	private String description;
	private String entryFee;
	private int numberOfAnimalSpecies;
	
	public ParkRecord(String record) {
		String[] recordParts = record.split("\\t");
		parkCode = recordParts[0];
		parkName = recordParts[1];
		state = recordParts[2];
		acreage = Integer.parseInt(recordParts[3]);
		elevationInFeet = Integer.parseInt(recordParts[4]);
		milesOfTrail = Double.parseDouble(recordParts[5]);
		numberOfCampsites = Integer.parseInt(recordParts[6]);
		climate = recordParts[7];
		yearFounded = recordParts[8];
		annualVisitorCount = Integer.parseInt(recordParts[9]);
		quote = recordParts[10];
		quoteSource = recordParts[11];
		description = recordParts[12];
		entryFee = recordParts[13];
		numberOfAnimalSpecies = Integer.parseInt(recordParts[14]);
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public String getState() {
		return state;
	}
	public int getAcreage() {
		return acreage;
	}
	public int getElevationInFeet() {
		return elevationInFeet;
	}
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public String getYearFounded() {
		return yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public String getQuote() {
		return quote;
	}
	public String getQuoteSource() {
		return quoteSource;
	}
	public String getDescription() {
		return description;
	}
	public String getEntryFee() {
		return entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public void setYearFounded(String yearFounded) {
		this.yearFounded = yearFounded;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}

	
}
