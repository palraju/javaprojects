package com.cognizant.amqp;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class AMQPSubscriber {
	private static final String EXCHANGE_NAME = "logsRouter";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
	    //channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	    String queueName = channel.queueDeclare().getQueue();
	   // channel.queueBind(queueName, EXCHANGE_NAME, "");
	    channel.queueBind(queueName, EXCHANGE_NAME, "red");

	    System.out.println(" [*] Hey I am waiting for red messages!!");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope,
	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
	        String message = new String(body, "UTF-8");
	        //System.out.println(" [x] Received '" + message + "'");
	        System.out.println(" [x] Received '" + envelope.toString()+ "':'" + message + "'");
	      }
	    };
	    channel.basicConsume(queueName, true, consumer);	    
	}
}
