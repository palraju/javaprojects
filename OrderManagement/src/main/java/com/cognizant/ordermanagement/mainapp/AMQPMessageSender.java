package com.cognizant.ordermanagement.mainapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.ordermanagement.message.consumer.impl.MessageQueueManagerImpl;
import com.cognizant.ordermanagement.message.consumer.interfaces.MessageQueueManager;

public class AMQPMessageSender {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		/*MessageQueueManager manager = applicationContext.getBean(MessageQueueManagerImpl.class);
		manager.createQueue("myTestQueue");
		for(int i=0;i<100;i++){
			manager.sendMessage("myTestMessage"+i, "myTestQueue");
		}	*/	
	}
}
