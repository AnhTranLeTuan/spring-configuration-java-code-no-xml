package springDemo;

import org.springframework.beans.factory.annotation.Value;

import springDemo.service.AdditionalService;


public class BaseballCoach implements Coach {
	
	AdditionalService service;
	@Value("${DOB}")
	private String dob;
	@Value("${Country}")
	private String country;
	
	public BaseballCoach(AdditionalService service) {
		this.service = service;
	}
	
	@Override
	public String getExercises() {
		return "Baseball Exercises";
	}

	@Override
	public String getAdditionalInformation() {
		
		return service.additionalService();
	}
	
	public String coachPersonalInformation() {
		return "DOB: " + dob + "\n"
			+  "Country: " + country;
	}
	
}
