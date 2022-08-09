package com.cognizant.springamqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPPublisher {

	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("rabbit-spring.xml");
		RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
		template.convertAndSend("myExchange", "foo.bar", "Hello, world!");
		Thread.sleep(1000);
		ctx.destroy();		
	}

}
