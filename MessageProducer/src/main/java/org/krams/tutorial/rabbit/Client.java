package org.krams.tutorial.rabbit;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Sample client for sending messages to RabbitMQ
 * 
 *  @author Krams at {@link http://krams915@blogspot.com}
 */
public class Client {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml", Client.class);
		
		// Retrieve the MessageSender bean
		MessageSender sender = (MessageSender) applicationContext.getBean("messageSender");
		
		// Create a new MessageProperties
		// Assign custom header and content type
		MessageProperties properties = new MessageProperties();
    	properties.setHeader("keyword", "SALES");
    	properties.setContentType("text/plain");
    	// Send the message
		sender.send("1234567;Branch A;SALES;3000.50;Pending approval", properties);
		
		// Create a new MessageProperties
		// Assign custom header and content type
		properties = new MessageProperties();
    	properties.setHeader("keyword", "INVENTORY");
    	properties.setContentType("text/plain");
    	// Send the message
		sender.send("1234568;Branch A;INVENTORY;Printer;30;10", properties);
		
		// Create a new MessageProperties
		// Assign custom header and content type
		properties = new MessageProperties();
    	properties.setHeader("keyword", "ORDER");
    	properties.setContentType("text/plain");
    	// Send the message
		sender.send("1234569;Branch B;ORDER;Keyboard;50", properties);
	}
}
