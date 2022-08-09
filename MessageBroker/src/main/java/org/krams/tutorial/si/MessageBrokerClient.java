package org.krams.tutorial.si;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageBrokerClient {
	private static final Logger logger = Logger.getLogger(MessageBrokerClient.class); 
	public static void main(String[] args) {
		// open/read the application context file		
		final String LOG_FILE = "C:/Raju/ProjectWorkSpace/MessageBroker/src/main/resources/log4j.properties";
		Properties logProp = new Properties();
		try {
			logProp.load(new FileInputStream(LOG_FILE));
			PropertyConfigurator.configure(logProp);
			logger.info("Logging enabled");
		} catch (IOException e) {
			System.out.println("Logging not enabled"+e);
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Hello World");
	}

}
