package org.krams.tutorial.rabbit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Performs the actual sending of messages
 * 
 *  @author Krams at {@link http://krams915@blogspot.com}
 */
public class MessageSender {

	protected Logger logger = Logger.getLogger("client");
	
    @Resource(name="rabbitTemplate")
    private RabbitTemplate rabbitTemplate;
    
    @Resource(name="amqpAdmin")
    AmqpAdmin amqpAdmin;
    
    public static final String QUEUE_NAME = "inbound.order.recv.queue";
    
    public void send(String text, MessageProperties properties) {
    	// Create a queue
		Queue customQueue = new Queue(QUEUE_NAME,true);			
		// Assign to broker
		amqpAdmin.declareQueue(customQueue);
		
		// Wrapped our custom text and properties as a Message
    	Message message = new Message(text.getBytes(), properties);
    	
    	// Send the Message object
    	// Here we provided a blank exchange: The default exchange
    	rabbitTemplate.send("", QUEUE_NAME, message);

    	logger.debug("Message sent: " + text);
    }

}
