package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.survey.SurveyDAO;
import com.techelevator.npgeek.model.weather.WeatherForecastDAO;

@SessionAttributes(value={"completedSurvey","parks","tempIsCelsius"})
@Controller
public class ParkController {

	private ParkDAO parkDAO;
	private WeatherForecastDAO weatherForecastDAO;
	private SurveyDAO surveyDAO;
	
	@Autowired
	public ParkController(ParkDAO parkDAO, WeatherForecastDAO weatherForecastDAO, SurveyDAO surveyDAO) {
		this.parkDAO = parkDAO;
		this.weatherForecastDAO = weatherForecastDAO;
		this.surveyDAO = surveyDAO;
	}
	
	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET) 
	public String displayParkList(ModelMap model) {		
		model.put("parks", parkDAO.getAllParks());
		return "home";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(ModelMap model,
								@RequestParam(required=false) boolean completedSurvey) {
		model.put("parks", parkDAO.getAllParks());
		model.put("completedSurvey", completedSurvey);
		model.put("surveyResponses", surveyDAO.getAllVotes());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(@RequestParam String answer,
							   @RequestParam boolean completedSurvey,
							   ModelMap model) {
		surveyDAO.saveAnswer(answer);
		model.put("completedSurvey", completedSurvey);
		return "redirect:/survey";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(ModelMap model,
									@RequestParam String parkCode,
									@RequestParam(required=false) boolean tempIsCelsius) {
		model.put("park", parkDAO.getParkByCode(parkCode));
		model.put("tempIsCelsius", tempIsCelsius);
		model.put("parkWeather", weatherForecastDAO.getCurrentWeather(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping(path="/parkWeather", method=RequestMethod.GET)
	public String displayParkWeatherPage(ModelMap model,
										@RequestParam String parkCode,
										@RequestParam(required=false) boolean tempIsCelsius) {
		model.put("park", parkDAO.getParkByCode(parkCode));
		model.put("weatherForecasts", weatherForecastDAO.getAllForecastsByParkCode(parkCode));
		model.put("tempIsCelsius", tempIsCelsius);
		return "parkWeather";
	}
}