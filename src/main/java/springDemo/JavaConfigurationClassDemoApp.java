package springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigurationClassDemoApp {
	
	public static void main(String[] args) {
		// Utilize AnnotationConfigApplicationContext instead ClassPathXmlApplicationContext for Java configuration class
		// "container1" is for the configuration class using @ComponentScan, and "container2" is for the one not using it
		AnnotationConfigApplicationContext container1 = new AnnotationConfigApplicationContext(ConfigurationWithComponentScan.class);
		AnnotationConfigApplicationContext container2 = new AnnotationConfigApplicationContext(ConfigurationWithoutComponentScan.class);
		
		Coach coach1 = container1.getBean("footballCoach", Coach.class);
		Coach coach2 = container1.getBean("soccer", Coach.class);
		Coach coach3 = container1.getBean("footballCoach", Coach.class);
		// The object  in "coach4" variable contain data retrieved from the properties file "coachInformation.properties"
		// The object also have custom code that will be executed during the bean initialization and destruction
		TennisCoach coach4 = container1.getBean("tennisCoach", TennisCoach.class);
				
		System.out.println(coach1.getAdditionalInformation());
		System.out.println(coach2.getAdditionalInformation() + "\n");
		
		// Check the address of "coach1" and "coach3" to verify they are different from each other, indicating prototype scope
		System.out.println(coach1);
		System.out.println(coach3 + "\n");
		
		// data retrieved from the properties file
		System.out.println(coach4.coachPersonalInformation() + "\n\n\n");
		
		BaseballCoach coach5 = container2.getBean("baseballCoach", BaseballCoach.class);
		System.out.println(coach5.getAdditionalInformation() + "\n" + coach5.coachPersonalInformation());
		
		container1.close();

	}
}
