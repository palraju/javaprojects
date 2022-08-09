package com.cognizant.amqp;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class AMQPSender {
	private final static String QUEUE_NAME = "TestQueue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "Hello World!";
	    for(int i=0;i<1000;i++){
	    	message = "Hello World!" + (i+1);
	    	channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
	    }
	    System.out.println(" [x] Sent '" + message + "'");	
	    channel.close();
	    connection.close();
	}
}
