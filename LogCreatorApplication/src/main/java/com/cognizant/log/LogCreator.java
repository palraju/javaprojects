package com.cognizant.log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogCreator {
	static Logger log = Logger.getLogger(LogCreator.class.getName());
	static String[] patternArray = { "STP Error", "File Error", "Web Service Error", "SQL Error", "DB Error", "SAX Error" };
    static String DIR = "C:\\Raju\\ProjectWorkSpace\\LogCreatorApplication\\src\\main\\resources\\";
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		int count = 0;
		int randomNum = 0;
		
		PropertyConfigurator.configure(DIR +"\\"+"log4j.properties");
		while (count < 200) {
			Thread.sleep(50l);
			randomNum = (1 + (int) (Math.random() * 100)) % 7;
			log.debug("[Application1] Hello this is a debug message");
			log.info("[Application1] Hello this is an info message");
			try {
				if (randomNum == 5) {
					throw new Exception(getRandomError());
				}
			} catch (Exception e) {
				log.error("[Application1]Exception Occurred:" + e);
			}
			count++;
		}
	}

	public static String getRandomError() {
		int rand = ThreadLocalRandom.current().nextInt(1, 10000);
		return patternArray[rand % patternArray.length];
	}
}