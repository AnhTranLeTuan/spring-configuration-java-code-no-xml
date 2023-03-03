package springDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;

// Set this class as the configuration class
@Configuration
// Scan the package for annotations
@ComponentScan("springDemo")
// Provide where is the properties file for retrieving data
@PropertySource("classpath:coachInformation.properties")
public class ConfigurationWithComponentScan {
	
}
