package com.fis.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.controller.EmployeeController;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws java.text.ParseException {
//		SpringApplication.run(SpringLearnApplication.class, args);
//		displayDate();
//		displayCountry();
//		displayCountries();
//		displayEmployee();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeController.class);
		displayEmployeeControllerAnnotation(applicationContext);
	}
	
	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext)
	{
		LOGGER.info("START");
		
		EmployeeController employeeController = applicationContext.getBean("employeeController", EmployeeController.class);
		
		LOGGER.debug("EmployeeController : {}", employeeController);
		LOGGER.info("END");

	}
	
	static void getEmployeeController()
	{
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EmployeeController employeeController = context.getBean("controller", EmployeeController.class);
		
		LOGGER.debug("EmployeeController : {}", employeeController);
		context.close();
		LOGGER.info("END");
	}
	
	static void displayEmployee()
	{
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = context.getBean("employee", Employee.class);
		
		LOGGER.debug("Employee : {}", employee);
		context.close();
		LOGGER.info("END");
		
	}

	static void displayCountries() {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
		
		LOGGER.debug("CountryList : {}", countryList);
		
		LOGGER.info("END");
		
		context.close();
		
	}

	static void displayCountry() 
	{
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		
		context.close();
		
	}

	static void displayDate() {
		LOGGER.info("START");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date parseDate = null;
		try {
			parseDate = format.parse("31/12/2018");
//			System.out.println(parseDate);
			LOGGER.debug(parseDate.toString());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.close();

		LOGGER.info("END");
	}

}
