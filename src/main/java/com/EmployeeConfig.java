package com;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* @Bean is used to convert object into bean
 * 
 * @Primary is used to give the preference to the bean 
 * It can be placed above the class and above the methods
 * 
 * @Qualifier is used to specify which bean should be injected
 * into the non primitive data type
 * It follows @Autowired
 * It can be placed above the field
 */

@Configuration
public class EmployeeConfig {
	
	@Bean
	public Scanner scannerBean() {
		return new Scanner(System.in);
	}
}
