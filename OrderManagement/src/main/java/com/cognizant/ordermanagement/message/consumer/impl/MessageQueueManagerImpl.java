package com.cognizant.ordermanagement.message.consumer.impl;

import java.util.HashMap;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ordermanagement.message.consumer.interfaces.MessageQueueManager;


public class MessageQueueManagerImpl implements MessageQueueManager {

	private AmqpAdmin admin;
	
	private AmqpTemplate template;

	private ConnectionFactory connectionFactory;
	
	private SimpleMessageListenerContainer container;	

	public AmqpAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(AmqpAdmin admin) {
		this.admin = admin;
	}

	public AmqpTemplate getTemplate() {
		return template;
	}

	public void setTemplate(AmqpTemplate template) {
		this.template = template;
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public SimpleMessageListenerContainer getContainer() {
		return container;
	}

	public void setContainer(SimpleMessageListenerContainer container) {
		this.container = container;
	}

	@Override
	public String createQueue(String queueName) {
		// Log.debug("creating queue with name: " + queueName);

		// create queue
		Queue newQueue = new Queue(queueName, true, false, true);
		queueName = admin.declareQueue(newQueue);

		// create binding with exchange
		admin.declareBinding(new Binding(queueName, DestinationType.QUEUE, "directExchange", queueName,
				new HashMap<String, Object>()));

		// Log.debug("queue successfully created: " + queueName);

		// add queue to listener
		container.addQueues(newQueue);

		// start listener
		container.start();
		return queueName;
	}

	@Override
	public void sendMessage(String message, String destinationQueueName) throws Exception {
		template.convertAndSend("directExchange", destinationQueueName,
				MessageBuilder.withBody(message.getBytes()).build());		
	}

	@Override
	public void onMessage(Message message) {
		System.out.println(new String(message.getBody()));
		MessageProperties messageProperties = message.getMessageProperties();
		messageProperties.getType();
		System.out.println(messageProperties.getAppId());
		System.out.println(new String(message.getBody()));
	}
}