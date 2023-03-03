package springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springDemo.service.FirstService; 

@Configuration
// @PropertySource allow data from the properties file automatically to be injected into the fields with @Value, no @ComponentScan required
@PropertySource("classpath:coachInformation.properties")
public class ConfigurationWithoutComponentScan {
	 
	public FirstService firstService() {
		FirstService service = new FirstService();
		return service;
	}
	
	// Define the bean in this class, as well as injecting the dependency into it without having to scan to other classes
	
	@Bean
	public BaseballCoach baseballCoach() {
		BaseballCoach baseballCoach = new BaseballCoach(firstService());
		return baseballCoach;
		
	}

}
