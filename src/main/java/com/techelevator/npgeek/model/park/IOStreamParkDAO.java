package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class IOStreamParkDAO implements ParkDAO {

	private ParkDataStreamProvider dataStreamProvider;
	
	@Autowired
	public IOStreamParkDAO(ParkDataStreamProvider dataStreamProvider) {
		this.dataStreamProvider = dataStreamProvider;
	}
	
	@Override
	public List<Park> getAllParks() {
		ArrayList<Park> parks = new ArrayList<>();
		try(Scanner scanner = new Scanner(dataStreamProvider.getInputStream())) {
			while(scanner.hasNextLine()) {
				ParkRecord record = new ParkRecord(scanner.nextLine());
				Park park = new Park();
				park.setParkCode(record.getParkCode());
				park.setParkName(record.getParkName());;
				park.setState(record.getState());
				park.setAcreage(record.getAcreage());
				park.setElevationInFeet(record.getElevationInFeet());
				park.setMilesOfTrail(record.getMilesOfTrail());
				park.setNumberOfCampsites(record.getNumberOfCampsites());
				park.setClimate(record.getClimate());
				park.setYearFounded(record.getYearFounded());
				park.setAnnualVisitorCount(record.getAnnualVisitorCount());
				park.setQuote(record.getQuote());
				park.setQuoteSource(record.getQuoteSource());
				park.setDescription(record.getDescription());
				park.setEntryFee(record.getEntryFee());
				park.setNumberOfAnimalSpecies(record.getNumberOfAnimalSpecies());
				parks.add(park);
			}
			return parks;
		}
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park result = null;
		for(Park p : getAllParks()) {
			if(p.getParkCode().equals(parkCode)) {
				result = p;
			}
		}
		return result;
	}

}
